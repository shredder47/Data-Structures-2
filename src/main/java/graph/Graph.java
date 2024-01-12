package graph;


import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    int V; // side of vertex
    LinkedList adjMatrix[]; // Adjacency Matrix

    public Graph(int v) {

        V = v;
        adjMatrix = new LinkedList[V];
        // populate each node with another linkedList
        for (int i = 0; i < adjMatrix.length; i++) {
            adjMatrix[i] = new LinkedList();
        }
    }

    public void addEdge(int v1, int v2) {

        adjMatrix[v1].add(v2);

    }


    public void BFS(int s) {

        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        //for fist time
        visited[s] = true;

        System.out.println("Traversed:" + s);
        queue.add(s);

        while (!queue.isEmpty()) {

            //get the first element/deque
            s = queue.poll();

            //get the adjacent vertex for the given vertex s
            LinkedList edges = adjMatrix[s];
            Iterator iterator = edges.iterator();


            while (iterator.hasNext()) {

                s = (int) iterator.next();

                if (visited[s] == false) {

                    visited[s] = true;
                    System.out.println("Traversed:" + s);
                    queue.add(s);
                }
            }


        }


    }


}
