public class XOR_With0 {
    public static void main(String[] args) {
        // Define the string
        String text = "Hello World";
        // Display the original string
        System.out.println("Original String: " + text);
        // Perform XOR operation with 0 and display the result System.out.print("XOR
        // with 0: ");
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char xorResult = (char) (c ^ 0);
            // XOR with 0 
            System.out.print(xorResult);
        }
        System.out.println();
    }

}