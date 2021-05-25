

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest{

    private CS400Graph<Integer> graph;
    private CS400Graph<Integer> graph2;
    @BeforeEach
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert vertices 0-9
        for(int i=0;i<10;i++)
            graph.insertVertex(i);
        // insert edges from Week 08. Dijkstra's Activity
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,7,2);
        graph.insertEdge(1,8,4);
        graph.insertEdge(2,4,4);
        graph.insertEdge(2,6,3);
        graph.insertEdge(3,1,6);
        graph.insertEdge(3,7,2);
        graph.insertEdge(4,5,4);
        graph.insertEdge(5,0,2);
        graph.insertEdge(5,1,4);
        graph.insertEdge(5,9,1);
        graph.insertEdge(6,3,1);
        graph.insertEdge(7,0,3);
        graph.insertEdge(7,6,1);
        graph.insertEdge(8,9,3);
        graph.insertEdge(9,4,5);
        
        
        
        graph2 = new CS400Graph<>();
        for(int i=0;i<10;i++)
          graph2.insertVertex(i);
      // insert edges using a random graph generator  
      graph2.insertEdge(0,3,6);
      graph2.insertEdge(1,5,3);
      graph2.insertEdge(5,3,2);
      graph2.insertEdge(2,5,4);
      graph2.insertEdge(5,6,7);
      graph2.insertEdge(6,4,5);
      graph2.insertEdge(4,2,2);
      graph2.insertEdge(4,6,2);
      graph2.insertEdge(6,7,5);
      graph2.insertEdge(4,7,9); 
    }

    
    /**
     * Checks the distance/total weight cost from the vertex labeled 0 to 8
     * (should be 15), and from the vertex labeled 9 to 8 (should be 17).
     */
    @Test
    public void providedTestToCheckPathCosts() {
        assertTrue(graph.getPathCost(0,8) == 15);    
        assertTrue(graph.getPathCost(9,8) == 17);
    }

    
    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labeled 0 to 8, and from the vertex labeled 9 to 8.
     */
    @Test
    public void providedTestToCheckPathContents() {
      
        assertTrue(graph.shortestPath(0, 8).toString().equals(
            "[0, 2, 6, 3, 1, 8]"
        ));
        assertTrue(graph.shortestPath(9, 8).toString().equals(
            "[9, 4, 5, 1, 8]"
        ));
    }
    
    
    /**
     * Checks the distance/total weight cost from the vertex labeled 1 to 5
     * (should be 14).
     */
    @Test
    public void activityTestPathCost() {
      assertTrue(graph.getPathCost(1,5) == 14); 
    }
    
    
    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labeled 0 to 8, and from the vertex labeled 9 to 8.
     */
    @Test
    public void activityTestPathContents() {
        assertTrue(graph.shortestPath(1, 5).toString().equals("[1, 7, 0, 2, 4, 5]"));
    }


    /**
     * Tests to ensure that the implementation is correct. 
     */
    @Test
    public void extraTest1() {  
      assertTrue(graph2.shortestPath(1, 4).toString().equals("[1, 5, 6, 4]"));
      assertTrue(graph2.getPathCost(1,4) == 15); 
    }
    
    
    /**
     * Tests to ensure that the implementation is correct. 
     */
    @Test
    public void extraTest2() {  
      assertTrue(graph2.shortestPath(5, 7).toString().equals("[5, 6, 7]"));
      assertTrue(graph2.getPathCost(5,7) == 12); 
    }
    
}