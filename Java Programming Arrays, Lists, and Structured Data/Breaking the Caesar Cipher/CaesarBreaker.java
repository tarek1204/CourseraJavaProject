import edu.duke.*;

public class CaesarBreaker {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    
    public int[] countLetters(String msg){
        int[] counts = new int[27];
        for (int i = 0; i < msg.length(); i++){
            char ch = Character.toLowerCase(msg.charAt(i));
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
    
    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int max = maxIndex(freqs);
        int dkey = max - 4;
        if (max < 4) dkey = 26 - (4 - max);
        return cc.encrypt(encrypted, 26 - dkey);
    }
    
    public void testDecrypt(){
        FileResource resource = new FileResource();
        System.out.println("The encrypted message is \n" + resource.asString());
        System.out.println("The decrypted message is \n" + decrypt(resource.asString()));
    }
    
    public String halfOfString(String message, int start){
        StringBuilder sb = new StringBuilder("");
        for (int i = start; i < message.length(); i += 2){
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }
    
    public int getKey(String s){
        int[] freqs = countLetters(s);
        int max = maxIndex(freqs);
        int dkey = max - 4;
        if (max < 4) dkey = 26 - (4 - max);
        return dkey;
    }
    
    public String decryptTwoKeys(String encrypted){
        int dkey1 = getKey(halfOfString(encrypted, 0));
        int dkey2 = getKey(halfOfString(encrypted, 1));
        System.out.println("The two decryption keys are " + dkey1 + " & " + dkey2);
        
        CaesarCipher cc = new CaesarCipher();
        return cc.encryptTwoKeys(encrypted, 26 - dkey1, 26 - dkey2);
    }
    
    public void testDecryptTwoKeys(){
        FileResource resource = new FileResource();
        System.out.println("The encrypted message is \n" + resource.asString());
        System.out.println("The decrypted message is \n" + decryptTwoKeys(resource.asString()));
    }
}
