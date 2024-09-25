function btnClick() {
  n = prompt("Enter a Number : ", "0");
  x = parseInt(n) % 2;
  if (x == 0) {
    console.log("even number");
  } else {
    console.log("odd number");
  }
}
