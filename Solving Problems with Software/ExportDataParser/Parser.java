import edu.duke.*;
import org.apache.commons.csv.*;

public class Parser {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }

    public String countryInfo(CSVParser parser, String country){
        String output = "NOT FOUND";
        // look at the Country column
        for (CSVRecord r : parser){           
            // Check if it's the entered country
            if (r.get("Country").contains(country)){
                // get list of exports and print them out seperated by commas + : + value
                output = country + " : " + r.get("Exports") + " : " + r.get("Value (dollars)");
            }
        }

        return output;
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord r : parser){           
            // Check if it's the entered country
            if (r.get("Exports").contains(exportItem1) && r.get("Exports").contains(exportItem2)){
                // get list of exports and print them out seperated by commas + : + value
                System.out.println(r.get("Country"));
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord r : parser){
            if (r.get("Exports").contains(exportItem)){
                count++;
            }
        }

        return count;
    }

    public void bigExporters(CSVParser parser, String amount){
        for (CSVRecord r : parser){
            String value = r.get("Value (dollars)");
            if (value.length() > amount.length()){
                String country = r.get("Country");
                System.out.println(country + " : " + value);

            }
        }
    }
    
    public void listExporters(CSVParser parser, String exportOfInterest) {
        //for each row in the CSV File
        for (CSVRecord record : parser) {
            //Look at the "Exports" column
            String export = record.get("Exports");
            //Check if it contains exportOfInterest
            if (export.contains(exportOfInterest)) {
                //If so, write down the "Country" from that row
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
}

