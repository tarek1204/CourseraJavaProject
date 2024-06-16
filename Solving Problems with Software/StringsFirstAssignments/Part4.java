import edu.duke.*;

public class Part4 {
    public static void main(String[] args){
        System.out.println("URLs: ");
        URLResource urls = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String url : urls.words()){
            String urlLower = url.toLowerCase();
            if (urlLower.contains("youtube.com")){
                int ytIndex = urlLower.indexOf("youtube.com");
                if (ytIndex != -1){
                    int startIndex = url.lastIndexOf("\"", ytIndex);
                    int endIndex = url.indexOf("\"", ytIndex);
                    System.out.println(url.substring(startIndex + 1, endIndex));
                }
            }
        }
    }
}
