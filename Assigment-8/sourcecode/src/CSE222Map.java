import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The `CSE222Map` class reads a map file and initializes instance variables for the map's start and
 * end points, dimensions, and values.
 */
public class CSE222Map 
{
    private int start_x;
    private int start_y;
    private int end_x;
    private int end_y;
    private int[][] map;
    private int height;
    private int width;

    // This is a constructor for the `CSE222Map` class that takes a `filename` parameter. It reads a
    // map file from the given filename and initializes the `start_x`, `start_y`, `end_x`, `end_y`,
    // `map`, `height`, and `width` instance variables of the `CSE222Map` object. The map file is
    // expected to have the following format:
    protected CSE222Map(String filename) 
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) 
        {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
    
            //read start_x and start_y from the first line
            String[] startCoords = scanner.nextLine().split(",");
            start_y = Integer.parseInt(startCoords[0].trim());
            start_x = Integer.parseInt(startCoords[1].trim());
    
            //read end_x and end_y from the second line
            String[] endCoords = scanner.nextLine().split(",");
            end_y = Integer.parseInt(endCoords[0].trim());
            end_x = Integer.parseInt(endCoords[1].trim());
    
            //read map and determine dimensions
            int maxColumns = 0;
            int rowCount = 0;
            while(scanner.hasNextLine()) 
            {
                String line = scanner.nextLine();
                String[] row = line.split(",");
                maxColumns = Math.max(maxColumns, row.length);
                rowCount++;
            }
    
            //initialize map array with determined dimensions
            width = rowCount;
            height = maxColumns;

            map = new int[rowCount][maxColumns];
    
            //reset scanner to read map again
            scanner = new Scanner(file);
            for(int i = 0; i < 2; i++) 
            {
                scanner.nextLine();
            }
    
            int row = 0;
            while(scanner.hasNextLine() && row < height*width) 
            {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                for(int col = 0; col < Math.min(values.length, height*width); col++)
                {
                    map[row][col] = Integer.parseInt(values[col].trim());
                }
                row++;
            }
        } 
        catch(IOException e) 
        {
            e.printStackTrace();
        }
        
        File directory = new File("OriginalMaps");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        filename = filename.replace(".txt", "");
        String png = "OriginalMaps/" + filename + ".png";
        MapConverter mapConverter = new MapConverter();
        mapConverter.convertToPNG(map, png);

        if(map[start_y][start_x] == 1)
            throw new IllegalArgumentException("Start point cannot be 1 in the map array.");
        if(map[end_y][end_x] == 1)
            throw new IllegalArgumentException("End point cannot be 1 in the map array.");
    }
    
    /**
     * This function returns the height value.
     * 
     * @return The method `getHeight()` is returning the value of the `height` variable.
     */
    protected int getHeight() 
    {
        return height;
    }

    /**
     * This function returns the width of an object.
     * 
     * @return The method `getWidth()` is returning the value of the variable `width`.
     */
    protected int getWidth() 
    {
        return width;
    }

    /**
     * This Java function returns the value of the variable "start_x".
     * 
     * @return The method `getStartX()` is returning the value of the variable `start_x`.
     */
    protected int getStartX() 
    {
        return start_x;
    }

    /**
     * This Java function returns the value of the variable "start_y".
     * 
     * @return The method `getStartY()` is returning the value of the variable `start_y`.
     */
    protected int getStartY() 
    {
        return start_y;
    }

    /**
     * This Java function returns the value of the variable "end_x".
     * 
     * @return The method is returning the value of the variable "end_x".
     */
    protected int getEndX() 
    {
        return end_x;
    }

    /**
     * This Java function returns the value of the variable "end_y".
     * 
     * @return The method is returning the value of the variable `end_y`.
     */
    protected int getEndY() 
    {
        return end_y;
    }

    /**
     * The function returns a 2D integer array representing a map.
     * 
     * @return A 2D integer array called "map".
     */
    protected int[][] getMap() 
    {
        return map;
    }

    /**
     * This function sets the value of the "start_x" variable to the input parameter "startX".
     * 
     * @param startX startX is an integer parameter that represents the starting x-coordinate of an
     * object or element in a program. The method setStartX() sets the value of the start_x instance
     * variable to the value of the startX parameter.
     */
    protected void setStartX(int startX) 
    {
        this.start_x = startX;
    }

    /**
     * This Java function sets the value of the "start_y" variable to the input parameter "startY".
     * 
     * @param startY startY is an integer parameter representing the starting y-coordinate of an object
     * or element in a graphical user interface or game. The method sets the value of the startY
     * variable to the value passed as an argument to the method.
     */
    protected void setStartY(int startY) 
    {
        this.start_y = startY;
    }

    /**
     * This Java function sets the value of the "end_x" variable to the input parameter "endX".
     * 
     * @param endX endX is an integer parameter representing the x-coordinate of the end point of a
     * line segment. This method sets the value of the end_x instance variable to the value of the endX
     * parameter.
     */
    protected void setEndX(int endX) 
    {
        this.end_x = endX;
    } 

    /**
     * This Java function sets the value of the "end_y" variable to the input parameter "endY".
     * 
     * @param endY endY is an integer parameter representing the y-coordinate of the end point of a
     * line segment. This method sets the value of the end_y instance variable to the value of the endY
     * parameter.
     */
    protected void setEndY(int endY) 
    {
        this.end_y = endY;
    }

    /**
     * This function sets the value of a 2D integer array called "map".
     * 
     * @param map a 2-dimensional integer array representing a map or grid. The method sets the
     * instance variable "map" of the current object to the input parameter "map".
     */
    protected void setMap(int[][] map) 
    {
        this.map = map;
    }
}
