import edu.duke.*;

public class WordLengths {
    public void countWordLengths(FileResource resource, int[] counts) {
        for (String word : resource.words()){
            int wordLength = getWordLength(word);
            if (wordLength >= counts.length) {
                counts[counts.length - 1]++;
            } else {
                counts[wordLength]++;
            }
        }
    }
    
    public int getWordLength(String word){
        int length = word.length();
        if (!(Character.isLetter(word.charAt(0)) || Character.isDigit(word.charAt(0)))) length--;
        if (!(Character.isLetter(word.charAt(word.length() - 1)) || Character.isDigit(word.length() - 1))) length--;
        
        return length;
    }
    
    public int indexOfMax(int[] values){
        int max = 0;
        for (int i = 0; i < values.length; i++){
            if (values[i] > values[max]) max = i;
        }
        
        return max;
    }
    
    public void testCountWordLengths(){
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        countWordLengths(resource, counts);
        
        for (int i = 1; i < counts.length; i++){
            if (counts[i] != 0) System.out.println(counts[i] + " words of length " + i);
        }
        
        System.out.println("\nThe most common word's length are of length " + indexOfMax(counts));
    }
    
}
