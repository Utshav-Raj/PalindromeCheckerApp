import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class UseCase6PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        System.out.println("===== Queue + Stack Based Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input (remove spaces and ignore case)
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        // Enqueue and Push characters
        for (int i = 0; i < processedInput.length(); i++) {
            char ch = processedInput.charAt(i);
            stack.push(ch);     // LIFO
            queue.add(ch);      // FIFO
        }

        boolean isPalindrome = true;

        // Compare dequeue (FIFO) with pop (LIFO)
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}