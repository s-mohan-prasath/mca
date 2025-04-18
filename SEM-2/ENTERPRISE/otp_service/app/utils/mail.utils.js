import nodemailer from "nodemailer";

export async function sendMail(to, subject, body) {
    try {
        console.log(process.env.ADMIN_EMAIL + " "+process.env.ADMIN_PASSWORD)
        const transporter = nodemailer.createTransport({
            service: "gmail",
            auth: {
                user: process.env.ADMIN_EMAIL, // Your email
                pass: process.env.ADMIN_PASSWORD, // Your email app password
            },
        });
        const mailOptions = {
            from: process.env.ADMIN_EMAIL,
            to,
            subject,
            text: body,
        };
        await transporter.sendMail(mailOptions);
    } catch (e) {
        throw e;
    }

}
