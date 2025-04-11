import { generateOtp } from "@/app/utils/otp.utils";
import { ValidateOTPGenerate } from "@/app/validate/otp.validate";
import { NextResponse } from "next/server";

export async function POST(req, res) {
    let body = await req.json()
    try {
        await ValidateOTPGenerate(body)
        let otp = generateOtp()
        await sentMail()
        return NextResponse.json({
            "message": "OTP sent to the email : " + body?.email
        }, { status: 200 })
    } catch (e) {
        return NextResponse.json({
            "message": e.message
        }, { status: 400 })
    }
}