import edu.duke.*;

public class TestCaesarCipher {
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
    
    public String breakCaesarCipher(String encrypted){
        int[] freqs = countLetters(encrypted);
        int max = maxIndex(freqs);
        int dkey = max - 4;
        if (max < 4) dkey = 26 - (4 - max);
        CaesarCipher cc = new CaesarCipher(dkey);
        return cc.decrypt(encrypted);
    }
    
    public void simpleTests(){
        FileResource resource = new FileResource();
        String input = resource.asString();
        
        CaesarCipher cc = new CaesarCipher(15);
        String encrypted = cc.encrypt(input);
        String decrypted = cc.decrypt(input);
        
        System.out.println("The encrypted message is:\n" + encrypted); 
        System.out.println("The decrypted message is:\n" + decrypted); 
    }
}
