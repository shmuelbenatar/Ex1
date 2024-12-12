# Ex1 - Number Formatting Converter and Calculator

## Overview
This project is part of the Introduction to Computer Science course at Ariel University. The goal of this assignment is to implement a number formatting converter and calculator, which supports numbers represented as strings in bases ranging from 2 to 16.

## Features
1. **Number Validation**: Check if a given string represents a valid number in the required format (e.g., `123bA`, `100111b2`).
2. **Number Conversion**:
    - Convert valid numbers to their decimal (base 10) equivalent.
    - Convert integers to string representations in any base (2-16).
3. **Operations**:
    - Perform addition and multiplication on two numbers.
    - Display the results in the specified base.
4. **Maximum Value Detection**:
    - Find the largest value among a list of numbers.
5. **Error Handling**: Identify and handle invalid inputs gracefully.
6. **JUnit Tests**: Comprehensive tests to validate the implementation.

## Files
- **`Ex1.java`**: Contains the core logic for number conversion and operations.
- **`Ex1Main.java`**: The main program for user interaction.
- **`Ex1Test.java`**: JUnit test cases to ensure correctness.

## Example Run
### Valid Input
```
Ex1 class solution:
Enter a string as number#1 (or "quit" to end the program): 
100111b2
num1= 100111b2 is number: true , value: 39
Enter a string as number#2 (or "quit" to end the program): 
1677
num2= 1677 is number: true , value: 1677
Enter a base for output: (a number [2,16]): 
16
100111b2 + 1677 = 6B4bG
100111b2 * 1677 = FF7BbG
Max number over [100111b2, 1677, 6B4bG, FF7BbG] is: FF7BbG
```

