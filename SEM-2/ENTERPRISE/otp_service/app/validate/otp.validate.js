import joi from "joi";

export const ValidateOTPGenerate = (otpData) => {
    const Schema = joi.object({
        email: joi.string().email()
    });

    return Schema.validateAsync(otpData);
};
export const ValidateOTPVerify = (otpData) => {
    const Schema = joi.object({
        email: joi.string().email(),
        otp: joi.string().length(4)
    });

    return Schema.validateAsync(otpData);

}