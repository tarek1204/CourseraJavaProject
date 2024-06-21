public class Part3 {
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
        
        dna = "AATGCTAACTAGCTGACTAAT";
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

    public int countGenes(String dna){
        int counter = 0;
        int startIndex = dna.indexOf("ATG");
        while (true){
            if (startIndex != -1){
                int taa = findStopCodon(dna, startIndex, "TAA");
                int tag = findStopCodon(dna, startIndex, "TAG");
                int tga = findStopCodon(dna, startIndex, "TGA");

                int temp = Math.min(taa, tag);
                int minStopIndex = Math.min(temp, tga);

                if (minStopIndex != dna.length()){
                    counter++;
                    startIndex = minStopIndex + 1;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return counter;
    }
    
    public void testCountGenes(){
        String dna = "ATGTAAGATGCCCTAGT";
        System.out.println("DNA is " + dna);
        System.out.println("Number of genes = " + countGenes(dna));
    }
}
