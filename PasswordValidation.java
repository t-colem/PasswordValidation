import java.util.Scanner;
public class PasswordValidation {
    public static void main(String[] args) {
        // Prompt the user to enter a password
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a password: ");
        // Store input in string "password"
        String password = in.nextLine();
        // If the user didn't enter anything, exit the program
        if (password.isEmpty()){
            System.out.println("You didn't enter anything, try again");
            System.exit(1);
        }
        // Create boolean to test password criteria success, set it to false
        boolean success = false;
        // While success is false,
        while (!success){
            // Check if the length of the password meets the criteria
            boolean isValidLength = isValidPasswordLength(password);
            // Check if the password has the correct amount of numbers to meet the criteria
            boolean hasCorrectNumbers = hasCorrectAmountOfNumbers(password);
            // Check if the password does not start with a number
            boolean doesNotStartWithNum = doesNotStartWithNum(password);
            // Check if the password has at least two upper case characters
            boolean hasTwoUpperCase = hasTwoUpperCase(password);
            // Check if the password has at least one lower case character
            boolean hasLowerCase = hasLowerCase(password);
            // Set success to true if all these conditions are met
            success = methodsCallTest(isValidLength, hasCorrectNumbers, doesNotStartWithNum, hasTwoUpperCase, hasLowerCase);
            // If success is set to true, print out "Password accepted!", otherwise print out "Invalid password, try again!" and prompt the user to try again by resetting password to the next user input
            if (success) {
                System.out.println("Password accepted!");
            } else {
                System.out.println("Invalid password, try again!");
                password = in.nextLine();
            }
        }
    }
    // Created public boolean method to check password length, takes the string 'password' as arguments
    public static boolean isValidPasswordLength(String password) {
        // If the password length is not greater than 8, return false. Otherwise, return true.
        if (password.length() < 8) {
            return false;
        } else
            return true;
    }
    // Created public boolean method to check if the password has the correct amount of numbers, takes the string 'password' as arguments
    public static boolean hasCorrectAmountOfNumbers(String password) {
        // Create new char array defined as theChars to store the password characters into a char array
        char[] theChars = password.toCharArray();
        // Defined a new int to count the number of digits the user has input
        int digitCount = 0;
        // Run a for loop that increments through the length of the password
        for (int i = 0; i < theChars.length; i++) {
            // Starting at the beginning of the inputted password, define a char pass which is then set to each of the characters that the user input each time the loop runs
            char pass = theChars[i];
            // If the loop finds a digit in the users input, increment digit count
            if (Character.isDigit(pass)) {
                digitCount++;
            }
        }
        // Return true when digitCount >= 2, otherwise return false.
        return digitCount >= 2;
    }
    // Created public boolean method to check if the password does not start with a number, which takes the string 'password' as arguments
    public static boolean doesNotStartWithNum(String password) {
        // Define a new char firstChar and set that to the first char within the user inputted password
        char firstChar = password.charAt(0);
        // If the firstChar is a digit, return false. Otherwise, return true.
        if (Character.isDigit(firstChar)) {
            return false;
        } else {
            return true;
        }
    }
    // Created public boolean method to check if the password has at least two upper case letters, which takes the string 'password' as arguments
    public static boolean hasTwoUpperCase(String password) {
        // Create new char array defined as theChars to store the password characters into a char array
        char[] theChars = password.toCharArray();
        // Defined a new int upperCaseCount to count the number of upper case characters the user has input
        int upperCaseCount = 0;
        // Run a for loop that increments through the length of the password
        for (int i = 0; i < password.length(); i++) {
            // Starting at the beginning of the inputted password, define a char check which is then set to each of the characters that the user input each time the loop runs
            char check = password.charAt(i);
            // If any of the chars in the password are uppercase, increment upperCaseCount
            if (Character.isUpperCase(check)) {
                upperCaseCount++;
          }
        }
        // When upperCaseCount >= 2, return true. Otherwise, return false.
        return upperCaseCount >= 2;
    }
    // Created public boolean method to check if the password has at least one lower case letter, which takes the string 'password' as arguments
    public static boolean hasLowerCase(String password) {
        // Create new char array defined as theChars to store the password characters into a char array
        char[] theChars = password.toCharArray();
        // Defined a new int lowerCaseCount to count the number of lower case characters the user has input
        int lowerCaseCount = 0;
        // Run a for loop that increments through the length of the password
        for (int i = 0; i < password.length(); i++) {
            // Starting at the beginning of the inputted password, define a char check which is then set to each of the characters that the user input each time the loop runs
            char check = password.charAt(i);
            // If any of the chars in the password are lowercase, increment lowerCaseCount
            if (Character.isLowerCase(check)) {
                lowerCaseCount++;
            }
        }
        // When lowerCaseCount >= 1, return true. Otherwise, return false.
        return lowerCaseCount >= 1;
    }
    // Define a final boolean method that takes all the test cases as arguments
    public static boolean methodsCallTest(boolean isValidLength, boolean hasCorrectAmountOfNumbers, boolean doesNotStartWithNum, boolean hasTwoUpperCase, boolean hasLowerCase) {

        // If all the password criteria are met, return true, otherwise return false.
        return isValidLength && hasCorrectAmountOfNumbers && doesNotStartWithNum && hasTwoUpperCase && hasLowerCase;
    }
}
/*
Sample Output
---------------
Enter a password: TesT23
Invalid password, try again!
TestTin2
Invalid password, try again!
2TesTing2
Invalid password, try again!
Testing23
Invalid password, try again!
TESTING23
Invalid password, try again!
TesTing23
Password accepted!
*/