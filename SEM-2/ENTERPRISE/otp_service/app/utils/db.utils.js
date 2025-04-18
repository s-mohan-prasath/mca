"use server";
import mysql from "mysql2/promise";
import { DB_TABLES } from "../config/db_tables";
import { SETTINGS } from "../config/settings";

// Create a connection pool to reuse connections
const pool = mysql.createPool({
    host: process.env.MYSQL_HOST,
    database: process.env.DB_NAME,
    user: process.env.MYSQL_USER,
    password: process.env.MYSQL_PASSWORD,
    waitForConnections: true,
    queueLimit: 0,
});
async function mysqlQuery({ query, values = [] }) {
    console.log(query, values)
    try {
        const [results] = await pool.execute(query, values);
        console.log(results)
        return results;
    } catch (error) {
        throw error
    }
}
export async function upsertVerification(email, otp) {
    try {
        // check already verification exist
        let verifications = await mysqlQuery({
            query: `SELECT * from ${DB_TABLES.OTP_VERIFICATION_TABLE} where email=?`,
            values: [email]
        })

        let now = new Date()
        let expireAt = new Date(now.getTime() + SETTINGS.OTP_VALID_TIME_IN_MINUTES * 60 * 1000)

        // update the verification status
        if (verifications.length != 0) {
            await mysqlQuery({
                query: `UPDATE ${DB_TABLES.OTP_VERIFICATION_TABLE} SET otp=?,expireAt=?,emailSentCount=emailSentCount+1 WHERE email=?`,
                values: [otp, expireAt, email]
            })
        }
        // create new verification
        else {
            await mysqlQuery({
                query: `INSERT INTO ${DB_TABLES.OTP_VERIFICATION_TABLE} (email,otp,expireAt) VALUES (?,?,?)`,
                values: [email, otp, expireAt]
            })
        }
    } catch (e) {
        throw e
    }
}
export async function verifyOTP(email, otp) {
    try {
        // check already verification exist
        let verifications = await mysqlQuery({
            query: `SELECT * from ${DB_TABLES.OTP_VERIFICATION_TABLE} where email=?`,
            values: [email]
        })

        let now = new Date()
        // update the verification status
        if (verifications.length != 0) {
            let verifyData = verifications[0]
            let expireTime = new Date(verifyData?.expireAt)

            console.log("NOW : " + now.toLocaleTimeString() + " | EXPIRE AT : " + expireTime.toLocaleTimeString())

            if (expireTime < now) throw new Error("OTP expired")
            if (verifyData?.otp != otp) throw new Error("Invalid OTP")
            await invalidateOTP(email)
        } else {
            throw new Error("Email verification does not exist")
        }
    } catch (e) {
        throw e
    }
}
export async function invalidateOTP(email) {
    try {
        await mysqlQuery({
            query: `DELETE FROM ${DB_TABLES.OTP_VERIFICATION_TABLE} WHERE email=?`,
            values: [email]
        })
    } catch (e) {
        throw e
    }
}