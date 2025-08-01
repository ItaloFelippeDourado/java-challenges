package org.example;

public class StringChallenge {

    public static String StringChallenge(String str) {
        // Remove all non-letter/digit characters and convert to lowercase
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Reverse the cleaned string
        String reversedStr = new StringBuilder(cleanStr).reverse().toString();

        // Compare original cleaned string with its reversed version
        return cleanStr.equals(reversedStr) ? "true" : "false";
    }

    public static void main(String[] args) {
        // Example usage
        String input = "anne, I vote more cars race Rome-to-Vienna";
        System.out.println(StringChallenge(input)); // Output: true
    }
}