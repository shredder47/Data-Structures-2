package datastructure.graph;

import graph.Graph;
import org.junit.Before;
import org.junit.Test;


public class GraphTest {

    private Graph g;

    @Before
    public void SetUp() {
        g = new Graph(8);
    }

    @Test
    public void BreadFirstSearch() {

        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 4);
        g.addEdge(4, 1);
        g.addEdge(4, 6);
        g.addEdge(6, 4);
        g.addEdge(6, 0);
        g.addEdge(0, 6);
        g.addEdge(1, 5);
        g.addEdge(5, 1);
        g.addEdge(5, 3);
        g.addEdge(3, 5);
        g.addEdge(3, 0);
        g.addEdge(0, 3);
        g.addEdge(5, 2);
        g.addEdge(2, 5);
        g.addEdge(2, 7);
        g.addEdge(7, 2);



        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 0)");

        g.BFS(0);
    }

    @Test
    public void depthFirstSearch() {

        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 4);
        g.addEdge(4, 1);
        g.addEdge(4, 6);
        g.addEdge(6, 4);
        g.addEdge(6, 0);
        g.addEdge(0, 6);
        g.addEdge(1, 5);
        g.addEdge(5, 1);
        g.addEdge(5, 3);
        g.addEdge(3, 5);
        g.addEdge(3, 0);
        g.addEdge(0, 3);
        g.addEdge(5, 2);
        g.addEdge(2, 5);
        g.addEdge(2, 7);
        g.addEdge(7, 2);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 0)");

        g.DFS(0);
    }

    @Test
    public void depthFirstSearch2() {

        //Cyclic Graph
        g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 1);
        g.addEdge(5, 3);

        System.out.println("Following is depth First Traversal "+
                "(starting from vertex 0)");

        g.DFS(0);
    }

}
