import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The `CSE222GraphDijkstra` class implements Dijkstra's algorithm to find the shortest path between
 * two vertices in a graph and saves the path to a text file and a PNG image.
 */
public class CSE222GraphDijkstra 
{
    /**
     * The class represents a node with a vertex and a distance in Java.
     */
    private class Node {
        int vertex;
        double distance;

        Node(int vertex, double distance) 
        {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    private List<List<Integer>> adjacencyList;
    private int[][] map;
    private int startVertex;
    private int endVertex;


    // This is a constructor for the `CSE222GraphDijkstra` class that takes a `CSE222Graph` object as a
    // parameter. It initializes the `adjacencyList`, `map`, `startVertex`, and `endVertex` instance
    // variables of the `CSE222GraphDijkstra` object with the corresponding values from the
    // `CSE222Graph` object. The `adjacencyList` is set to the adjacency list of the `CSE222Graph`, the
    // `map` is set to a copy of the map array of the `CSE222Graph`, and the `startVertex` and
    // `endVertex` are set to the start and end vertices of the `CSE222Graph`, respectively.
    protected CSE222GraphDijkstra(CSE222Graph graph) 
    {
        this.adjacencyList = graph.getAdjacencyList();
        this.map = copyMap(graph.getMapArray());
        this.startVertex = graph.getStartVertex();
        this.endVertex = graph.getEndVertex();

        File directory = new File("Dijkstra");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        directory = new File("Dijkstra/TextFiles");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        directory = new File("Dijkstra/PNGFiles");
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    /**
     * This function finds the shortest path between two vertices in a graph using Dijkstra's algorithm
     * and saves the path to a file.
     * 
     * @param filename The name of the file where the shortest path will be written to.
     */
    protected void findShortestPath(String filename) 
    {
        long startTime = System.nanoTime();
        int totalVertices = adjacencyList.size();
        double[] distances = new double[totalVertices];
        int[] previous = new int[totalVertices];

        Arrays.fill(distances, Double.POSITIVE_INFINITY);
        Arrays.fill(previous, -1);
        distances[startVertex] = 0.0;

        //visited set to keep track of visited vertices
        Set<Integer> visited = new HashSet<>();
        //priority queue to store vertices and weight
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(n -> n.distance));
        pq.offer(new Node(startVertex, 0.0));  

        while(!pq.isEmpty()) 
        {
            Node current = pq.poll();
            int currentVertex = current.vertex;

            //skip if the vertex has been visited
            if(visited.contains(currentVertex)) 
            {
                continue;
            }

            //mark the current vertex as visited
            visited.add(currentVertex);

            //stop if we reach the end
            if(currentVertex == endVertex) 
            {
                break;
            }

            //explore neighbors
            List<Integer> neighbors = adjacencyList.get(currentVertex);
            for(int neighbor : neighbors) 
            {
                double weight = calculateWeight(currentVertex, neighbor);
                double newDistance = distances[currentVertex] + weight;

                if(newDistance < distances[neighbor]) 
                {
                    distances[neighbor] = newDistance;
                    previous[neighbor] = currentVertex;
                    pq.offer(new Node(neighbor, newDistance));
                }
            }
        }

        //reconstruct the shortest path
        List<Integer> shortestPath = new ArrayList<>();
        int currentVertex = endVertex;
        while(currentVertex != -1) 
        {
            shortestPath.add(0, currentVertex);
            currentVertex = previous[currentVertex];
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        double totalTimeInSecond = (double) totalTime / 1_000_000_000;
        filename = filename.replace(".txt", "");
        //System.out.println("Dijkstra running time result for " + filename + " is: " + totalTimeInSecond + " sec.");
        System.out.println("Dijkstra Path size for " + filename + ": " + shortestPath.size());
        pathToFile(shortestPath, filename);
    }

    /**
     * The function takes a list of integers representing a path and a filename, prints the path size
     * and saves the path as a PNG and a text file.
     * 
     * @param path A list of integers representing the shortest path found by Dijkstra's algorithm.
     * Each integer corresponds to a node in the graph.
     * @param filename A string representing the name of the file to be created.
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
            String png = "Dijkstra/PNGFiles/" + filename + ".png";
            MapConverter mapConverter = new MapConverter();
            mapConverter.convertToPNG(map, png);
        }

        String txt = "Dijkstra/TextFiles/" + filename + ".txt";
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
     * The function calculates the weight between two vertices on a graph using their coordinates.
     * 
     * @param vertex1 The first vertex, represented as an integer where the thousands place represents
     * the y-coordinate and the hundreds and ones places represent the x-coordinate.
     * @param vertex2 vertex2 is an integer representing the second vertex in a graph. The method is
     * using this parameter to calculate the weight (distance) between two vertices in a graph.
     * @return The method `calculateWeight` returns a `double` value which represents the distance
     * between two vertices on a 2D plane.
     */
    private double calculateWeight(int vertex1, int vertex2) 
    {
        int y1 = vertex1 / 1000;      //get y coordinate of the start point
        int x1 = vertex1 - y1 * 1000; //get x coordinate of the start point
        int y2 = vertex2 / 1000;      //get y coordinate of the end point
        int x2 = vertex2 - y2 * 1000; //get x coordinate of the end point
        return Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2));  //return distance
    }

    /**
     * This function creates a deep copy of a 2D integer array.
     * 
     * @param original a 2D integer array representing a map or grid.
     * @return The method `copyMap` returns a copy of the input 2D integer array `original`. If the
     * input array is `null`, then the method returns `null`.
     */
    private int[][] copyMap(int[][] original) {
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
