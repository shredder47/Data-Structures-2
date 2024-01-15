package dynamicprogamming;

import java.util.ArrayList;
import java.util.List;

public class StandaloneFunctions {

    public List<Long> canSum(long target, long[] arr) {

        List<Long> visited = new ArrayList<>();

        boolean b = canSum(target, arr, visited);

        if (b) return visited;
        else return null;

    }


    public boolean canSum(long target, long[] arr, List<Long> visited) {

        if (target == 0) {
            return true;
        }
        if (target < 0) return false;

        for (long number : arr) {
            long currentTarget = target - number;
            if (canSum(currentTarget, arr, visited)) {

                visited.add(number);
                return true;
            }

        }
        return false;
    }

}


