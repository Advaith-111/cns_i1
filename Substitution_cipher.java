import java.util.Scanner;

public class Substitution_cipher {
    // Alphabet used for reference
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    // Method to encrypt the message using Substitution Cipher
    public static String encrypt(String message, String key) {
        StringBuilder encryptedMessage = new StringBuilder();
        message = message.toUpperCase();

        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            // If character is an alphabetic letter
            if (Character.isLetter(currentChar)) {
                int indexInAlphabet = ALPHABET.indexOf(currentChar);
                char encryptedChar = key.charAt(indexInAlphabet);
                encryptedMessage.append(encryptedChar);
            } else {
                // Non-alphabet characters are added as-is
                encryptedMessage.append(currentChar);
            }
        }
        return encryptedMessage.toString();
    }

    // Method to decrypt the message using Substitution Cipher
    public static String decrypt(String encryptedMessage, String key) {
        StringBuilder decryptedMessage = new StringBuilder();
        encryptedMessage = encryptedMessage.toUpperCase();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            char currentChar = encryptedMessage.charAt(i);

            // If character is an alphabetic letter
            if (Character.isLetter(currentChar)) {
                int indexInKey = key.indexOf(currentChar);
                char decryptedChar = ALPHABET.charAt(indexInKey);
                decryptedMessage.append(decryptedChar);
            } else {
                // Non-alphabet characters are added as-is
                decryptedMessage.append(currentChar);
            }
        }
        return decryptedMessage.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define the substitution key (26 unique uppercase letters)
        String key = "QWERTYUIOPLKJHGFDSAZXCVBNM";  // Example key, can be any permutation of 26 letters
        System.out.println("Using substitution key: " + key);

        // Input the message to encrypt
        System.out.print("Enter the message to encrypt: ");
        String message = scanner.nextLine();

        // Encrypt the message
        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Decrypt the message
        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted Message: " + decryptedMessage);
 scanner.close();
    }

}
