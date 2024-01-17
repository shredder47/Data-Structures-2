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

    /*
                7                       7
            -5 /                   -5  /
              3                       3
         -5  /                   -3  /
          [-2] -> RETURN FALSE     [0] -> RETURN TRUE

      */

    private boolean canSum(long target, long[] arr, List<Long> visited) {

        //base case
        if (target == 0) {
            return true;
        }

        if (target < 0) return false;

        for (long number : arr) {

            // trying to close the target to 0 with all combinations available
            long currentTarget = target - number;

            if (canSum(currentTarget, arr, visited)) {

                //for each true returned, add the number that made it happen
                visited.add(number);
                return true;
            }

        }
        return false;
    }



}


