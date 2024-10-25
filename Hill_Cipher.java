import java.util.Scanner;

public class Hill_Cipher {
    // Matrix multiplication with modulo 26
    private static int[] matrixMultiply(int[][] matrix, int[] vector) {
        int[] result = new int[vector.length];
        for (int i = 0; i < 2; i++) {
            result[i] = (matrix[i][0] * vector[0] + matrix[i][1] * vector[1]) % 26;
        }
        return result;
    }

    // Find modular inverse of a 2x2 matrix
    private static int[][] inverseKeyMatrix(int[][] matrix) {
        int det = (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]) % 26;
        det = (det + 26) % 26;
        int invDet = -1;
        for (int i = 1; i < 26; i++) {
            if ((det * i) % 26 == 1)
                invDet = i;
        }

        return new int[][] {
                { (matrix[1][1] * invDet) % 26, (-matrix[0][1] * invDet + 26) % 26 },
                { (-matrix[1][0] * invDet + 26) % 26, (matrix[0][0] * invDet) % 26 }
        };
    }

    // Convert string to vector and vice versa
    private static int[] toVector(String text) {
        return new int[] { text.charAt(0) - 'A', text.charAt(1) - 'A' };
    }

    private static String toString(int[] vector) {
        return "" + (char) (vector[0] + 'A') + (char) (vector[1] + 'A');
    }

    // Encrypt and decrypt functions
    private static String encrypt(String text, int[][] keyMatrix) {
        return toString(matrixMultiply(keyMatrix, toVector(text)));
    }

    private static String decrypt(String text, int[][] keyMatrix) {
        return toString(matrixMultiply(inverseKeyMatrix(keyMatrix), toVector(text)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input key matrix
        int[][] keyMatrix = new int[2][2];
        System.out.println("Enter the 2x2 key matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                keyMatrix[i][j] = scanner.nextInt();
            }
        }

        // Input plaintext
        System.out.println("Enter plaintext (length 2, uppercase letters):");
        String plaintext = scanner.next().toUpperCase();

        // Encrypt and decrypt
        String encrypted = encrypt(plaintext, keyMatrix);
        System.out.println("Encrypted Text: " + encrypted);

        String decrypted = decrypt(encrypted, keyMatrix);
        System.out.println("Decrypted Text: " + decrypted);

        scanner.close();
    }
}
