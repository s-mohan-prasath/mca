
import java.util.Scanner;
import java.util.Stack;

public class exercise13 {
    public static void main(String[] args) {
        new browserNavigator().start();
    }

    public static boolean isBalance(String exp) {
        Stack<Character> stack = new Stack<>();
        int len = 0;
        for (int i = 0; i < len; i++) {
            char c = exp.charAt(i);
            if (c == '{' || c == '(' || c == '<' || c == '[')
                stack.push(c);
            else if (stack.empty())
                return false;
            else {
                char top = stack.pop();
                if ((c == '{' && top != '}') || (c == '(' && top != ')') || (c == '[' && top != ']')
                        || (c == '<' && top != '>'))
                    return false;
            }
        }
        return stack.empty();
    }
}

class browserNavigator {
    Stack<String> forwardStack, backwardStack;
    String webPage = null;

    public browserNavigator() {
        forwardStack = new Stack<>();
        backwardStack = new Stack<>();
    }

    public void start() {
        try (Scanner scan = new Scanner(System.in)) {
            int action = 1;
            while (action != 0) {
                System.out.printf(
                        "\nPress 1 : Visit Page\nPress 2 : Go Back\nPress 3 : Go Forward\nPress any number : Exit\nENTER : ");
                action = scan.nextInt();
                switch (action) {
                    case 1 -> {
                        System.out.print("Enter URL of the page to visit : ");
                        webPage = scan.next();
                        this.visit(webPage);
                    }
                    case 2 -> {
                        this.backward();
                    }
                    case 3 -> {
                        this.forward();
                    }
                    default -> {
                        return;
                    }
                }
                System.out.println("BACKWARD STACK : " + backwardStack);
                System.out.println("FORWARD STACK : " + forwardStack);
            }
        }
    }

    private void visit(String url) {
        System.out.println("Navigating to a new page : `" + url + "`");
        backwardStack.push(url);
        forwardStack.clear();
    }

    private void backward() {
        if (backwardStack.empty()) {
            System.out.println("You cannot go back!");
        } else {
            forwardStack.push(backwardStack.pop());
            if (backwardStack.empty()) {
                System.out.println("You are in home page");
            } else {
                System.out.println("Navigating to the page : `" + backwardStack.peek() + "`");
            }
        }
    }

    private void forward() {
        if (forwardStack.empty()) {
            System.out.println("You cannot go forward!");
        } else {
            System.out.println("Going Forward!");
            webPage = forwardStack.pop();
            backwardStack.push(webPage);
            System.out.println("Navigating to the page : `" + webPage + "`");
        }

    }

}