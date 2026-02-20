/**
 * UC2: Print a Hardcoded Palindrome Result
 * Goal: Check if a predefined string is a palindrome and display the result.
 */
public class UseCase2PalindromeCheckerApp {

    public static void main(String[] args) {
        // String Literal - The word we are checking
        String input = "madam";

        // Use StringBuilder to reverse the string
        String reversedInput = new StringBuilder(input).reverse().toString();

        // Conditional Statement to check if original equals reversed
        if (input.equals(reversedInput)) {
            System.out.println("The string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
        }
    }
}