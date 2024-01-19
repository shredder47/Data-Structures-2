package datastructure.backtracking;

import backtracking.Maze;
import org.junit.Assert;
import org.junit.Test;

public class MazeTest {

    @Test
    public void maze1() {

        int[][] mazeTable = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1}
        };

        Maze mazeProblem = new Maze(mazeTable);
        Assert.assertTrue(mazeProblem.solveMaze());
    }

    @Test
    public void maze2() {

        int[][] mazeTable = {
                {1, 1, 1, 0, 1},
                {1, 0, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1}
        };

        Maze mazeProblem = new Maze(mazeTable);
        Assert.assertFalse(mazeProblem.solveMaze());

    }
}
