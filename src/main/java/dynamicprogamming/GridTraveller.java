package dynamicprogamming;

import java.util.HashMap;

public class GridTraveller {

    public long numWays(long row, long col) {

        if (row == 0 || col == 0) return 0;
        if (row == 1 || col == 1) return 1; //this is also a valid case,if any dimension is one,the possible way is also one


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
