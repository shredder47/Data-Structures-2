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

        //base case, found a combination
        if (target == 0) {
            return true;
        }

        //when target is going negative with the combination, stop/ prune the tree
        if (target < 0) return false;

        for (long number : arr) {

            // trying to close the target to 0 with all combinations available
            long currentTarget = target - number;

            boolean madeItToZero = canSum(currentTarget, arr, visited);
            if (madeItToZero) {
                // Once a base case triggers true return, trace back to the call stack and add those numbers to a visited list
                // or in other words, what was the number used that branched out to zero finally
                visited.add(number);
                return true;
            }

        }
        // Exhausted all combinations
        return false;
    }


    public List<Integer> bestSum(int target, int[] data) {

        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();

        allCombinations(target, data, visited, combinations);

        int bestIndex = 0;
        for (int i = 0; i < combinations.size(); i++) {
            if(combinations.get(i).size() < combinations.get(bestIndex).size())
                bestIndex = i;
        }

        if (combinations.isEmpty()) return null;

        return combinations.get(bestIndex);
    }

    public List<List<Integer>> allCombinations(int target, int[] data) {

        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();

        allCombinations(target, data, visited, combinations);

        return combinations;
    }

    private void allCombinations(int target, int[] numbers, List<Integer> visited, List<List<Integer>> combinations) {

        if (target == 0) {
            //If the target becomes zero, visited tracked the current tree branch, add it to the combination list
            combinations.add(new ArrayList<>(visited));
            return;
        }

        //Stop operation when the target becomes less than 0, prune the branch and return so that it can backtrack from that stack
        if (target < 0)
            return;

        for (int number : numbers) {

            visited.add(number);

            allCombinations(target - number, numbers, visited, combinations);

            //back track and remove the bad number and continue with next numbers
            visited.remove(visited.size() - 1);

        }
        return;
    }


}


