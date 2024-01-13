package graph;

import java.util.*;

public class Graph2<T> {

    private final Map<T, List<T>> adjMatrix;

    public Graph2() {
        this.adjMatrix = new HashMap<>();
    }

    public int connectedComponentCount() {

        Set<T> nodes = adjMatrix.keySet();
        Set<T> visited = new HashSet<>();

        int numComponents = 0;

        // Using every node as a starting point for BFS
        for (T node : nodes) {
            if (visited.contains(node)) continue;
            performDFSRec(node, visited);
            numComponents++;
        }


        return numComponents;
    }

    public void addEdges(T v1, T v2) {
        //If key is new
        if (!adjMatrix.containsKey(v1)) {
            //Create a new List for that key
            List<T> neighbors = new ArrayList<>();
            adjMatrix.put(v1, neighbors);
        }
        if (v2 != null)
            adjMatrix.get(v1).add(v2);
    }

    public boolean hasPath(T src, T dst) {

        Stack<T> stack = new Stack<>();
        Set<T> visited = new HashSet<>();

        stack.add(src);
        visited.add(src);

        while (!stack.isEmpty()) {

            T pop = stack.pop();

            if (pop == dst) return true;

            List<T> neighbors = adjMatrix.getOrDefault(pop, Collections.emptyList());

            //Explore neighbors if not visited
            for (T neighbor : neighbors) {

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.add(neighbor);
                }
            }
        }
        //If not found
        return false;
    }

    public void performDFSRec(T src) {
        Set<T> visited = new HashSet<>();
        performDFSRec(src, visited);
    }

    private void performDFSRec(T src, Set<T> visited) {

        System.out.println("Visited: " + src);

        visited.add(src);
        List<T> neighbors = adjMatrix.getOrDefault(src, Collections.emptyList());

        //Iteration of the list itself is a base case, i.e., when no neighbors end
        for (T neighbor : neighbors) {
            if (!visited.contains(neighbor))
                performDFSRec(neighbor, visited);
        }
    }

    public void performDFS(T src) {

        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();

        stack.add(src);
        visited.add(src);

        while (!stack.isEmpty()) {

            T pop = stack.pop();
            System.out.println(pop);

            //Keying in to get its neighbors
            List<T> neighbors = adjMatrix.getOrDefault(pop, Collections.emptyList());

            for (T neighbor : neighbors) {
                if (!visited.contains(neighbor)) {

                    stack.add(neighbor);
                    visited.add(neighbor);

                }
            }
        }
    }

    public void performBFS(T src) {

        Set<T> visited = new HashSet<>();
        LinkedList<T> queue = new LinkedList<>();

        queue.add(src);
        visited.add(src);

        while (!queue.isEmpty()) {

            T pop = queue.pop();
            System.out.println(pop);

            //Keying in to get its neighbors
            List<T> neighbors = adjMatrix.getOrDefault(pop, Collections.emptyList());

            for (T neighbor : neighbors) {
                if (!visited.contains(neighbor)) {

                    queue.add(neighbor);
                    visited.add(neighbor);

                }
            }
        }
    }


    public static void main(String[] args) {
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

        System.out.println(graph2.hasPath(3, 7));
    }


}
