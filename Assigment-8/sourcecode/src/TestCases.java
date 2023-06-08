

public class TestCases implements Runnable 
{
    private String FileName;

    public TestCases(String FileName) {
        this.FileName = FileName;

    }
    
    public void test(){
        
        //MY MAIN FUNCTION
        CSE222Map           map_object      = new CSE222Map(this.FileName); 
        CSE222Graph         graph_object    = new CSE222Graph(map_object);
        CSE222GraphDijkstra dijkstra_object = new CSE222GraphDijkstra(graph_object);
        CSE222GraphBFS      BFS_object      = new CSE222GraphBFS(graph_object);

        MapConverter mapConverter = new MapConverter();
        dijkstra_object.findShortestPath(this.FileName);
        BFS_object.findShortestPath(this.FileName); 
        //END MAIN FUNCTION
    }

    @Override
    public void run() {
        test();
    }
}

