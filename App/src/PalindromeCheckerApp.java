import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.println("===== Stack-Based Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Optional: Normalize input (remove spaces and ignore case)
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        // Push characters into stack
        for (int i = 0; i < processedInput.length(); i++) {
            stack.push(processedInput.charAt(i));
        }

        // Pop characters to create reversed string
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        // Compare original and reversed
        if (processedInput.equals(reversed)) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}