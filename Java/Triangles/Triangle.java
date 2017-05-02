import java.awt.Point;

/**
 * Write a description of class Triangle here.
 * 
 * @author Phil Fevry
 * @version 1.0
 */
public class Triangle
{
    // instance variables
    private double angle1, angle2, angle3;
    private Point p1, p2, p3;
    
    /**
     * Constructor for objects of class Triangle
     */
    public Triangle(Point p1, Point p2, Point p3)
    {
        // initialise instance variables
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        
        computeAngles();
    }
    
    /**
     * Computes and returns the distance between points p1 and p2
     * 
     * @return     the distance between points p1 and p2
     */
    public double getSide1_Length()
    {
        double d;
        double x1, x2, y1, y2;
        
        x1 = p1.getX();
        y1 = p1.getY();
        
        x2 = p2.getX();
        y2 = p2.getY();
        
        d = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
        
        return d;
    }
    
    /**
     * Computes and returns the distance between points p2 and p3
     * 
     * @return     the distance between points p2 and p3
     */
    public double getSide2_Length()
    {
        double d;
        double x1, x2, y1, y2;
        
        x1 = p2.getX();
        y1 = p2.getY();
        
        x2 = p3.getX();
        y2 = p3.getY();
        
        d = Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2 - y1,2));
        
        return d;
    }
    
    /**
     * Computes and returns the distance between points p1 and p3
     * 
     * @return     the distance between points p1 and p3
     */
    public double getSide3_Length()
    {
        double d;
        double x1, x2, y1, y2;
        
        x1 = p1.getX();
        y1 = p1.getY();
        
        x2 = p3.getX();
        y2 = p3.getY();
        
        d = Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2 - y1,2));
        
        return d;
    }
    
    /**
    * Takes a parameter of type Point and sets the appropriate corner point.
    * 
    * @param    point   sets corner point for Point 1
    */
    public void setPoint1(Point p)
    {
        p1.setLocation(p);
        computeAngles();
    }
    
    /**
    * Takes a parameter of type Point and sets the appropriate corner point.
    * 
    * @param    point   sets corner point for Point 2
    */
    public void setPoint2(Point p)
    {
        p2.setLocation(p);
        computeAngles();
    }
    
    /**
    * Takes a parameter of type Point and sets the appropriate corner point.
    * 
    * @param    point   sets corner point for Point 3
    */
    public void setPoint3(Point p)
    {
        p3.setLocation(p);
        computeAngles();
    }
    
    /**
     * Returns coordinates of Point 1
     * 
     * @return     point 1 location
     */
    public Point getPoint1()
    {
        return p1.getLocation();
    }
    
    /**
     * Returns coordinates of Point 2
     * 
     * @return     point 2 location
     */
    public Point getPoint2()
    {
        return p2.getLocation();
    }
    
     /**
     * Returns coordinates of Point 3
     * 
     * @return     point 3 location
     */
    public Point getPoint3()
    {
        return p3.getLocation();
    }
    
    /**
     * Computes anles
     */
    private void computeAngles()
    {
        double a, b, c;
        double smallest, middle, largest; 
        double cosB, sinC, sinC_2;
        
        // Find Largest Side
        a = getSide1_Length();
        b = getSide2_Length();
        c = getSide3_Length();
        
        if (Math.max(a,b) > c)
        {
            smallest = c;
            middle = Math.min(a,b);
            largest = Math.max(a,b);
        } else {
            smallest = Math.min(a,b);
            middle = Math.max(a,b);
            largest = c;
        }
        
        
        // Largest angle 'B' (Angle 1)
  
       cosB = (Math.pow(smallest,2) + Math.pow(middle,2) - Math.pow(largest,2))/(2*smallest*middle);
       angle1 = Math.acos(cosB);
       
        // A remaining angle (Angle 2)
       sinC = ((middle * Math.sin(Math.toRadians(getAngle1())))/largest);
       sinC_2 = ((smallest * Math.sin(Math.toRadians(getAngle1())))/largest);
       
       // Find final angle depending on what Angle 1 and 2 are (Angle 3)
       if (sinC > sinC_2)
       {
           angle2 = Math.asin(sinC);
           angle3 = 180-(getAngle1()+getAngle2());
        } else{
           angle2 = Math.asin(sinC_2);
           angle3 = 180-(getAngle1()+getAngle2());
       }
    }
    
     /**
     * Returns the angle of Point 1
     * 
     * @return     Point 1 angle (in degrees)
     */
    public double getAngle1()
    {
       return Math.toDegrees(angle1);
    }
    
     /**
     * Returns the angle of Point 2
     * 
     * @return     Point 2 angle (in degrees)
     */
    public double getAngle2()
    {
        return Math.toDegrees(angle2);
    }
    
     /**
     * Returns the angle of Point 3
     * 
     * @return     Point 3 angle (in degrees)
     */
    public double getAngle3()
    {
        return angle3;
    }
    
     /**
     * Returns point locations, lengths of sides, and angles of a triangle.
     * 
     * @return     formatted string of triangle object
     */
    public String toString()
    {

        final int POINT1 = 0, LENGTH1 = 0, ANGLE1 = 0;
        final int POINT2 = 1, LENGTH2 = 1, ANGLE2 = 1;
        final int POINT3 = 2, LENGTH3 = 2, ANGLE3 = 2;
        
        final int X = 0;
        final int Y = 1;
        
        double [][] coordinates;
        double [] lengths, angles;
        
        coordinates = new double [3][2];
        coordinates[POINT1][X] = p1.getX();
        coordinates[POINT1][Y] = p1.getY();
        coordinates[POINT2][X] = p2.getX();
        coordinates[POINT2][Y] = p2.getY();
        coordinates[POINT3][X] = p3.getX();
        coordinates[POINT3][Y] = p3.getY();
        
        lengths = new double [3];
        lengths[LENGTH1] = getSide1_Length();
        lengths[LENGTH2] = getSide2_Length();
        lengths[LENGTH3] = getSide3_Length();
        
        angles = new double [3];
        angles[ANGLE1] = getAngle1();
        angles[ANGLE2] = getAngle2();
        angles[ANGLE3] = getAngle3();
        
        String text = String.format(
        "First Corner Point: [%1$.1f, %2$.1f]\n" +
        "Second Corner Point: [%3$.1f, %4$.1f]\n" +
        "Third Corner Point: [%5$.1f, %6$.1f]\n" +
        "Side 1 length: %7$.2f\n" +
        "Side 2 length: %8$.2f\n" +
        "Side 3 length: %9$.2f\n" +
        "Angle1: %10$.2f\n" +
        "Angle2: %11$.2f\n" +
        "Angle3: %12$.2f",
        coordinates[POINT1][X], coordinates[POINT1][Y],
        coordinates[POINT2][X], coordinates[POINT2][Y],
        coordinates[POINT3][X], coordinates[POINT3][Y],
        lengths[LENGTH1], lengths[LENGTH2], lengths[LENGTH3],
        angles[ANGLE1], angles[ANGLE2], angles[ANGLE3]);
        
        return text;
    }
}
