import java.util.Scanner;

public class Ceaser_Cipher {
    public static String encrypt(String message, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            // Encrypt uppercase letters
            if (Character.isUpperCase(ch)) {
                char c = (char) (((int) ch + shift - 65) % 26 + 65);
                result.append(c);
            }
            // Encrypt lowercase letters
            else if (Character.isLowerCase(ch)) {
                char c = (char) (((int) ch + shift - 97) % 26 + 97);
                result.append(c);
            }
            // Keep non-alphabetic characters as they are
            else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Method to decrypt the message using Caesar Cipher
    public static String decrypt(String message, int shift) {
        return encrypt(message, 26 - shift); // Decrypt is reverse of encrypt with 26 - shift
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the message and shift value
        System.out.print("Enter the message: ");
        String message = scanner.nextLine();

        System.out.print("Enter the shift value (1-25): ");
        int shift = scanner.nextInt();

        // Input validation for shift value
        if (shift < 1 || shift > 25) {
            System.out.println("Invalid shift value. Please enter a number between 1 and 25.");
            // return;
        }

        // Encrypt the message
        String encryptedMessage = encrypt(message, shift);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Decrypt the message
        String decryptedMessage = decrypt(encryptedMessage, shift);
        System.out.println("Decrypted Message: " + decryptedMessage);

        scanner.close();
    }

}
