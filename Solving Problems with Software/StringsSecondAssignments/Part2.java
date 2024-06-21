public class Part2 {
    public int howMany(String stringa, String stringb){
        int counter = 0;
        int startIndex = 0;
        while (true){
            int currIndex = stringb.indexOf(stringa, startIndex);
            if (currIndex == -1) {
                break;
            }
            counter++;
            startIndex = currIndex + stringa.length();
        }
        return counter;
    }

    public void testHowMany(){
        String stringb = "ATGAACGAATTGAATC";
        String stringa = "GAA";
        System.out.println("Occurance is " + howMany(stringa, stringb));

        stringb = "ATAAAA";
        stringa = "AA";
        System.out.println("Occurance is " + howMany(stringa, stringb));

        stringb = "TATAT";
        stringa = "A";
        System.out.println("Occurance is " + howMany(stringa, stringb));
        
        stringb = "abcdefabcghi";
        stringa = "abc_";
        System.out.println("Occurance is " + howMany(stringa, stringb));

    }
}
