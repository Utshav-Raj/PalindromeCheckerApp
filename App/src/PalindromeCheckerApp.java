import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    // Stack-based palindrome
    public static boolean stackPalindrome(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : processed.toCharArray()) stack.push(ch);
        String reversed = "";
        while (!stack.isEmpty()) reversed += stack.pop();
        return processed.equals(reversed);
    }

    // Deque-based palindrome
    public static boolean dequePalindrome(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char ch : processed.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }

    // Recursive palindrome
    public static boolean recursivePalindrome(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        return recursiveHelper(processed, 0, processed.length() - 1);
    }

    private static boolean recursiveHelper(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursiveHelper(str, start + 1, end - 1);
    }

    // Two-pointer palindrome
    public static boolean twoPointerPalindrome(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = processed.length() - 1;
        while (start < end) {
            if (processed.charAt(start) != processed.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Palindrome Performance Comparison =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Measure Stack strategy
        long start = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long end = System.nanoTime();
        long stackTime = end - start;

        // Measure Deque strategy
        start = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        end = System.nanoTime();
        long dequeTime = end - start;

        // Measure Recursive strategy
        start = System.nanoTime();
        boolean recursiveResult = recursivePalindrome(input);
        end = System.nanoTime();
        long recursiveTime = end - start;

        // Measure Two-pointer strategy
        start = System.nanoTime();
        boolean twoPointerResult = twoPointerPalindrome(input);
        end = System.nanoTime();
        long twoPointerTime = end - start;

        // Display results
        System.out.println("\n=== Results ===");
        System.out.printf("Stack-based: %b | Time: %d ns%n", stackResult, stackTime);
        System.out.printf("Deque-based: %b | Time: %d ns%n", dequeResult, dequeTime);
        System.out.printf("Recursive:   %b | Time: %d ns%n", recursiveResult, recursiveTime);
        System.out.printf("Two-pointer: %b | Time: %d ns%n", twoPointerResult, twoPointerTime);

        scanner.close();
    }
}