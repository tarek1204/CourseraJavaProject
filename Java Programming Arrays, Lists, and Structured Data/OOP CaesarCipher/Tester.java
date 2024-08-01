
public class Tester {
    public static void main(String[] args) {
        CaesarCipherTwo test = new CaesarCipherTwo(17, 3);

        // Testing with different inputs
        System.out.println(test.encrypt("Hello World")); // Expected output should show encrypted result based on shifted alphabets
        System.out.println(test.encrypt("Java123"));     // Non-alphabetic characters should remain unchanged
        System.out.println(test.encrypt(""));            // Empty string should return empty
        System.out.println(test.encrypt("abcdef"));       // Test with all lowercase letters
        System.out.println(test.encrypt("XYZ"));          // Test with all uppercase letters
    }
}
