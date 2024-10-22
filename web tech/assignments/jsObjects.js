//
class Rectangle {
    constructor(width, height) {
        this.width = width;
        this.height = height;
    }

    //methods
    area() {
        return this.width * this.height;
    }
    perimeter() {
        return 2 * (this.width + this.height)
    }
}

const rectangles = [new Rectangle(10, 20), new Rectangle(15, 25), new Rectangle(5, 8), new Rectangle(12, 18)]

rectangles.forEach((rect, i) => {
    console.log(`Rectangle ${i + 1}`)
    console.log(`Width : ${rect.width},Height : ${rect.height}`)
    console.log(`Area: ${rect.area()}`)
    console.log(`Perimeter: ${rect.perimeter()}`)
    console.log('---------------------')
})

// PRACTICE IN JS OBJECTS

// 1 to 3

class Book {
    constructor(title, author, yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    addGenre(genre) {
        this.genre = genre
    }
    describe() {
        return `${this.title} is a book written by ${this.author} and published on ${this.yearPublished}`
    }
    print() {
        console.log(`
            Title : ${this.title}
            Author : ${this.author}
            Published Year : ${this.yearPublished}
            --------------------------------------------------
            `)
    }
}

let bookAlchemist = new Book("Alchemist", "Mohan Prasath S", "2023")
bookAlchemist.addGenre("Science Fiction")
console.log(bookAlchemist.describe())

// 4

class Library {
    constructor(name, bookList = []) {
        this.name = name
        this.bookList = bookList
    }
    getListOfBooks() {
        console.log(`Books in ${this.name}`)
        this.bookList.forEach((book, i) =>
            book.print())
    }
}

const lib1 = new Library("PSGCT Library", [bookAlchemist])
lib1.getListOfBooks()

// 5

class Car {
    constructor(make, model, year) {
        this.make = make
        this.model = model
        this.year = year

    }
    getCarDetails() {
        console.log(`
            Car Details
            Make : ${this.make}
            Model : ${this.model}
            Year : ${this.year}
            `)
    }
}

const car = new Car("Toyoto", "Corolla", 2020)
car.getCarDetails()

// 6

class Subject {
    constructor(subject, grade) {
        this.subject = subject
        this.grade = grade
    }
    print() {
        console.log(`${this.subject} : ${this.grade}`)
    }
}
let sub1 = new Subject("mfcs", 'O')
let sub2 = new Subject("spc", 'O')
let sub3 = new Subject("dsa", 'O')
let sub4 = new Subject("dbms", 'O')
let sub5 = new Subject("web tech", 'O')

class Student {
    constructor(name, age, subjects = []) {
        this.name = name
        this.age = age
        this.subjects = subjects
    }
    getSubjectsScore() {
        console.log(`${this.name}'s Grade in the Subjects`)
        this.subjects.forEach((sub, i) =>
            console.log(`${sub.subject} : ${sub.grade}`)
        )
    }
}

const stu1 = new Student("Mohan Prasath S", 20, [sub1, sub2, sub3, sub4, sub5])
stu1.getSubjectsScore()

// 7 to 11

function Movie(title, director, year, genre, rating) {
    return {
        title,
        director,
        year,
        genre,
        rating
    }
}

const movie1 = Movie("TENET", "Chistopher Nolan", 2020, "Science Fiction", 8.5)

console.log(`
    Title : ${movie1.title}
    Rating : ${movie1.rating}
    `)

movie1.duration = 148

let movieString = JSON.stringify(movie1)
console.log(movieString)