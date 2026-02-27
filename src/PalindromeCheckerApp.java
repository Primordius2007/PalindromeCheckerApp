public class PalindromeCheckerApp {
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
    }
}