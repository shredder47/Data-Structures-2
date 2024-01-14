package challanges;

import java.util.*;

public class NumberOfIslands<T> {

    private T[][] data;


    public NumberOfIslands(T[][] data) {
        this.data = data;
    }

    public int getMinIsland(T landSign) {
        return numberOfIslands(landSign, true);
    }

    public int getNumberOfIsland(T landSign) {
        return numberOfIslands(landSign, false);
    }

    private int numberOfIslands(T landSign, boolean getMin) {

        Set<String> visited = new HashSet<>();
        int numberOfLands = 0;

        int minSize = Integer.MAX_VALUE;
        for (int row = 0; row < data.length; row++) {

            for (int col = 0; col < data[row].length; col++) {

                //explore when the data is land as it not yet visited
                if (data[row][col] == landSign && !visited.contains(row + "," + col)) {
                    minSize = Math.min(minSize, checkNeighbors(data, row, col, visited, landSign));
                    //we found a Land
                    numberOfLands++;
                }

            }
        }
        if (getMin) return minSize;
        else return numberOfLands;
    }

    private int checkNeighbors(T[][] data, int row, int col, Set<String> visited, T landSign) {

        //Base case for the BFS Search
        if (row < 0 || row > data.length - 1 || col < 0 || col > data[row].length - 1 || data[row][col] != landSign)
            return 0;

        if (visited.contains(row + "," + col))
            return 0;

        // mark the land as visited
        visited.add(row + "," + col);
        int size = 1;

        //keep checking the neighbors and mark it as visited so that later we don't visit that land again
        size += checkNeighbors(data, row, col + 1, visited, landSign);//move right
        size += checkNeighbors(data, row, col - 1, visited, landSign);//move left
        size += checkNeighbors(data, row + 1, col, visited, landSign);//move down
        size += checkNeighbors(data, row - 1, col, visited, landSign);//move up

        return size;
    }


}
