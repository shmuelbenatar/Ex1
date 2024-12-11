import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        // implement this test
        assertEquals("1011b2", Ex1.int2Number(11, 2)); // Binary
        assertEquals("180bA", Ex1.int2Number(180, 10)); // Decimal
        assertEquals("7B3bG", Ex1.int2Number(1971, 16)); // Hexadecimal

        // Invalid inputs
        assertEquals("", Ex1.int2Number(-5, 10)); // Negative number
        assertEquals("", Ex1.int2Number(10, 17)); // Invalid base (greater than 16)
        assertEquals("", Ex1.int2Number(10, 1)); // Invalid base (less than 2)
    }
    @Test
    void maxIndexTest() {
        // implement this test
        String[] arr1 = {"1011b2", "1A3bG", "123bA", "0b2"};
        assertEquals(1, Ex1.maxIndex(arr1)); // Largest value is 1A3bG

        String[] arr2 = {"10bA", "FFbG", "77bG", "1001b2"};
        assertEquals(1, Ex1.maxIndex(arr2)); // Largest value is FFbG

        String[] arr3 = {null, "invalid", "", "123bA"};
        assertEquals(3, Ex1.maxIndex(arr3)); // Only valid number is 123bA

        String[] arr4 = {null, "invalid", ""};
        assertEquals(-1, Ex1.maxIndex(arr4)); // No valid numbers

        String[] arr5 = {"10bA", "10bA", "10bA"};
        assertEquals(0, Ex1.maxIndex(arr5)); // All equal, return first index

        String[] arr6 = {"1011b2", "0b2", "123bA"};
        assertEquals(2, Ex1.maxIndex(arr6)); // Largest value is 1A3bG
    }
    @Test
    void isNumberTestWithExamples() {
        // Valid examples from the assignment
        String[] validNumbers = {
                "135bA", "100111b2", "12345b6", "012b5", "123bG", "EFbG"
        };
        for (String num : validNumbers) {
            assertTrue(Ex1.isNumber(num), "Expected valid number: " + num);
        }

        // Invalid examples from the assignment
        String[] invalidNumbers = {
                "b2", "0b1", "123b", "1234b11", "3b3", "-3b5", "3 b4", "GbG", "", null
        };
        for (String num : invalidNumbers) {
            assertFalse(Ex1.isNumber(num), "Expected invalid number: " + num);
        }
    }
    // Add additional test functions - test as much as you can.
    @Test
    void number2IntEdgeCasesTest() {
        // Valid inputs
        assertEquals(135, Ex1.number2Int("135bA")); // Decimal
        assertEquals(39, Ex1.number2Int("100111b2")); // Binary
        assertEquals(1865, Ex1.number2Int("12345b6")); // Base 6

        // Invalid inputs
        assertEquals(-1, Ex1.number2Int("1234bH")); // Base > 16
        assertEquals(-1, Ex1.number2Int("3 b4")); // Invalid space
        assertEquals(-1, Ex1.number2Int("-3b5")); // Negative number
        assertEquals(-1, Ex1.number2Int("")); // Empty string
        assertEquals(-1, Ex1.number2Int(null)); // Null input
    }

    @Test
    void equalsEdgeCasesTest() {
        // Equal numbers
        assertTrue(Ex1.equals("1011b2", "11")); // Binary equals Decimal
        assertTrue(Ex1.equals("7B3bG", "1971bA")); // Hexadecimal equals Decimal

        // Unequal numbers
        assertFalse(Ex1.equals("123bA", "124bA")); // Different values
        assertFalse(Ex1.equals("123bA", null)); // Null comparison
        assertFalse(Ex1.equals("123bA", "invalid")); // Invalid format
    }


}
