package datastructure.graph;

import graph.Graph;
import graph.Graph2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Graph2Test {


    @Test
    public void printBFS() {

        Graph2<Integer> graph2 = new Graph2<>();
        graph2.addEdges(0, 1);
        graph2.addEdges(0, 6);
        graph2.addEdges(0, 3);
        graph2.addEdges(1, 4);
        graph2.addEdges(1, 5);
        graph2.addEdges(1, 0);
        graph2.addEdges(2, 5);
        graph2.addEdges(2, 7);
        graph2.addEdges(3, 0);
        graph2.addEdges(3, 5);
        graph2.addEdges(4, 1);
        graph2.addEdges(4, 6);
        graph2.addEdges(5, 1);
        graph2.addEdges(5, 2);
        graph2.addEdges(5, 3);
        graph2.addEdges(6, 0);
        graph2.addEdges(6, 4);
        graph2.addEdges(7, 2);

        graph2.performBFS(0);
    }

    @Test
    public void printDFSs() {

        Graph2<Integer> graph2 = new Graph2<>();
        graph2.addEdges(0, 1);
        graph2.addEdges(0, 6);
        graph2.addEdges(0, 3);
        graph2.addEdges(1, 4);
        graph2.addEdges(1, 5);
        graph2.addEdges(1, 0);
        graph2.addEdges(2, 5);
        graph2.addEdges(2, 7);
        graph2.addEdges(3, 0);
        graph2.addEdges(3, 5);
        graph2.addEdges(4, 1);
        graph2.addEdges(4, 6);
        graph2.addEdges(5, 1);
        graph2.addEdges(5, 2);
        graph2.addEdges(5, 3);
        graph2.addEdges(6, 0);
        graph2.addEdges(6, 4);
        graph2.addEdges(7, 2);

        System.out.println("Using DFC");
        graph2.performDFS(0);
        System.out.println("\nUsing Recursive DFC");
        graph2.performDFSRec(0);
    }

    @Test
    public void depthFirstSearch2() {
        Graph2<Integer> g = new Graph2<>();

        //Cyclic Graph

        g.addEdges(0, 1);
        g.addEdges(0, 2);
        g.addEdges(1, 3);
        g.addEdges(2, 4);
        g.addEdges(4, 1);
        g.addEdges(5, 3);

        System.out.println("Following is depth First Traversal "+
                "(starting from vertex 0)");

        g.performDFS(0);
    }
    @Test
    public void depthFirstSearch3Cyclic() {
        Graph2<Integer> g = new Graph2<>();

        //Cyclic Graph

        g.addEdges(0, 1);
        g.addEdges(1, 2);
        g.addEdges(2, 0);

        System.out.println("Following is depth First Traversal "+
                "(starting from vertex 0)");

        g.performDFS(0);
    }

    @Test
    public void hasPathCyclic() {
        Graph2<Integer> g = new Graph2<>();

        //Cyclic Graph

        g.addEdges(0, 1);
        g.addEdges(1, 2);
        g.addEdges(2, 0);


        Assert.assertTrue(g.hasPath(0,2));;
        Assert.assertTrue(g.hasPath(0,1));;
        Assert.assertFalse(g.hasPath(0,4));;
    }

    @Test
    public void hasPath() {
        Graph2<Integer> graph2 = new Graph2<>();
        graph2.addEdges(0, 1);
        graph2.addEdges(0, 6);
        graph2.addEdges(0, 3);
        graph2.addEdges(1, 4);
        graph2.addEdges(1, 5);
        graph2.addEdges(1, 0);
        graph2.addEdges(2, 5);
        graph2.addEdges(2, 7);
        graph2.addEdges(3, 0);
        graph2.addEdges(3, 5);
        graph2.addEdges(4, 1);
        graph2.addEdges(4, 6);
        graph2.addEdges(5, 1);
        graph2.addEdges(5, 2);
        graph2.addEdges(5, 3);
        graph2.addEdges(6, 0);
        graph2.addEdges(6, 4);
        graph2.addEdges(7, 2);

        Assert.assertTrue(graph2.hasPath(0,2));;
        Assert.assertTrue(graph2.hasPath(0,1));;
        Assert.assertFalse(graph2.hasPath(0,11));;
    }

    @Test
    public void hasPathDirected() {
        Graph2<Integer> g = new Graph2<>();

        //Cyclic Graph

        g.addEdges(0, 1);
        g.addEdges(0, 2);
        g.addEdges(1, 3);
        g.addEdges(2, 4);
        g.addEdges(4, 1);
        g.addEdges(5, 3);

        Assert.assertFalse(g.hasPath(0,5));
        Assert.assertTrue(g.hasPath(0,2));
        Assert.assertTrue(g.hasPath(5,5));
    }

    @Test
    public void countNumComponentsTest() {
        Graph2<Integer> g = new Graph2<>();
        g.addEdges(0,8);
        g.addEdges(0,1);
        g.addEdges(0,5);
        g.addEdges(1,0);
        g.addEdges(5,0);
        g.addEdges(5,8);
        g.addEdges(8,0);
        g.addEdges(8,5);
        g.addEdges(2,3);
        g.addEdges(2,4);
        g.addEdges(3,2);
        g.addEdges(3,4);
        g.addEdges(4,3);
        g.addEdges(4,2);

        Assert.assertEquals(2,g.connectedComponentCount());

        g.addEdges(10,11);
        g.addEdges(10,12);

        Assert.assertEquals(3,g.connectedComponentCount());

        g.addEdges(100,200);

        Assert.assertEquals(4,g.connectedComponentCount());

    }

    @Test
    public void shortestDistance() {
        Graph2<String> g = new Graph2<>();
        g.addEdges("w","x");
        g.addEdges("x","w");
        g.addEdges("x","y");
        g.addEdges("y","x");
        g.addEdges("z","y");
        g.addEdges("y","z");
        g.addEdges("z","v");
        g.addEdges("v","z");
        g.addEdges("w","v");
        g.addEdges("v","w");
        g.addEdges("p","y");
        g.addEdges("y","p");

        int i = g.shortestPath("w", "p");
        System.out.println(i);

    }

    @Test
    public void testTopological() {
        Graph2<Integer> g = new Graph2<>();
        g.addEdges(5, 2);
        g.addEdges(5, 0);
        g.addEdges(4, 0);
        g.addEdges(4, 1);
        g.addEdges(2, 3);
        g.addEdges(3, 1);

        g.performTopologicalSort();

    }



}
