package graph;

import java.util.*;

public class Graph2<T> {

    private final Map<T, List<T>> adjList;

    public Graph2() {
        this.adjList = new HashMap<>();
    }

    public void addEdges(T v1, T v2) {
        //If key is new
        if (!adjList.containsKey(v1)) {
            //Create a new List for that key
            List<T> neighbors = new ArrayList<>();
            adjList.put(v1, neighbors);
        }
        if (v2 != null)
            adjList.get(v1).add(v2);
    }


    //----- Properties

    public int shortestPath(T src, T dst) {

        if (src == dst) return 0;

        Set<T> visited = new HashSet<>();

        //We can only use BFS for this algorithm
        Queue<String> queue = new LinkedList<>();

        visited.add(src);
        queue.add(src + "_" + "0");

        while (!queue.isEmpty()) {

            String keyAndDistance = queue.poll();
            T key = (T) keyAndDistance.split("_")[0];
            int distance = Integer.parseInt(keyAndDistance.split("_")[1]);

            if (dst.equals(key)) return distance;

            List<T> neighbors = adjList.getOrDefault(key, Collections.emptyList());

            for (T neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor + "_" + (distance + 1));
                }
            }
        }


        return -1;
    }

    public int connectedComponentCount() {

        Set<T> nodes = adjList.keySet();
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

    public boolean hasPath(T src, T dst) {

        Stack<T> stack = new Stack<>();
        Set<T> visited = new HashSet<>();

        stack.add(src);
        visited.add(src);

        while (!stack.isEmpty()) {

            T pop = stack.pop();

            if (pop == dst) return true;

            List<T> neighbors = adjList.getOrDefault(pop, Collections.emptyList());

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

    public boolean hasCycleUnDirected(T src) {

        return performDFSCycleDetection(src);

    }

    public boolean performDFSCycleDetection(T src) {

        // Key as Vertex, Value as its Parent
        Map<T, T> visited = new HashMap<>();
        Stack<T> stack = new Stack<>();

        visited.put(src, null);
        stack.add(src);

        while (!stack.isEmpty()) {

            T pop = stack.pop();

            List<T> neighbors = adjList.getOrDefault(pop, Collections.emptyList());

            for (T neighbor : neighbors) {
                // if vertex is not visited
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, pop);
                    stack.add(neighbor);
                } else { // when vertex is already visited,
                    //check who introduced the current element
                    T vertexIntroducedBy = visited.get(pop); // parent of the current element

                    // if parent is a neighbor or null (in case of starting position)
                    // then its fine else there is a cycle.
                    // in the case of A <--> B, A's parent is null,
                    // but B's parent is A. so when B's neighbors are being evaluated,
                    // A is supposed to come as A is B's neighbor,
                    // but it will not be a cycle as B as introduced by A
                    if (vertexIntroducedBy == neighbor || vertexIntroducedBy == null)
                        continue;
                    else
                        return true;
                }

            }
        }

        return false;
    }

    public boolean hasCycleDirectedGraph(T src) {

        Set<T> vertices = adjList.keySet();
        //This will contain all the vertices that are processed/visited previously
        Set<T> processedVertices = new HashSet<>();

        //Check all paths even the disconnected ones
        for (T vertex : vertices) {
            //If the vertex is visited/processed previously then ignore
            if (!processedVertices.contains(vertex)) {

                HashSet<T> visited = new HashSet<>();
                boolean foundCycle = hasCycleDFSDirectedGraph(vertex, visited);

                if (foundCycle == false) {
                    processedVertices.addAll(visited);
                    //if no cycle found so far continue, with other paths if available
                    hasCycleDFSDirectedGraph(src, visited);
                } else return true;
            }
        }

        //No cycle found so far after checking all vertices
        return false;
    }

    private boolean hasCycleDFSDirectedGraph(T src, Set<T> visited) {

        Stack<T> stack = new Stack<>();

        stack.add(src);
        visited.add(src);

        while (!stack.isEmpty()) {

            T pop = stack.pop();

            List<T> neighbors = adjList.getOrDefault(pop, Collections.emptyList());

            for (T neighbor : neighbors) {

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.add(neighbor);
                } else
                    // if any path is leading to a previously visited node, that means it has a cycle
                    return true;
            }
        }
        return false;
    }


    //------Traversing-----
    public void performDFSRec(T src) {
        Set<T> visited = new HashSet<>();
        performDFSRec(src, visited);
    }

    private void performDFSRec(T src, Set<T> visited) {

        System.out.println("Visited: " + src);

        visited.add(src);
        List<T> neighbors = adjList.getOrDefault(src, Collections.emptyList());

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
            List<T> neighbors = adjList.getOrDefault(pop, Collections.emptyList());

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
            List<T> neighbors = adjList.getOrDefault(pop, Collections.emptyList());

            for (T neighbor : neighbors) {
                if (!visited.contains(neighbor)) {

                    queue.add(neighbor);
                    visited.add(neighbor);

                }
            }
        }
    }

    //------Sorting--------


    //Only Applicable on DAG
    public void performTopologicalSort() {

        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();


        // So that it goes to disconnected nodes
        for (T t : adjList.keySet()) {
            performDFSRecTopological(t, visited, stack);
        }

        //Print the Stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private void performDFSRecTopological(T src, Set<T> visited, Stack<T> stack) {

        /* As all visited nodes are calling this, we don't want to perform same operations */
        if (visited.contains(src))
            return;

        visited.add(src);
        List<T> neighbors = adjList.getOrDefault(src, Collections.emptyList());

        //Iteration of the list itself is a base case, i.e., when no neighbors end
        for (T neighbor : neighbors) {
            if (!visited.contains(neighbor))
                performDFSRecTopological(neighbor, visited, stack);
        }

        //After adding everything, add the current element to stack
        stack.push(src);
    }

}
