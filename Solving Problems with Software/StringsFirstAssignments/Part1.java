public class Part1 {
    public String findSimpleGene(String dna){
        int startIndex = dna.indexOf("ATG");
        int endIndex = dna.indexOf("TAA", startIndex + 3);
        if (startIndex == -1 || endIndex == -1){
            return "NO ATG OR NO TAA";
        } else {
            String gene = dna.substring(startIndex, endIndex + 3);
            if (gene.length()%3 == 0){
                return gene;
            } else {
                return "NO GENE FOUND";
            }
        }
    }
    
    public void testSimpleGene(){
        String dna = "GCACGTCCGATCTAAGCCA";
        System.out.println(dna);
        System.out.println("Gene is " + findSimpleGene(dna));
        dna = "GCATGTCGATCTGAGCCA";
        System.out.println(dna);
        System.out.println("Gene is " + findSimpleGene(dna));
        dna = "GCAGTTCCGATCTCAGCA";
        System.out.println(dna);
        System.out.println("Gene is " + findSimpleGene(dna));
        dna = "GCATGTCCGATTAACGCCG";
        System.out.println(dna);
        System.out.println("Gene is " + findSimpleGene(dna));
        dna = "GCATGTCCGATCTAAGCC";
        System.out.println(dna);
        System.out.println("Gene is " + findSimpleGene(dna));
    }
    
}
