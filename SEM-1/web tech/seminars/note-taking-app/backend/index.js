import express from 'express'
import mongoose from 'mongoose';
import dotenv from 'dotenv';
import cors from 'cors'
import { NoteModel } from './models/notes.js';

dotenv.config()

const app = express();
app.use(express.json())
app.use(cors())

app.get("/", (req, res) => {
    res.json({
        message: "success"
    }).status(200)
})
app.get("/notes", async (req, res) => {
    const notes = await NoteModel.find()
    res.json({
        message: "success",
        notes: notes
    }).status(200)
})
app.post("/notes", async (req, res) => {
    let { title, brief } = req.body;
    let note = await NoteModel.insertMany([{ title: title, brief: brief }])
    console.log(note[0]._id)
    res.json({
        message: "note created successfully",
        id: note[0]._id
    })
})
app.put("/notes", async (req, res) => {
    let { title, brief, _id } = req.body;
    try {
        let note = await NoteModel.updateOne({ _id }, { title, brief });
        res.json({
            message: "Note updated successfully",
            ...note
        })
    } catch (e) {
        console.log(e.message)
    }

})
app.delete("/note/:_id", async (req, res) => {
    let { _id } = req.params
    try {
        let deletedNote = await NoteModel.deleteOne({ _id: _id })
        console.log(deletedNote)
        res.json({
            message: "Note Deleted Successfully",
        })
    } catch (e) {
        console.log(e)
    }
})
app.listen(5000, () => {
    mongoose.connect(process.env.mokesh)
    console.log("Server is running " + process.env.mokesh)
})