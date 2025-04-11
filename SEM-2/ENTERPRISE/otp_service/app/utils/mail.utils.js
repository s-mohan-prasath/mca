import nodemailer from "nodemailer";

export async function sendOTPEmail(email, otp) {
    const transporter = nodemailer.createTransport({
        service: "gmail",
        auth: {
            user: process.env.ADMIN_EMAIL, // Your email
            pass: process.env.ADMIN_PASSWORD, // Your email app password
        },
    });

    const mailOptions = {
        from: process.env.ADMIN_EMAIL,
        to: email,
        subject: "Your OTP Code for OTP Service",
        text: `Your OTP code is: ${otp}. It is valid for 10 minutes.`,
    };

    await transporter.sendMail(mailOptions);
}
