/**
 * UC3: Palindrome Check Using String Reverse (Manual Loop)
 * Goal: Manually reverse a string and compare it to the original.
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // Input string literal
        String original = "radar";
        String reversed = "";

        // Loop: Iterating backwards through the string
        // We start at the last index (length - 1) and move to index 0
        for (int i = original.length() - 1; i >= 0; i--) {
            // String Concatenation: Building a new string character by character
            reversed += original.charAt(i);
        }

        // Compare content using .equals()
        if (original.equals(reversed)) {
            System.out.println("Original: " + original);
            System.out.println("Reversed: " + reversed);
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Original: " + original);
            System.out.println("Reversed: " + reversed);
            System.out.println("Result: It is NOT a Palindrome.");
        }
    }
}