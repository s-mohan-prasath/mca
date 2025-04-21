interface Addable<Type> {
    public int addTo(Type o);
}

class Student implements Addable<Student> {
    int mark;

    public Student(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student scored " + this.mark;
    }

    @Override
    public int addTo(Student o) {
        return this.mark + o.mark;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(100);
        Student s2 = new Student(75);
        System.out.println(s1.addTo(s2));
    }
}