import java.util.Scanner;

// Service class following OOP principles
class PalindromeChecker {

    // Public method to check palindrome
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Normalize string (remove spaces and ignore case)
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        // Convert string to character array (internal data structure)
        char[] charArray = processedInput.toCharArray();

        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

// Main application class
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeChecker palindromeChecker = new PalindromeChecker();

        System.out.println("===== Object-Oriented Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = palindromeChecker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}