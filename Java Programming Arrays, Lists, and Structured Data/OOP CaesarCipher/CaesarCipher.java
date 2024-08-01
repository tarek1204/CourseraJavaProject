
public class CaesarCipher {
    
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key){
        mainKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    }
    
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);

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
    
    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    }
    
}
