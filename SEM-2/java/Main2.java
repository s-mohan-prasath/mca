class Parent{
    public Parent(){
        System.out.println("parent");
    }
}
class Child extends Parent{
    public Child() {
        System.out.println("Child");
    }
}
public class Main2 {
    public static void main(String[] args) {
        Integer a = -129,b=-129;
        System.out.println(a==b);
    }
}
