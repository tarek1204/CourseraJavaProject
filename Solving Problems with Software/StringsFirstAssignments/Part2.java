public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        String dnaUC = dna.toUpperCase();
        boolean isUpper = (dna == dnaUC) ? true : false;
        String modifiedStart = (isUpper) ? startCodon.toUpperCase() : startCodon.toLowerCase();
        String modifiedStop = (isUpper) ? stopCodon.toUpperCase() : stopCodon.toLowerCase();
        int startIndex = dna.indexOf(modifiedStart);
        int endIndex = dna.indexOf(modifiedStop, startIndex + 3);
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
        String dna = "AATGCGTAATATGGT";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        System.out.println("DNA strand is  " + dna);
        String gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "AATGCTAGGGTAATATGGT";
        startCodon = "ATG";
        stopCodon = "TAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "AATAGCTAGGGTAATATGGT";
        startCodon = "ATG";
        stopCodon = "TAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "AATGCTAGGGTAGATATGGT";
        startCodon = "ATG";
        stopCodon = "TAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "AACTGCTAGGGTACATATGGT";
        startCodon = "ATG";
        stopCodon = "TAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "aatgctagggtaatatggt";
        startCodon = "atg";
        stopCodon = "taa";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
    }
}
