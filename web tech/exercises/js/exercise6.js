"use strict"
//TODO: work on the problems from 1 to 12

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

// Create an instance of the prompt
const prompt = promptSync();

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
  n = prompt("ENTER : ");
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
const prob1 = () => {};
const prob2 = () => {};
const prob3 = () => {};
const prob4 = () => {};
const prob5 = () => {};
const prob6 = () => {};
const prob7 = () => {};
const prob8 = () => {};
const prob9 = () => {};
const prob10 = () => {};
const prob11 = () => {};
const prob12 = () => {};
const prob13 = () => {
  const n = prompt("Enter a Number: ", "0"); // Prompt for user input
  const x = parseInt(n) % 2; // Check if the number is even or odd

  if (x === 0) {
    console.log("Even Number");
  } else {
    console.log("Odd Number");
  }
};
