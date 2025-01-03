import express from 'express'
import mongoose from 'mongoose'
import { config } from 'dotenv'
import cors from 'cors'

import { SubscriberModel } from './models/subscribers.model.js'
import { ValidateAddSubscribers, ValidateUpdateSubscribers } from './validate/subscribers.validate.js'

config()

const app = express()
app.use(express.json())
app.use(cors())

let PORT = 3000

app.get("/", async (req, res) => {
    try {
        let subscribers = await SubscriberModel.find()
        res.json({ message: "Subscribers retrieved Successfully", subscribers })
    } catch (e) {
        res.json({ message: "Could not get Subscribers details", error: e.message })
    }
})
app.get("/search", async (req, res) => {
    const { query } = req.query; // Expecting a search query as a query parameter

    if (!query) {
        return res.status(400).json({ status: "failed", message: "Query parameter is required" });
    }

    try {
        // MongoDB query to find matching websites using regex
        const subscribers = await SubscriberModel.find({
            websites: { $regex: query, $options: "i" } // Case-insensitive search
        });

        return res.status(200).json({ status: "success", subscribers });
    } catch (error) {
        console.error(error);
        return res.status(500).json({ status: "failed", message: "Error occurred while searching", error });
    }
});
app.post("/", async (req, res) => {
    try {
        let subscriberData = req.body;
        await ValidateAddSubscribers(subscriberData)
        let subscriber = await SubscriberModel.create(subscriberData)
        res.json({ message: "Subscriber created Successfully", subscriber })
    } catch (e) {
        res.json({ message: "Could Not Create Subscriber", error: e.message })
    }
})
app.patch("/:_id", async (req, res) => {
    const { _id } = req.params
    try {
        let subscriberData = req.body;
        await ValidateUpdateSubscribers(subscriberData)
        let subscriber = await SubscriberModel.updateOne({ _id }, subscriberData)
        res.json({ message: "Subscriber Updated Successfully", subscriber })
    } catch (e) {
        res.json({ message: "Could not Update Subscribers details", error: e.message })
    }
})
app.delete("/:_id", async (req, res) => {
    const { _id } = req.params
    try {
        await SubscriberModel.deleteOne({ _id })
        res.json({ message: "Subscriber deleted Successfully" })
    } catch (e) {
        res.json({ message: "Could not Delete Subscriber", error: e.message })
    }
})

app.listen(PORT, () => {
    mongoose.connect(process.env.MONGO_URI).then(() => console.log("Database connected"), () => console.log("Could not get connected to the database"))
    console.log("Server is listening on " + PORT)
})