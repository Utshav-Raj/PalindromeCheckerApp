/**
 * UC4: Character Array Based Palindrome Check
 * Goal: Use a char array and two-pointer approach for efficient validation.
 */
public class UseCase4PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "level";

        // Convert string to character array
        char[] charArray = input.toCharArray();

        boolean isPalindrome = true;
        int left = 0;                  // Pointer at the start
        int right = charArray.length - 1; // Pointer at the end

        // Two-Pointer Technique
        while (left < right) {
            // Compare characters at both ends
            if (charArray[left] != charArray[right]) {
                isPalindrome = false;
                break; // Exit early if a mismatch is found
            }
            left++;  // Move forward
            right--; // Move backward
        }

        System.out.println("Input String: " + input);
        if (isPalindrome) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }
    }
}