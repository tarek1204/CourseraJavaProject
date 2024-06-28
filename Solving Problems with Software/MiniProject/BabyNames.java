import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyNames {
    public void printNames() {
        FileResource fr = new FileResource();
        int boys = 0;
        int girls = 0;
        int total = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            System.out.println("Name " + rec.get(0) +
                " Gender " + rec.get(1) +
                " Num Born " + rec.get(2));
            if (rec.get(1).equals("M")) boys++;
            if (rec.get(1).equals("F")) girls++;
            total++;
        }
        System.out.println("Number of boys: " + boys
            + " Number of girls: " + girls
            + " Total: " + total);
    }

    public int getRank(int year, String name, String gender){
        int rank = 0;
        boolean found = false;
        FileResource fr = new FileResource("data/yob" + year + ".csv");
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(1).equals(gender)){
                rank++;
                if (rec.get(0).equals(name)){
                    found = true;
                    break;
                }
            }
        }
        if (found) return rank;
        return -1;
    }

    public String getName(int year, int rank, String gender){
        boolean found = false;
        String name = "NO NAME";
        int counter = 1;
        FileResource fr = new FileResource("data/yob" + year + ".csv");
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(1).equals(gender)){
                if (counter == rank) name = rec.get(0);
                counter++;
            }
        }
        return name;
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year, name, gender);
        if (rank != -1){
            String newName = getName(newYear, rank, gender);
            // Isabella born in 2012 would be Sophia if she was born in 2014.
            System.out.println(name + " born in " + year + " would be " + newName + " if was born in " + newYear);
        } else System.out.println("NAME NOT FOUND");
    }

    public int yearOfHighestRank(String name, String gender){
        int year = -1;
        int rank = Integer.MAX_VALUE;
    
        DirectoryResource dr = new DirectoryResource();
 
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            int newYear = Integer.parseInt(f.getName().substring(3,7));
            int fileRank = getRank(newYear, name, gender);
            if (rank > fileRank && fileRank != -1){
                rank = fileRank;
                year = newYear;
            }
        }

        return year;
    }
    
    public double getAverageRank(String name, String gender){
        double totalRank = 0;
        double count = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            int year = Integer.parseInt(f.getName().substring(3,7));
            int currentRank = getRank(year, name, gender);
            if (currentRank != -1){
                totalRank += currentRank;
                count++;
            }
        }
        
        if (totalRank == 0) return -1.0;
        double avgRank = totalRank/count;
        return avgRank;
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        FileResource fr = new FileResource();
        int totalBirths = 0;
        int rank = getRank(year, name, gender);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)) {
		rank--;
		if (rank > 0) {
		    totalBirths += Integer.parseInt(rec.get(2));
                }
            }
        }
        return totalBirths;
    }
    
    public void tester(){
        System.out.println(getTotalBirthsRankedHigher(1990, "Drew", "M"));
        
    }
}
