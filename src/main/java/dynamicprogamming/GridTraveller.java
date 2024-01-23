package dynamicprogamming;

import java.util.HashMap;

public class GridTraveller {

    /***
     *
     * Problem Statement: Given a 2-D matrix with M rows and N columns, find the number of ways to reach cell with coordinates (i,j) from starting cell (0,0) under the condition that you can only travel one step right or one step down.
     */

/*
              0       1        2          3

          ┌───────┬────────┬────────┬─────────┐
          │       │        │        │         │                       0       1        2          3
    0     │       │        │        │         │              0     xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
          │   src │        │        │         │                    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
          │       │        │        │         │                    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
          ├───────┼────────┼────────┼─────────┤                    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
          │       │        │        │         │                    │       │        │        │           │
          │       │        │        │         │                    │       │        │        │           │
    1     │       │        │        │         │              1     │  src  │        │        │           │
          │       │        │        │         │                    │       │        │        │           │
          ├───────┼────────┼────────┼─────────┤  --->              ├───────┼────────┼────────┼───────────┤
          │       │        │        │         │                    │       │        │        │           │
    2     │       │        │        │         │              2     │       │        │        │           │
          │       │        │        │         │                    │       │        │        │           │
          ├───────┼────────┼────────┼─────────┤                    ├───────┼────────┼────────┼───────────┤
          │       │        │        │         │                    │       │        │        │           │
          │       │        │        │  dest   │                    │       │        │        │  dest     │
    3     │       │        │        │         │              3     │       │        │        │           │
          └───────┴────────┴────────┴─────────┘                    └───────┴────────┴────────┴───────────┘
 */

    public long numWays(long row, long col) {

        if (row == 0 || col == 0) return 0;
        if (row == 1 || col == 1) return 1; //this is also a valid case,if any dimension is one,the possible way is also one

        //row -1, col means we step down, therefore, we can say a 3by3 matrix now becomes 2by3 matrix
        return numWays(row - 1, col) + numWays(row, col - 1);
    }

    public long numWaysMemo(long row, long col) {

        return numWaysMemo(row, col, new HashMap<>());
    }

    private long numWaysMemo(long row, long col, HashMap<String, Long> memo) {
        if (row == 0 || col == 0) return 0;
        if (row == 1 && col == 1) return 1;
        String key = row + "," + col;

        if (memo.containsKey(key))
            return memo.get(key);
        else memo.put(key, numWaysMemo(row - 1, col, memo) + numWaysMemo(row, col - 1, memo));

        return memo.get(key);
    }
}
