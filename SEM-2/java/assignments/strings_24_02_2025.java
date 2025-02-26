package assignments;

public class strings_24_02_2025 {
    public static void main(String[] args){
        qn1();
        qn2();
        qn3();
        qn4();
        qn5();
        qn6();
        qn7();
        qn8();
    }

    public static void qn1(){
        String firstName = "Sofia";
        String middleName = "Maria";
        String lastName="Hernandez";
        String initials = firstName.substring(0,1) +
                middleName.substring(0,1) +
                lastName.substring(0,1);
        System.out.println(initials.toLowerCase());
    }
    public static void qn2(){
        String Name = "Mary";
        String color = "blue";
        System.out.println(Name + "'s favorite color is " + color);
    }
    public static void qn3(){
        String Name= "Gabby";
        String sport = "soccer";
        System.out.println(Name + "'s favorite sport is " + sport);
    }
    public static void qn4(){
        String message = "Meet me by the bridge";
        String part = message.substring(0,3);
        String lower = part.toLowerCase();
        System.out.println(lower);
    }
    public static void qn5(){        
        String Name = "Carly";
        String colour = "red";
        System.out.println("Your name is "+Name+" and your favourite color is "+colour);
    }
    public static void qn6(){        
        String Name = "Justin";
        int age = 16;
        System.out.println("Your name is "+Name+" and your age is "+age);
    }
    public static void qn7(){        
        String name1 = "ALEX";
        String firstNameCaps= name1.substring(0,1).toUpperCase()+name1.substring(1,name1.length()).toLowerCase();
        System.out.println(firstNameCaps);
    }
    public static void qn8(){        
        String message = "I am very happy";
        int index = message.indexOf("very ");
        String replaced= message.substring(0,index)+message.substring(index+5);
        System.out.println(replaced);
    }


}