import java.util.*;
import java.math.*;

public class stack_problems {
    public stack_problems() {

    }

    public void prob1(Stack<Integer> s, int[] arr) {
        /*
         * 1) Given a stack of N numbers and an array of numbers. Count the numbers of
         * pop operations required to get each element of the array. Once an element is
         * popped then it’s not pushed back again. Assume that the all the elements from
         * the array present inside the stack initially.
         * Input: N = 5
         * Stack: 6 4 3 2 1
         * Array: 6 3 4 1 2
         * Output: 1 2 0 2 0
         */

        int len = arr.length;
        SLinkedList<Integer> ll = new SLinkedList<>();
        int i = 0, count = 1;
        while (i < len) {
            if (s.peek() != null && arr[i] == s.peek().value) {
                System.out.printf("%d ", count);
                s.pop();
            } else {
                if (ll.isPresent(arr[i])) {
                    System.out.printf("%d ", 0);
                } else {
                    while (arr[i] != s.peek().value) {
                        ll.push(s.pop().value);
                        count++;
                    }
                    System.out.printf("%d ", count);
                    s.pop();
                    count = 1;
                }
            }
            i++;
        }

    }

    public void prob4(String postFix) {
        Stack<String> s = new Stack<>();
        int len = postFix.length();
        int i = 0;
        String c;
        while (i < len) {
            c = postFix.substring(i, i + 1);
            boolean isCharOperator = isOperator(c);
            boolean isStackPeekOperator = (s.isEmpty() == true) ? false : isOperator(s.peek().value);
            if (isCharOperator != true)
                s.push(c);
            else if (isCharOperator == true && isStackPeekOperator != true) {
                int operand1 = Integer.parseInt(s.pop().value);
                int operand2 = Integer.parseInt(s.pop().value);
                int val = doArithmeticOperation(operand1, operand2, c);
                s.push(Integer.toString(val));
            }
            i++;
        }
        System.out.println(s.peek().value);
    }

    public int doArithmeticOperation(int operand1, int operand2, String operator) {
        if (operator.equals("+"))
            return operand1 + operand2;
        else if (operator.equals("-"))
            return operand1 - operand2;
        else if (operator.equals("*"))
            return operand1 * operand2;
        else if (operator.equals("/"))
            return operand1 / operand2;
        else if (operator.equals("%"))
            return operand1 % operand2;
        else if (operator.equals("^"))
            return (int) (Math.pow((double) operand1, (double) operand2));
        return operand2;
    }

    public boolean isOperator(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("%")
                || str.equals("^")) {
            return true;
        } else {
            return false;
        }
    }

    public int findOperatorScore(String op) {
        if (op.equals("^"))
            return 3;
        if (op.equals("*") || op.equals("/") || op.equals("%"))
            return 2;
        else
            return 1;
    }

    public boolean prob3(String exp) {
        // Given an expression string exp , write a program to examine whether the pairs
        // and the orders of “{“ , ”}” , ”(“ , ”)” , ”[“ , ”]” are correct in exp. For
        // example, the program should print true for exp = “[()]{}{[()()]()}” and false
        // for exp = “[(])”
        int len = exp.length();
        int i = 0;
        Stack<String> stack = new Stack<>();
        while (i < len) {
            String c = exp.substring(i, i + 1);
            if (c.equals("[") || c.equals("(") || c.equals("{")) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c.equals("]") && stack.peek().value.equals("[")) {
                    stack.pop();
                } else if (c.equals(")") && stack.peek().value.equals("(")) {
                    stack.pop();
                } else if (c.equals("}") && stack.peek().value.equals("{")) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            i++;
        }
        if (stack.isEmpty() != true)
            return false;
        return true;
    }
}