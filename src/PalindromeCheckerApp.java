import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    private static boolean checkPalindrome(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return checkPalindrome(s, start + 1, end - 1);
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.");

        String input = "madam";
        boolean isPalindrome = true;

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);

        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        boolean isPalindromeReverse = input.equals(reversed);
        System.out.println("Reversed text: " + reversed);
        System.out.println("Is it a Palindrome (Reverse Check)? : " + isPalindromeReverse);

        String input4 = "radar";
        char[] chars = input4.toCharArray();

        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome4 = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome4 = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("Input : " + input4);
        System.out.println("Is Palindrome? : " + isPalindrome4);

        String input5 = "noon";
        Stack<Character> stack5 = new Stack<>();

        for (char c : input5.toCharArray()) {
            stack5.push(c);
        }

        boolean isPalindrome5 = true;

        for (char c : input5.toCharArray()) {
            if (c != stack5.pop()) {
                isPalindrome5 = false;
                break;
            }
        }

        System.out.println("Input : " + input5);
        System.out.println("Is Palindrome? : " + isPalindrome5);

        String input6 = "civic";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack6 = new Stack<>();

        for (char c : input6.toCharArray()) {
            queue.add(c);
            stack6.push(c);
        }

        boolean isPalindrome6 = true;

        while (!queue.isEmpty()) {
            if (queue.poll() != stack6.pop()) {
                isPalindrome6 = false;
                break;
            }
        }

        System.out.println("Input : " + input6);
        System.out.println("Is Palindrome? : " + isPalindrome6);

        String input7 = "refer";
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input7.toCharArray()) {
            deque.add(c);
        }

        boolean isPalindrome7 = true;

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindrome7 = false;
                break;
            }
        }

        System.out.println("Input : " + input7);
        System.out.println("Is Palindrome? : " + isPalindrome7);

        String input8 = "level";
        LinkedList<Character> list = new LinkedList<>();

        for (char c : input8.toCharArray()) {
            list.add(c);
        }

        boolean isPalindrome8 = true;

        while (list.size() > 1) {
            if (list.removeFirst() != list.removeLast()) {
                isPalindrome8 = false;
                break;
            }
        }

        System.out.println("Input : " + input8);
        System.out.println("Is Palindrome? : " + isPalindrome8);

        String input9 = "madam";
        boolean isPalindrome9 = checkPalindrome(input9, 0, input9.length() - 1);

        System.out.println("Input : " + input9);
        System.out.println("Is Palindrome? : " + isPalindrome9);

        String input10 = "A man a plan a canal Panama";
        String normalized = input10.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindrome10 = true;

        for (int i = 0; i < normalized.length() / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                isPalindrome10 = false;
                break;
            }
        }

        System.out.println("Input : " + input10);
        System.out.println("Is Palindrome? : " + isPalindrome10);

        PalindromeService service = new PalindromeService();
        String input11 = "racecar";
        boolean isPalindrome11 = service.checkPalindrome(input11);

        System.out.println("Input : " + input11);
        System.out.println("Is Palindrome? : " + isPalindrome11);

        PalindromeStrategy strategy = new StackStrategy();
        String input12 = "level";
        boolean isPalindrome12 = strategy.check(input12);

        System.out.println("Input : " + input12);
        System.out.println("Is Palindrome? : " + isPalindrome12);

        String input13 = "level";
        PalindromeStrategy perfStrategy = new StackStrategy();

        long startTime = System.nanoTime();
        boolean isPalindrome13 = perfStrategy.check(input13);
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("Input : " + input13);
        System.out.println("Is Palindrome? : " + isPalindrome13);
        System.out.println("Execution Time : " + executionTime + " ns");
    }
}

class PalindromeService {

    public boolean checkPalindrome(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}