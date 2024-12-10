
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {

    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;
        // add your code here
        if (!isNumber(num)) {// Validate input format
            return -1;
        }
        // Split the input into the number part and the base
        String[] parts = num.split("b");
        int base = getBasis(parts[1]);
        String numberPart = parts[0];

        int decimalValue = 0;
        int power = 1;//Keeps track of base^i

        for (int i = 0; i < numberPart.length(); i++) {
            char c = numberPart.charAt(numberPart.length() - 1 - i);
            int digitValue = getDigitValue(c); // Convert character to its numerical value
            decimalValue += digitValue * power; // Add the weighted digit value
            power *= base; // Increment the power of the base
        }

        ans = decimalValue;
        ////////////////////
        return ans;
    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        // add your code here
        if (a == null || !a.contains("b")) {// Must contain "b" separator
            return false;
        }
        // Split into number part and base part
        String[] parts = a.split("b");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return false;// Invalid format if either part is empty
        }

        int base = getBasis(parts[1]);
        if (base == -1) {// Check if base is valid
            return false;
        }

        // Check each character in the number part
        for (char c : parts[0].toCharArray()) {
            if (!isValidDigit(c, base)) {
                return false;// Invalid digit for the given base
            }
        }

        ////////////////////
        return ans;

    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        // add your code here
        if (num < 0 || base < 2 || base > 16) {// Validate input
            return ans;
        }

        // Perform base conversion
        do {
            int remainder = num % base;
            ans = getCharForDigit(remainder) + ans;// Add digit to the front
            num /= base;
        } while (num > 0);

        ans = ans + "b" + getBaseChar(base); // Append base information
        ////////////////////
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        // add your code here
        if (!isNumber(n1) || !isNumber(n2)) {// Validate both numbers
            return false;
        }
        ans = (number2Int(n1) == number2Int(n2));// Compare their decimal values
        ////////////////////
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        // add your code here
        int maxValue = -1;

        for (int i = 0; i < arr.length; i++) {
            String num = arr[i];
            if (num != null && isNumber(num)) {
                int value = number2Int(num); // Get decimal value
                if (value > maxValue) { // Update max if a larger value is found
                    maxValue = value;
                    ans = i;
                }
            }
        }
        ////////////////////
        return ans;
    }

    //-----------------------------------


    /**
     * Extracts the base from the string representation of a base.
     *
     * @param baseStr the string representation of the base
     * @return the numerical value of the base, or -1 if invalid
     */
    public static int getBasis(String baseStr) {
        if (baseStr.length() != 1) { // Base must be a single character
            return -1;
        }
        char basisInChar = baseStr.charAt(0);
        if (basisInChar >= '2' && basisInChar <= '9') {
            return basisInChar - '0'; // Numerical bases 2-9
        } else if (basisInChar >= 'A' && basisInChar <= 'G') {
            return basisInChar - 'A' + 10; // Bases 10-16
        }
        return -1; // Invalid base
    }

    /**
     * Checks if a character is a valid digit in the given base.
     *
     * @param c the character to check
     * @param base the base
     * @return true if the character is valid, false otherwise
     */
    private static boolean isValidDigit(char c, int base) {
        int value = getDigitValue(c);
        return value >= 0 && value < base;
    }

    /**
     * Converts a character to its numerical value.
     *
     * @param c the character to convert
     * @return the numerical value, or -1 if invalid
     */
    private static int getDigitValue(char c) {
        if (Character.isDigit(c)) {
            return c - '0'; // Numerical digit
        } else if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10; // Alphabetic digit
        }
        return -1; // Invalid character
    }

    /**
     * Converts a numerical digit to its character representation.
     *
     * @param digit the numerical digit
     * @return the character representation
     */
    private static char getCharForDigit(int digit) {
        if (digit < 10) {
            return (char) ('0' + digit); // Numerical digit
        } else {
            return (char) ('A' + (digit - 10)); // Alphabetic digit
        }
    }

    /**
     * Converts a numerical base to its character representation.
     *
     * @param base the numerical base
     * @return the character representation
     */
    private static char getBaseChar(int base) {
        if (base < 10) {
            return (char) ('0' + base); // Numerical base
        } else {
            return (char) ('A' + (base - 10)); // Alphabetic base
        }

    }
}
