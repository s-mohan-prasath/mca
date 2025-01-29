// QUESTION - 1
var sNo = 0;
class Student {
    //public member properties
    creditForScore1 = 4;
    creditForScore2 = 3;
    //private member properties
    #rollNumber
    #studName
    #totScore1
    #totScore2
    #cgpa
    static SNo;
    // constructor
    constructor(roll, name) {
        this.#rollNumber = roll
        this.#studName = name
        Student.SNo = ++sNo
    }
    //private member functions
    #calculateCGPA() {
        this.#cgpa = (this.#totScore1 * this.creditForScore1 + this.#totScore2 * this.creditForScore2) / (10 * this.creditForScore1 + 10 * this.creditForScore2)
    }
    //public member functions
    displayCGPA(a, b, c, d) {
        this.#totScore1 = a + c
        this.#totScore2 = b + d
        if (this.#totScore1 < 50 || this.#totScore2 < 50) {
            this.#cgpa = 0;
        } else {
            this.#calculateCGPA()
        }
        console.log(sNo + "\t" + this.#rollNumber + "\t" + this.#studName + "\t\t\t" + this.#cgpa.toFixed(2));
    }
}
class Score extends Student {
    #intScore1;
    #intScore2;
    #extScore1;
    #extScore2;
    assignScore(a, b, c, d) {
        this.#intScore1 = a;
        this.#intScore2 = b;
        this.#extScore1 = c;
        this.#extScore2 = d;
    }
    displayStud() {
        super.displayCGPA(this.#intScore1, this.#intScore2, this.#extScore1, this.#extScore2)
    }
}

const stu1 = new Score("24mx115", "Mohan Prasath S")
stu1.assignScore(45, 50, 50, 50);
const stu2 = new Score("24mx112", "Mani")
stu2.assignScore(55, 40, 50, 50);
const stu3 = new Score("24mx212", "Kishore")
stu3.assignScore(50, 45, 45, 50);
const stu4 = new Score("24mx108", "Kalaivanan")
stu4.assignScore(50, 45, 45, 50);
const stu5 = new Score("24mx202", "Aakash")
stu5.assignScore(50, 50, 45, 45);

console.log("_____________________________________________________\n");
console.log("SNo\tRollNo\tName\t\t\tCGPA");
console.log("_____________________________________________________");

stu1.displayStud();
stu2.displayStud();
stu3.displayStud();
stu4.displayStud();
stu5.displayStud();

console.log("_____________________________________________________\n");

// QUESTION 2

let array = Array(5)
array.push(stu1)
array.push(stu2)
array.push(stu3)
array.push(stu4)
array.push(stu5)

console.log("------------Display from Array------------")
// the header
console.log("_____________________________________________________\n");
console.log("SNo\tRollNo\tName\t\t\tCGPA");
console.log("_____________________________________________________");

array.forEach(obj => {
    obj.displayStud()
})