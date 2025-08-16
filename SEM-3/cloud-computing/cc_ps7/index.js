import express from 'express'

let app = express()
let port = 5000

app.use(express.json())

app.get("/", (req, res) => {
    return res.json({
        "message": "server is running"
    })
})

app.listen(port, () => {
    console.log("Server is listening in " + port)
})