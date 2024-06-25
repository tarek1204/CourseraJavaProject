import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class WeatherData {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser){
            if (lowestSoFar == null){
                lowestSoFar = currentRow;
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                if (currentTemp < lowestTemp) lowestSoFar = currentRow;
            }
        }
        return lowestSoFar;
    }

    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVRecord lowestTemp = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature was " + lowestTemp.get("TemperatureF"));
    }

    public String fileWithColdestTemperature(){
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if (lowestSoFar == null){
                lowestSoFar = currentRow;
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                if (currentTemp < lowestTemp) lowestSoFar = currentRow;
            }
        }
        return "weather-" + lowestSoFar.get("DateUTC").substring(0, 10) + ".csv";
    }

    public void testFileWithColdestTemperature(){
        String fileName = fileWithColdestTemperature();
        String fileDir = "nc_weather/nc_weather/" + fileName.substring(8, 12) + "/" + fileName;
        FileResource fr = new FileResource(fileDir);
        CSVRecord coldestTemp = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest day was in file " + fileName);
        System.out.println("Coldest temperature on that day was " + coldestTemp.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were: ");
        for (CSVRecord r : fr.getCSVParser()){
            System.out.println(r.get("DateUTC") + ": " + r.get("TemperatureF"));
        }
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser){
            if (lowestSoFar == null){
                lowestSoFar = currentRow;
            } else {
                if (!currentRow.get("Humidity").contains("N/A")){
                    double currentHum = Double.parseDouble(currentRow.get("Humidity"));
                    double lowestHum = Double.parseDouble(lowestSoFar.get("Humidity"));
                    if (currentHum < lowestHum) lowestSoFar = currentRow;  
                }
            }
        }
        return lowestSoFar;
    }

    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        // Lowest Humidity was 24 at 2014-01-20 19:51:00
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }

    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            if (lowestSoFar == null){
                lowestSoFar = currentRow;
            } else {
                if (!currentRow.get("Humidity").contains("N/A")){
                    double currentHum = Double.parseDouble(currentRow.get("Humidity"));
                    double lowestHum = Double.parseDouble(lowestSoFar.get("Humidity"));
                    if (currentHum < lowestHum) lowestSoFar = currentRow;  
                }
            }
        }

        return lowestSoFar;
    }

    public void testLowestHumidityInManyFiles(){
        CSVRecord csv = lowestHumidityInManyFiles();
        // Lowest Humidity was 24 at 2014-01-20 19:51:00
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }

    public double averageTemperatureInFile(CSVParser parser){
        double totalTemp = 0;
        double count = 0;
        for (CSVRecord currentRow : parser){
            totalTemp += Double.parseDouble(currentRow.get("TemperatureF"));
            count++;
        }
        return totalTemp/count;
    }

    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avgTemp = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is " + avgTemp);

    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, double value){
        double sum=0;
        double average =0;
        int count = 1;
        for (CSVRecord currentRow : parser){
            double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            if(currentHumidity>=value){
                sum += currentTemp;
                average =sum/count;
                count++;
            }
        }
        return average;
    }

    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        double avgTempWithHumidity = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80);
        if (avgTempWithHumidity != 0) System.out.println("Average Temp when high Humidity is " + avgTempWithHumidity);
        else System.out.println("No temperatures with that humidity");
    }
}
