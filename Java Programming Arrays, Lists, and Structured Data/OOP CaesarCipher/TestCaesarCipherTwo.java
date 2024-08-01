import edu.duke.*;

public class TestCaesarCipherTwo {
    
    public int[] countLetters(String msg){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] counts = new int[27];
        for (int i = 0; i < msg.length(); i++){
            char ch = Character.toUpperCase(msg.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1) counts[index]++;
        }
        
        return counts;
    }
    
    public int maxIndex(int[] counts){
        int max = 0;
        for (int i = 0; i < counts.length; i++){
            if (counts[i] > counts[max]) max = i;
        }
        
        return max;
    }
    
    public String halfOfString(String message, int start){
        StringBuilder sb = new StringBuilder("");
        for (int i = start; i < message.length(); i += 2){
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }
    
    public void simpleTests(){
        FileResource resource = new FileResource();
        CaesarCipherTwo cc = new CaesarCipherTwo(21, 8);
        
        String encrypted = cc.encrypt(resource.asString());
        String decrypted = breakCaesarCipher(encrypted);
        
        System.out.println("The encrypted message is: " + encrypted);
        
        System.out.println("The decrypted message is: " + decrypted);
        
    }
    
    // public String breakCaesarCipher(String input){
        // String stringOne = halfOfString(input, 0);
        // int[] count1 = countLetters(stringOne);
        // int maxIdx1 = maxIndex(count1);
        // int dkey1 = maxIdx1 -4 ;
        // if (maxIdx1 < 4) dkey1 = 26 - (4 - maxIdx1);
        
        // String stringTwo = halfOfString(input, 1);
        // int[] count2 = countLetters(stringTwo);
        // int maxIdx2 = maxIndex(count2);
        // int dkey2 = maxIdx2 -4 ;
        // if (maxIdx2 < 4) dkey2 = 26 - (4 - maxIdx2);
        
        // CaesarCipherTwo cc = new CaesarCipherTwo(26 - dkey1, 26 - dkey2);
        // System.out.println("The two keys are : " + dkey1 + " & " + dkey2);
        // return cc.encrypt(input);
    // }
    
    public int getKey(String s){
        int[] freqs = countLetters(s);
        int max = maxIndex(freqs);
        int dkey = max - 4;
        if (max < 4) dkey = 26 - (4 - max);
        return dkey;
    }
    
    public String breakCaesarCipher(String encrypted){
        int dkey1 = getKey(halfOfString(encrypted, 0));
        int dkey2 = getKey(halfOfString(encrypted, 1));
        System.out.println("The two decryption keys are " + dkey1 + " & " + dkey2);
        
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - dkey1, 26 - dkey2);
        return cc.encrypt(encrypted);
    }
}
