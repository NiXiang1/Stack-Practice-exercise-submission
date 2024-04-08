import java.util.Stack;  
import java.util.Scanner;  
  
public class ParenthesesChecker {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        System.out.print("Enter an expression made up of parentheses: ");  
        String expression = scanner.nextLine();  
          
        if (checkBalancedParentheses(expression)) {  
            System.out.println("The expression is balanced.");  
        } else {  
            System.out.println("The expression is not balanced.");  
        }  
          
        scanner.close();  
    }  
  
    public static boolean checkBalancedParentheses(String expression) {  
        Stack<Character> stack = new Stack<>();  
        char[] chars = expression.toCharArray();  
          
        for (char ch : chars) {  
            if (isOpeningParenthesis(ch)) {  
                stack.push(ch);  
            } else if (isClosingParenthesis(ch)) {  
                if (stack.isEmpty()) {  
                    return false; // No opening parenthesis to match  
                }  
                  
                char top = stack.pop();  
                if (!matches(top, ch)) {  
                    return false; // Parentheses do not match  
                }  
            }  
        }  
          
        return stack.isEmpty(); // All opening parentheses must be matched  
    }  
  
    private static boolean isOpeningParenthesis(char ch) {  
        return ch == '(' || ch == '[' || ch == '{';  
    }  
  
    private static boolean isClosingParenthesis(char ch) {  
        return ch == ')' || ch == ']' || ch == '}';  
    }  
  
    private static boolean matches(char opening, char closing) {  
        if (opening == '(' && closing == ')') return true;  
        if (opening == '[' && closing == ']') return true;  
        if (opening == '{' && closing == '}') return true;  
        return false;  
    }  
}