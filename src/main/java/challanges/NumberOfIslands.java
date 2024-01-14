package challanges;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands<T> {

    private T[][] data;


    public NumberOfIslands(T[][] data) {
        this.data = data;
    }

    public int numberOfIslands(T landSign) {

        Set<String> visited = new HashSet<>();
        int numberOfLands = 0;
        for (int row = 0; row < data.length; row++) {

            for (int col = 0; col < data[row].length; col++) {

                //explore when the data is land as it not yet visited
                if (data[row][col] == landSign && !visited.contains(row + "," + col)) {

                    checkNeighbors(data, row, col, visited, landSign);
                    //we found a Land
                    numberOfLands++;
                }

            }
        }

        return numberOfLands;
    }

    private void checkNeighbors(T[][] data, int row, int col, Set<String> visited, T landSign) {

        //Base case for the BFS Search
        if (row < 0 || row > data.length - 1 || col < 0 || col > data[row].length - 1 || data[row][col] != landSign)
            return;

        if (visited.contains(row + "," + col))
            return;

        // mark the land as visited
        visited.add(row + "," + col);

        //keep checking the neighbors and mark it as visited so that later we don't visit that land again
        checkNeighbors(data, row, col + 1, visited, landSign);//move right
        checkNeighbors(data, row, col - 1, visited, landSign);//move left
        checkNeighbors(data, row + 1, col, visited, landSign);//move down
        checkNeighbors(data, row - 1, col, visited, landSign);//move up


    }


}
