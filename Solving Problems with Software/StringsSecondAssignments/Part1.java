public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int temp = dna.indexOf(stopCodon, startIndex);
        if(temp != -1){
            if((temp - startIndex) % 3 == 0){
                return temp;
            }
        }
        return dna.length();
    }
    
    public void testFindStopCodon(){
        String dna = "ATGCGAGCCTAAGCTAT";
        System.out.println("DNA is " + dna);
        System.out.println("Stop codon index is " + findStopCodon(dna, 0, "TAA"));
        
        dna = "ATGCGAGCTAAGTAGCTAT";
        System.out.println("DNA is " + dna);
        System.out.println("Stop codon index is " + findStopCodon(dna, 0, "TAG"));
        
        dna = "ATGCGAGCCGTAAGCTAT";
        System.out.println("DNA is " + dna);
        System.out.println("Stop codon index is " + findStopCodon(dna, 0, "TAA"));
    }
    
    public String findGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if (startIndex != -1){
            int taa = findStopCodon(dna, startIndex, "TAA");
            int tag = findStopCodon(dna, startIndex, "TAG");
            int tga = findStopCodon(dna, startIndex, "TGA");
            
            int temp = Math.min(taa, tag);
            int minStopIndex = Math.min(temp, tga);
            
            if (minStopIndex != dna.length()){
                return dna.substring(startIndex, minStopIndex + 3);
            }
            return "";
        }
        return "";
    }
    
    public void testFindGene(){
        // NO ATG
        String dna = "GCCTTGGCGCTAATGAGTA";
        System.out.println("DNA is " + dna);
        System.out.println("The gene is " + findGene(dna));
        
        // ONE VALID STOP CODON
        dna = "GCCTATGTGGCGCTAAGTGAGTA";
        System.out.println("DNA is " + dna);
        System.out.println("The gene is " + findGene(dna));
        
        // MULTIPLE VALID STOP CODONS
        dna = "CATGTATCGCTAAATATAGTGA";
        System.out.println("DNA is " + dna);
        System.out.println("The gene is " + findGene(dna));
        
        // NO VALID STOP CODON
        dna = "GCCTATGTGGCGCTAGTGAGTA";
        System.out.println("DNA is " + dna);
        System.out.println("The gene is " + findGene(dna));
    }
    
    public void printAllGenes(String dna){
        String dnaTemp = dna;
        while (true){
            String gene = findGene(dnaTemp);
            int where = gene.length() - 1;
            if (gene.isEmpty()){
                break;
            }
            System.out.println("Gene is " + gene);
            dnaTemp = dnaTemp.substring(where, dnaTemp.length());
        }
        
    }
    
    public void testPrintAllGenes(){
        String dna = "GCCTATGTGGCGCTAAGTGAGTACATGTATCGCTAGATATAATGAGCCTATGTGGCGCTAGTGAGTACATGTATCGCTAAATATAGTGA";
        printAllGenes(dna);
    }
}
