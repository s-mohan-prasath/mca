import joi from "joi";

export const ValidateOTPGenerate = (pageData) => {
    const Schema = joi.object({
        email: joi.string().email()
    });

    return Schema.validateAsync(pageData);
};