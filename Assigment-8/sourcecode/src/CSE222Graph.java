import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The CSE222Graph class represents a graph data structure that is created from a map and provides
 * methods to access and manipulate the graph.
 */
public class CSE222Graph 
{
    
    private List<List<Integer>> adjacencyList; //for neighbors
    private int startVertex;
    private int endVertex;
    private int[][] mapArray;
    private int width;
    private int height;
    private int totalVertices;

    // This is the constructor for the `CSE222Graph` class. It takes a `CSE222Map` object as a
    // parameter and initializes the graph based on the map.
    protected CSE222Graph(CSE222Map map) 
    {
        //initialization of variables
        mapArray = map.getMap();
        width = mapArray[0].length;
        height = mapArray.length;
        totalVertices = width * height;
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < totalVertices; i++) 
        {
            adjacencyList.add(new ArrayList<>());
        }

        //convert map to graph
        for(int y = 0; y < height; y++) 
        {
            for(int x = 0; x < width; x++) 
            {
                int vertex = y * width + x;
                if(mapArray[y][x] == 0) 
                {
                    //connect vertice with adjacent nodes if their coordinates are valid
                    if(isCoordinateValid(x - 1, y, width, height) && mapArray[y][x - 1] == 0) 
                    {
                        int neighbor = vertex - 1;
                        adjacencyList.get(vertex).add(neighbor);
                    }
                    if(isCoordinateValid(x + 1, y, width, height) && mapArray[y][x + 1] == 0)
                    {
                        int neighbor = vertex + 1;
                        adjacencyList.get(vertex).add(neighbor);
                    }
                    if(isCoordinateValid(x, y - 1, width, height) && mapArray[y - 1][x] == 0) 
                    {
                        int neighbor = vertex - width;
                        adjacencyList.get(vertex).add(neighbor);
                    }
                    if(isCoordinateValid(x, y + 1, width, height) && mapArray[y + 1][x] == 0) 
                    {
                        int neighbor = vertex + width;
                        adjacencyList.get(vertex).add(neighbor);
                    }
                    if(isCoordinateValid(x - 1, y - 1, width, height) && mapArray[y - 1][x - 1] == 0) 
                    {
                        int neighbor = vertex - width - 1;
                        adjacencyList.get(vertex).add(neighbor);
                    }
                    if(isCoordinateValid(x + 1, y - 1, width, height) && mapArray[y - 1][x + 1] == 0)
                    {
                        int neighbor = vertex + 1 - width;
                        adjacencyList.get(vertex).add(neighbor);
                    }
                    if(isCoordinateValid(x - 1, y + 1, width, height) && mapArray[y + 1][x - 1] == 0) 
                    {
                        int neighbor = vertex + width - 1;
                        adjacencyList.get(vertex).add(neighbor);
                    }
                    if(isCoordinateValid(x + 1, y + 1, width, height) && mapArray[y + 1][x + 1] == 0) 
                    {
                        int neighbor = vertex + width + 1;
                        adjacencyList.get(vertex).add(neighbor);
                    }
                }
            }
        }
        
        //set start and
        startVertex = map.getStartY() * width + map.getStartX();
        endVertex = map.getEndY() * width + map.getEndX();
    }

    /**
     * This Java function returns the start vertex.
     * 
     * @return The method is returning an integer value which represents the start vertex.
     */
    protected int getStartVertex() 
    {
        return startVertex;
    }

    /**
     * The function returns the end vertex of a graph.
     * 
     * @return The method is returning the value of the variable "endVertex", which is likely an
     * integer representing the endpoint of a graph edge or path.
     */
    protected int getEndVertex() 
    {
        return endVertex;
    }

    /**
     * The function returns a 2D integer array representing a map.
     * 
     * @return The method `getMapArray()` is returning a two-dimensional integer array called
     * `mapArray`.
     */
    protected int[][] getMapArray() 
    {
        return mapArray;
    }

    /**
     * The function returns the width of an object.
     * 
     * @return The method `getWidth()` is returning the value of the variable `width`.
     */
    protected int getWidth() 
    {
        return width;
    }

    /**
     * The function returns the height value.
     * 
     * @return The method `getHeight()` is returning the value of the `height` variable.
     */
    protected int getHeight() 
    {
        return height;
    }

    /**
     * The function returns the total number of vertices in a graph.
     * 
     * @return The method `getTotalVertices` is returning an integer value which represents the total
     * number of vertices.
     */
    protected int getTotalVertices() 
    {
        return totalVertices;
    }

    /**
     * The function returns an adjacency list as a list of lists of integers.
     * 
     * @return A List of Lists of Integers representing the adjacency list of a graph.
     */
    protected List<List<Integer>> getAdjacencyList() 
    {
        return adjacencyList;
    }

    /**
     * This function sets the value of a 2D integer array called "mapArray".
     * 
     * @param mapArray mapArray is a two-dimensional integer array that represents a map or grid. It
     * can be used to store information about the terrain, obstacles, or other features of the map. The
     * method setMapArray takes in a mapArray parameter and sets the instance variable of the class to
     * the value of the parameter
     */
    protected void setMapArray(int[][] mapArray) 
    {
        this.mapArray = mapArray;
    }

    /**
     * This function sets the value of the "width" variable in a Java class.
     * 
     * @param width The parameter "width" is an integer that represents the width of an object or
     * element. The method "setWidth" sets the value of the width attribute of an object to the
     * specified integer value.
     */
    protected void setWidth(int width) 
    {
        this.width = width;
    }

    /**
     * This function sets the height of an object.
     * 
     * @param height The parameter "height" is an integer value that is passed to the method
     * "setHeight". The method then sets the value of the instance variable "height" to the passed
     * value.
     */
    protected void setHeight(int height) 
    {
        this.height = height;
    }

    /**
     * This function sets the total number of vertices in a graph.
     * 
     * @param totalVertices totalVertices is an integer parameter that represents the total number of
     * vertices in a graph or a shape. The method setTotalVertices() sets the value of the
     * totalVertices variable to the value passed as an argument to the method.
     */
    protected void setTotalVertices(int totalVertices) 
    {
        this.totalVertices = totalVertices;
    }
   
    /**
     * The function checks if a given coordinate is within the bounds of a specified width and height.
     * 
     * @param x The x-coordinate of a point in a 2D plane.
     * @param y The parameter "y" represents the vertical coordinate of a point in a two-dimensional
     * space. It is used in the method to check if the given coordinate (x,y) is within the bounds of a
     * rectangle with the given width and height.
     * @param width The width of the grid or matrix in which the coordinates (x,y) are being checked.
     * @param height The height parameter in the isCoordinateValid method refers to the maximum valid
     * value for the y-coordinate. It represents the height of the grid or matrix in which the
     * coordinates (x, y) are being checked for validity.
     * @return A boolean value indicating whether the given coordinates (x, y) are within the bounds of
     * a rectangle with the given width and height.
     */
    private boolean isCoordinateValid(int x, int y, int width, int height) 
    {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
