import { SETTINGS } from "@/app/config/settings";
import { upsertVerification } from "@/app/utils/db.utils";
import { sendMail } from "@/app/utils/mail.utils";
import { generateOtp } from "@/app/utils/otp.utils";
import { ValidateOTPGenerate } from "@/app/validate/otp.validate";
import { NextResponse } from "next/server";

export async function POST(req, res) {
    try {
        let body = await req.json()
        await ValidateOTPGenerate(body)
        let otp = generateOtp()
        await upsertVerification(body?.email, otp)
        await sendMail(body?.email, "Your OTP Code for OTP Service", `Your OTP code is: ${otp}. It is valid for ${SETTINGS.OTP_VALID_TIME_IN_MINUTES} minutes.`,)
        return NextResponse.json({
            "message": "OTP sent to the email : " + body?.email + ". check the inbox/spam"
        }, { status: 200 })
    } catch (e) {
        return NextResponse.json({
            "error": e.message
        }, { status: 400 })
    }
}