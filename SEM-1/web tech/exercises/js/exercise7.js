var count = 0;
function myFunction() {
    var btn = document.getElementById("button")
    var alert = document.getElementById("alert")
    if (count == 10) {
        btn.disabled = true
        alert.style.visibility = "visible"
        return
    }
    var x = document.getElementById("myDIV");
    if (x.innerHTML === "Hi") {
        x.innerHTML = "GoodMorning!";
    } else {
        x.innerHTML = "Hi";
    }
    count++
}