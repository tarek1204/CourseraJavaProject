public class WordPlay {
    public boolean isVowel(char ch){
        String vowels = "AEIOUaeiou";
        boolean isVowel = vowels.contains(Character.toString(ch)) ? true : false;
        return isVowel;
    }

    public String replaceVowels(String phrase, char ch){
        StringBuilder replaced = new StringBuilder(phrase);
        for (int i = 0; i < replaced.length(); i++){
            if (isVowel(replaced.charAt(i))){
                replaced.setCharAt(i, ch);
            }
        }

        return replaced.toString();
    }

    public String emphasize(String phrase, char ch){
        StringBuilder replaced = new StringBuilder(phrase);
        for (int i = 0; i < replaced.length(); i++){
            if (phrase.charAt(i) == ch){
                if (i % 2 == 0) replaced.setCharAt(i, '*');
                else replaced.setCharAt(i, '+');
            }
        }

        return replaced.toString();
    }

    public void tester(){
        System.out.println(emphasize("dna ctgaaactga", 'a') + " .... " + replaceVowels("Hello World", '*'));
    }
}
