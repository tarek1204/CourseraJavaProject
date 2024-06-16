import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoints = 0;
        for (Point p : s.getPoints()){
            numPoints = numPoints + 1;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double perim = getPerimeter(s);
        double numSides = (double) getNumPoints(s);
        return perim/numSides;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        // dist counter intialized by 0
        double largestSide = 0;
        // iterate through points
        for (Point p : s.getPoints()){
            Point lastPoint = s.getLastPoint();
            // get the distance between the first point and the last point
            double distance = p.distance(lastPoint);
            // if distance between them > dist, update dist to new value
            if (distance >= largestSide){
                largestSide = distance;
            }
            // update the lastpoint to be the current point
            lastPoint = p;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        int largestX = 0;
        for (Point p : s.getPoints()){
            if (p.getX() >= largestX){
                largestX = p.getX();
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerim = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (getPerimeter(s) > largestPerim){
                largestPerim = getPerimeter(s);
            }
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null; // replace this code
        double largestPerim = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (getPerimeter(s) >= largestPerim){
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + getNumPoints(s));
        System.out.println("average of all the sides’ lengths = " + getAverageLength(s));
        System.out.println("largest side = " + getLargestSide(s));
        System.out.println("Largest x value = " + getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter in selected files is " + largestPerimeter);
        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String largestPerimFile = getFileWithLargestPerimeter();
        System.out.println("The file of the largest perimeter is " + largestPerimFile);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }
    
    

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
