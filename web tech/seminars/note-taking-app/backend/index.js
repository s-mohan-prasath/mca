import express from 'express'
import cors from 'cors'

const app = express();

app.use(express.json())
app.use(cors())

let PORT = 5000;

app.get("/", (req, res) => {
    res.json({
        "message": "success"
    }).status(200)
})
app.get("/notes", (req, res) => {
    res.json({
        "message": "success",
        "notes": notes
    }).status(200)
})

var notes =
    [
        {
            "id": 1,
            "title": "Meeting Notes",
            "brief": "Summary of the main points discussed in the client meeting."
        },
        {
            "id": 2,
            "title": "Project Ideas",
            "brief": "List of potential ideas for upcoming projects and their brief descriptions."
        },
        {
            "id": 3,
            "title": "Shopping List",
            "brief": "Items to purchase for the week, including groceries and essentials."
        },
        {
            "id": 4,
            "title": "Workout Plan",
            "brief": "Outline of daily exercise routines and fitness goals."
        },
        {
            "id": 5,
            "title": "Book Summary",
            "brief": "Key takeaways from the latest book I finished reading."
        }
    ]



app.listen(PORT, () => {
    console.log("server listening on port " + PORT)
})