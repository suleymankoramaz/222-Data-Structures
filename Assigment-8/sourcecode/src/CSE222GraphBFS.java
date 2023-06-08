import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The CSE222GraphBFS class implements a breadth-first search algorithm to find the shortest path in a
 * graph and saves the path to a text file and a PNG image.
 */
public class CSE222GraphBFS 
{   
    /**
     * The Node class represents a vertex and its distance in a graph.
     */
    private class Node 
    {
        int vertex;
        double distance;

        Node(int vertex, double distance) 
        {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    private CSE222Graph graph;
    private int[][] map;

    // This is a constructor for the `CSE222GraphBFS` class that takes a `CSE222Graph` object as a
    // parameter. It initializes the `graph` instance variable with the passed `CSE222Graph` object and
    // creates a copy of the map array using the `copyMap` method and assigns it to the `map` instance
    // variable.
    protected CSE222GraphBFS(CSE222Graph graph) 
    {
        this.graph = graph;
        this.map = copyMap(graph.getMapArray()); //copying map because we will make changes, we don't want to change original map

        File directory = new File("BFS/TextFiles");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        directory = new File("BFS/PNGFiles");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        directory = new File("BFS");
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    /**
     * This function finds the shortest path between two vertices in a graph using breadth-first search
     * algorithm and saves the path to a file.
     * 
     * @param filename The name of the file where the shortest path will be written to.
     */
    protected void findShortestPath(String filename) 
    {
        long startTime = System.nanoTime();
        int startVertex = graph.getStartVertex();
        int endVertex = graph.getEndVertex();
        int totalVertices = graph.getTotalVertices();
    
        boolean[] visited = new boolean[totalVertices];
        int[] previous = new int[totalVertices];
    
        List<List<Integer>> adjacencyList = graph.getAdjacencyList();
        Queue<Integer> queue = new LinkedList<>();
    
        queue.offer(startVertex);
        visited[startVertex] = true;
        previous[startVertex] = -1;
    
        while(!queue.isEmpty()) 
        {
            int currentVertex = queue.poll();
    
            if(currentVertex == endVertex) 
            {
                break; // Reached the end vertex, stop BFS
            }
    
            List<Integer> neighbors = adjacencyList.get(currentVertex);
            for(int neighbor : neighbors) 
            {
                if(!visited[neighbor]) 
                {
                    visited[neighbor] = true;
                    previous[neighbor] = currentVertex;
                    queue.offer(neighbor);
                }
            }
        }
    
        List<Integer> path = new ArrayList<>();
    
        while(endVertex != -1) 
        {
            path.add(0, endVertex);
            endVertex = previous[endVertex];
        }
    
        if(path.get(0) != startVertex) 
        {
            System.out.println("No feasible path is found.");
        } 
        else
        {
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            double totalTimeInSecond = (double) totalTime / 1_000_000_000;
            filename = filename.replace(".txt", "");
            //System.out.println("BFS running time result for      " + filename + " is: " + totalTimeInSecond + " sec.");
            System.out.println("BFS Path size for      " + filename + ": " + path.size());
            pathToFile(path, filename);
        }
    }
    
    /**
     * The function takes a list of integers representing a path and a filename, prints the size of the
     * path, updates a 2D array with the path, converts the array to a PNG file, and writes the path to
     * a text file.
     * 
     * @param path A list of integers representing the path found by a BFS algorithm on a map.
     * @param filename The name of the file that the path information is being saved for.
     */
    private void pathToFile(List<Integer> path , String filename) 
    {

        
        if(path.size() == 1)
        {
            System.out.println("No feasible path is found.");
        }
        else
        {
            for(int i=0 ; i<path.size() ; i++)
            {
                int y = path.get(i)/map.length;
                int x = path.get(i) - y*map.length;
                map[y][x] = 2;
            }

            String png = "BFS/PNGFiles/" + filename + ".png";
            MapConverter mapConverter = new MapConverter();
            mapConverter.convertToPNG(map, png);
        }

        String txt = "BFS/TextFiles/" + filename + ".txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(txt))) 
        {
            for(Integer element : path) 
            {
                int y = element/map.length;
                int x = element - y*map.length;
                writer.write(y + "," + x);
                writer.newLine();
            }
        } 
        catch(IOException e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * This function creates a deep copy of a 2D integer array.
     * 
     * @param original a 2D integer array representing a map or grid.
     * @return The method is returning a copy of the input 2D integer array.
     */
    private int[][] copyMap(int[][] original) 
    {
        if(original == null) 
        {
            return null;
        }
        
        int[][] copy = new int[original.length][];
        for(int i = 0; i < original.length; i++) 
        {
            copy[i] = original[i].clone();
        }
        
        return copy;
    }
}
