import java.util.Scanner;

public class UseCase8PalindromeCheckerApp {

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Linked List Based Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        if (processedInput.length() == 0) {
            System.out.println("Result: The given string is a Palindrome.");
            return;
        }

        // Step 1: Convert string to linked list
        Node head = new Node(processedInput.charAt(0));
        Node current = head;

        for (int i = 1; i < processedInput.length(); i++) {
            current.next = new Node(processedInput.charAt(i));
            current = current.next;
        }

        // Step 2: Find middle using Fast & Slow pointer
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse second half
        Node secondHalf = reverseList(slow);
        Node firstHalf = head;

        // Step 4: Compare halves
        boolean isPalindrome = true;
        Node tempSecond = secondHalf;

        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        // Step 5: Print result
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Method to reverse a linked list
    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}