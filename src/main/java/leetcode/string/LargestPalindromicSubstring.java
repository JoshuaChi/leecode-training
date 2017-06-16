package leetcode.string;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Joshua on 6/15/17.
 */
public class LargestPalindromicSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();

        String palindromicString = find(text);

        System.out.println(palindromicString);
        scanner.close();
    }

    private static String max = "";

    private static String find(String text) {
        Stack<Character> stack  = new Stack<>();

        int count = 0;

        while ( count < text.length() ) {
            char c = text.charAt(count);
            if (stack.isEmpty()) {
                stack.push(c);
            }
            else {
                char peek = stack.peek();

                if (peek == c) {
                    char top = stack.pop();
                    Stack<Character> stackLeft  = new Stack<>();

                    List<Character> list = new LinkedList<>();


                    while(top == c) {
                        stackLeft.push(top);
                        list.add(c);

                        count++;

                        if (count >= text.length()) {
                            break;
                        }

                        c = text.charAt(count);

                        if (stack.isEmpty()) {
                            break;
                        }

                        top = stack.pop();
                    }

                    remberSubString((Stack<Character>) stackLeft.clone());

                    while (stackLeft.isEmpty() == false) {
                        char leftTop = stackLeft.pop();
                        stack.push(leftTop);
                        count--;
                    }
                }
                else {
                    stack.push(c);
                }
            }

            count++;
        }
        return max;
    }

    private static void remberSubString(Stack<Character> stack) {

        if (max.length() < stack.size()) {

            StringBuffer buffer = new StringBuffer();
            Stack<Character> newStack = new Stack<>();
            while (stack.isEmpty() == false) {
                Character top = stack.pop();
                buffer.append(top);
                newStack.push(top);
            }

            while (newStack.isEmpty() == false) {
                Character top = newStack.pop();
                buffer.append(top);
            }

            max = buffer.toString();
        }

    }
}
