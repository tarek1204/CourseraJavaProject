public class CaesarCipher {
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);

        for (int i = 0; i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if (idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                if (Character.isLowerCase(currChar)){
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                } else {
                    encrypted.setCharAt(i, newChar);
                } 
            }
        }

        return encrypted.toString();
    }

    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key1) + alphabet.substring(0, key1);
        for (int i = 0; i < encrypted.length(); i += 2){
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if (idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                if (Character.isLowerCase(currChar)){
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                } else {
                    encrypted.setCharAt(i, newChar);
                } 
            }
        }

        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key2) + alphabet.substring(0, key2);

        for (int i = 1; i < encrypted.length(); i += 2){
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if (idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                if (Character.isLowerCase(currChar)){
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                } else {
                    encrypted.setCharAt(i, newChar);
                } 
            }
        }

        return encrypted.toString();
    }

    public void tester(){
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
        
    }
}
