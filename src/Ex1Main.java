import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                // add your code here
                int num1Value = Ex1.number2Int(num1);
                System.out.println("num1= " + num1 + " is number: " + true + " , value: " + num1Value);

                if (!Ex1.isNumber(num1)) {
                    System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                    continue;
                }

                // Continue asking for the second number
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();
                if (num2.equals("quit")) {
                    break;
                }
                int num2Value = Ex1.number2Int(num2);
                System.out.println("num2= " + num2 + " is number: " + true + " , value: " + num2Value);

                if (!Ex1.isNumber(num2)) {
                    System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                    continue;
                }

                // Ask for the base
                System.out.println("Enter a base for output: (a number [2,16]): ");
                int base = sc.nextInt();

                if (base < 2 || base > 16) {
                    System.out.println("ERR: Base is out of range! (" + base + ")");
                    continue;
                }

                // Perform operations
                String sumInBase = Ex1.int2Number(num1Value + num2Value, base);
                String productInBase = Ex1.int2Number(num1Value * num2Value, base);

                System.out.println(num1 + " + " + num2 + " = " + sumInBase);
                System.out.println(num1 + " * " + num2 + " = " + productInBase);

                // Determine max number
                String[] numbersArray = {num1, num2, sumInBase, productInBase};
                int maxIndex = Ex1.maxIndex(numbersArray);
                System.out.println("Max number over " + java.util.Arrays.toString(numbersArray) + " is: " + numbersArray[maxIndex]);
                /////////////////////
            }
        }
        System.out.println("quiting now...");
    }
}
