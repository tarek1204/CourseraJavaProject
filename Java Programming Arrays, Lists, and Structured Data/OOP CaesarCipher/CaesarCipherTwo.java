public class CaesarCipherTwo {

    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int key1;
    private int key2;

    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        
        this.key1 = key1;
        this.key2 = key2;
    }

    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
       
        for (int i = 0; i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if (idx != -1){
                char newChar = i % 2 == 0 ? shiftedAlphabet1.charAt(idx) : shiftedAlphabet2.charAt(idx);
                if (Character.isLowerCase(currChar)) encrypted.setCharAt(i, Character.toLowerCase(newChar));
                else encrypted.setCharAt(i, newChar);
            }
        }

        return encrypted.toString();
    }
    
    public String decrypt(String input){
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - key1, 26 - key2);
        return cc.encrypt(input);
    }
    
    
}

