package graph;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

        //for the first time
        visited[s] = true;

        queue.add(s);

        while (!queue.isEmpty()) {

            //get the first element/deque
            s = queue.poll();
            System.out.println("Traversed:" + s);

            //get the adjacent vertex for the given vertex s
            LinkedList edges = adjMatrix[s];
            Iterator iterator = edges.iterator();


            while (iterator.hasNext()) {

                s = (int) iterator.next();

                if (visited[s] == false) {

                    visited[s] = true;
                    queue.add(s);
                }
            }

        }
    }

    public void DFS(int s){

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // put a first element at the stack
        stack.add(s);
        visited[s] = true;

        while (!stack.isEmpty()){

            Integer pop = stack.pop();
            System.out.println(pop);

            LinkedList currentNodeVertices = adjMatrix[pop];
            Iterator verticesIterator = currentNodeVertices.iterator();

            while (verticesIterator.hasNext()){

                int x = (int) verticesIterator.next();
                if(visited[x] == false){

                    visited[x] = true;
                    stack.add(x);

                }
            }
        }
    }

}
