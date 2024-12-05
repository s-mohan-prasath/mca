import joi from 'joi'

export async function ValidateAddSubscribers(subscriberData) {
    const schema = joi.object({
        name: joi.string().required().max(50),
        aadharno: joi.string().required().length(12),
        network: joi.string().required().valid("4G", "5G"),
        hobbies: joi.string().required().max(200),
        websites: joi.string().required().max(500),
    })
    return schema.validateAsync(subscriberData)
}
export async function ValidateUpdateSubscribers(subscriberData) {
    const schema = joi.object({
        name: joi.string().max(50),
        aadharno: joi.string().length(12),
        network: joi.string().valid("4G", "5G"),
        hobbies: joi.string().max(200),
        websites: joi.string().max(500),
    })
    return schema.validateAsync(subscriberData)
}