import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Case-Insensitive & Space-Ignored Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Step 1: Normalize string
        // Remove all spaces using regular expression and convert to lowercase
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Check palindrome using two-pointer technique
        boolean isPalindrome = true;
        int start = 0;
        int end = processedInput.length() - 1;

        while (start < end) {
            if (processedInput.charAt(start) != processedInput.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Step 3: Display result
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}