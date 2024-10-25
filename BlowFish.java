import java.util.*;

import javax.crypto.*;

public class BlowFish {
    // Method to generate a secret key for Blowfish
    public static SecretKey generateKey(int keySize) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(keySize); // keySize can be between 32 and 448 bits
        return keyGenerator.generateKey();
    }

    // Method to encrypt data using the Blowfish algorithm
    public static String encrypt(String plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Method to decrypt data using the Blowfish algorithm
    public static String decrypt(String ciphertext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            // Generate a secret key for Blowfish
            SecretKey secretKey = generateKey(128); // You can specify a key size between 32 and 448 bits  
     // Plain text to be encrypted
            String plaintext = "Hello, World!";
            System.out.println("Original Text: " + plaintext);

            // Encrypt the plain text
            String encryptedText = encrypt(plaintext, secretKey);
            System.out.println("Encrypted Text: " + encryptedText);

            // Decrypt the encrypted text
            String decryptedText = decrypt(encryptedText, secretKey);
            System.out.println("Decrypted Text: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
