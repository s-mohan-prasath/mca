
// BROWSER PROGRAM

function btnClick() {
  n = prompt("Enter a Number : ", "0");
  x = parseInt(n) % 2;
  if (x == 0) {
    console.log("even number");
  } else {
    console.log("odd number");
  }
}

// NODEJS PROMPT PROGRAM

import promptSync from "prompt-sync";
import process from 'process'

// Create an instance of the prompt
const prompt = promptSync();

const getANumber = () => {
  return parseInt(prompt("Enter a Number (m) : "))
}

const prob1 = () => {
  var m = getANumber()
  while (m >= 1) {
    console.log(m)
    m -= 1;
  }
};

const prob2 = () => {
  var m = getANumber()
  if (m < 3) {
    console.log("No Ouput For the given Input")
  } else {
    var i = 2
    while (i < m) {
      console.log(i)
      i += 2
    }
  }
};

const prob3 = () => {
  var i = 97
  while (i <= 122) {
    var c = String.fromCharCode(i)
    console.log(c)
    i++
  }
};

const prob4 = () => {
  var m = getANumber()
  var i = 1
  while (i <= 20) {
    console.log(i + " x " + m + " = " + i * m)
    i++;
  }
};

const prob5 = () => {
  var i = 0;
  while (i <= 127) {
    console.log("ASCII VALUE : " + String.fromCharCode(i) + " DECIMAL " + i)
    i++;
  }
};

const prob6 = () => {
  var m = getANumber()
  var len = 0
  while (m > 0) {
    len++;
    m = parseInt(Math.floor(m / 10))
  }
  console.log("Number of digits in the Number is " + len)
};

const prob7 = () => {
  var m = String(getANumber())
  var len = m.length
  if (len == 1) {
    console.log("Reverse Number is " + m)
  }
  if (len == 2) {
    console.log("Reverse Number is " + m[1] + m[0])
  } else {
    var reversed = m[len - 1] + m.substring(1, len - 1) + m[0]
    console.log("Reversed String is " + reversed);
  }
};

const prob8 = () => {
  let str = String(getANumber())
  let len = str.length;
  let i = len - 1;
  while (i >= 0) {
    process.stdout.write(str[i] + "")
    i--;
  }
};

const prob9 = () => {
  var m = String(getANumber())
  var len = m.length;
  var i, j;
  i = 0;
  j = len - 1;
  while (i < j) {
    if (m[i] != m[j]) {
      console.log("Not a Palindrome")
      return;
    }
    i++;
    j--;
  }
  console.log("Given Number is in Palindrome")
  return
};

const prob10 = () => {
  var m = String(getANumber())
  var map = {}

  var i = 0;
  var len = m.length;
  while (i < len) {
    if (map[m[i]]) {
      map[m[i]]++
    } else {
      map[m[i]] = 1
    }
    i++;
  }

  i = 0;
  while (i < len) {
    console.log("Frequency of digit " + m[i] + " is " + map[m[i]])
    i++
  }

};

const prob11 = () => {
  var num = String(getANumber())
  var arr = num.split("").map((x) => {
    return (x == 1) ? "0" : "1"
  })
  console.log(arr.join(""))
};

while (1) {
  console.log(`
1.	To print all natural numbers in reverse (from  n to 1). – use a while loop.
2.	To find the sum of all even numbers between 1 to n.
3.	To print all alphabets from a to z. – using while loop
4.	To print a multiplication table of any number.
5.	To print all ASCII characters with their values.
6.	To count the number of digits in a number.
7.	To swap first and last digits of a number.
8.	To print the number in reverse. 
9.	To check whether a number is palindrome or not.
10.	To find the frequency of each digit in a given integer.
11.	To find one’s complement of a binary number.
12.	To convert Binary to Decimal number system.
    `);
  var n = parseInt(prompt("ENTER : "));
  switch (n) {
    case 1:
      prob1();
      break;
    case 2:
      prob2();
      break;
    case 3:
      prob3();
      break;
    case 4:
      prob4();
      break;
    case 5:
      prob5();
      break;
    case 6:
      prob6();
      break;
    case 7:
      prob7();
      break;
    case 8:
      prob8();
      break;
    case 9:
      prob9();
      break;
    case 10:
      prob10();
      break;
    case 11:
      prob11();
      break;
    case 12:
      prob12();
      break;
    case 13:
      prob13();
      break;
    default:
      break;
  }
}

const prob13 = () => {
  const n = prompt("Enter a Number: ", "0"); // Prompt for user input
  const x = parseInt(n) % 2; // Check if the number is even or odd

  if (x === 0) {
    console.log("Even Number");
  } else {
    console.log("Odd Number");
  }
};
