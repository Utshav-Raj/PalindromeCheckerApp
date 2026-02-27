import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based strategy (LIFO)
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;

        String processedInput = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : processedInput.toCharArray()) {
            stack.push(ch);
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return processedInput.equals(reversed);
    }
}

// Deque-based strategy (front/rear comparison)
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;

        String processedInput = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();

        for (char ch : processedInput.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

// Context class to use strategy
class PalindromeCheckerContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        return strategy.isPalindrome(input);
    }
}

// Main application
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeCheckerContext checker = new PalindromeCheckerContext();

        System.out.println("===== Strategy Pattern Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose strategy: 1-Stack, 2-Deque");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                checker.setStrategy(new StackStrategy());
                break;
            case 2:
                checker.setStrategy(new DequeStrategy());
                break;
            default:
                System.out.println("Invalid choice. Using StackStrategy by default.");
                checker.setStrategy(new StackStrategy());
        }

        boolean result = checker.check(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}