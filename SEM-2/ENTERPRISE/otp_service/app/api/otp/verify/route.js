import { verifyOTP } from "@/app/utils/db.utils";
import { ValidateOTPVerify } from "@/app/validate/otp.validate";
import { NextResponse } from "next/server";

export async function POST(req, res) {
    try {
        let body = await req.json()
        await ValidateOTPVerify(body)
        await verifyOTP(body?.email, body?.otp)
        return NextResponse.json({
            "message": "OTP verified Successfully"
        }, { status: 200 })
    } catch (e) {
        return NextResponse.json({
            "error": e.message
        }, { status: 400 })
    }
}