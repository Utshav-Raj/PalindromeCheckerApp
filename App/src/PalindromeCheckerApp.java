import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Recursive Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome = checkPalindrome(processedInput, 0, processedInput.length() - 1);

        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Recursive method
    public static boolean checkPalindrome(String str, int start, int end) {

        // Base condition: if pointers cross or meet
        if (start >= end) {
            return true;
        }

        // If mismatch found
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return checkPalindrome(str, start + 1, end - 1);
    }
}