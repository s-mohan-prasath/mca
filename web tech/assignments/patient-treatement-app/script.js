setInterval(showTime, 1000)
showTime()
function showTime() {
    let date = new Date()
    let timer = document.getElementById('timer')
    timer.innerHTML = date.toLocaleTimeString()
}