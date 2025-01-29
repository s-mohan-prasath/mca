import mongoose from 'mongoose'

const SubscriberSchema = new mongoose.Schema({
    name: { type: String, required: true },
    aadharno: { type: String, required: true },
    network: { type: String, required: true },
    hobbies: { type: String, required: true },
    websites: { type: String, required: true },
}, {
    timestamps: true
})

export const SubscriberModel = mongoose.model("subscribers", SubscriberSchema)
