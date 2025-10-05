import express from "express";
import http from "http"
import { Server } from "socket.io";

const app = express();
const server = http.createServer(app);
const io = new Server(server, {
    cors: {
        origin: "*", // Allow all origins (for testing)
    },
});
let users = {}

io.on("connection", (socket) => {
    socket.on("user_connect", data => {
        users = { ...users, ...data }
        console.log("Users : ", users)
        io.emit("chat_members", users)
    })
    socket.on("chat_message", (data) => {
        io.emit("chat_message", data)
    })
    socket.on("disconnect", () => {
        io.emit("member_disconnected", users[socket.id]['name'])
        delete users[socket.id]
        io.emit("chat_members", users)
    })
    socket.on("member_connected", (name) => {
        io.emit("member_connected", name)
    })
})

const PORT = 5001;
server.listen(PORT, () => console.log(`🚀 Server running on http://localhost:${PORT}`));