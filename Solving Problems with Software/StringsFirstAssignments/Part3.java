public class Part3 {
    public static boolean twoOccurrences(String stringa, String stringb){
        int counter = 0;
        boolean result = false;
        
        if (stringb.contains(stringa)){
            counter++;
            int index = stringb.indexOf(stringa);
            String substring = stringb.substring(index + 1);
            if (substring.contains(stringa)){
                counter++;
            }
        }
        
        if (counter >= 2){
            result = true;
        }
        return result;
    }
    
    public static void testing(){
        String testedText = "A story by Abby Long";
        String searchedStr = "by";
        System.out.println("The tested text is " + testedText + "\nWe're searching for " + searchedStr);
        System.out.println("Did we find it? " + twoOccurrences(searchedStr, testedText) + "\n");
        
        testedText = "ctgtatgta";
        searchedStr = "atg";
        System.out.println("The tested text is " + testedText + "\nWe're searching for " + searchedStr);
        System.out.println("Did we find it? " + twoOccurrences(searchedStr, testedText));
    }
    
    public static void main(String[] args){
        testing();
    }
}
