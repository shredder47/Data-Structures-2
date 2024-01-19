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
            if (combinations.get(i).size() < combinations.get(bestIndex).size())
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


    /*
                        abcdef
                      /    |    \
                 ab  /     | abc \ abcd
                    /      |      \
                 cdef     def     ef
                   |       |
                cd |       | def
                   |       |
                   ef    [''] -> True

            only remove prefix, no removal from mid or end

     */


    //abcdef , [ab,abc,cd,def,abcd]
    public boolean canConstruct(String target, String[] wordBank) {

        //base case, when target is empty return true

        if (target.isEmpty()) {
            return true;
        }

        for (String word : wordBank) {

            //If word starts matching from the first end, ex: abcdef.indexOf(ab) = 0 || abcdef.indexOf(bc) = 1
            if (target.indexOf(word) == 0) {
                String newTarget = target.substring(word.length());

                boolean canConstruct = canConstruct(newTarget, wordBank);
                if (canConstruct)
                    return true;
            }

        }

        return false;
    }

    public int numWaysCanConstruct(String target, String[] wordBank) {

        //base case, when target is empty return true

        if (target.isEmpty()) {
            return 1;
        }
        int numWays = 0;
        for (String word : wordBank) {

            //If word starts matching from the first end, ex: abcdef.indexOf(ab) = 0 || abcdef.indexOf(bc) = 1
            if (target.indexOf(word) == 0) {
                String newTarget = target.substring(word.length());

                int numWaysCanConstruct = numWaysCanConstruct(newTarget, wordBank);
                numWays = numWays + numWaysCanConstruct;
            }
        }
        return numWays;
    }

    public List<List<String>> combinationOfConstruct(String target, String[] wordBank) {
        List<List<String>> combinations = new ArrayList<>();
        List<String> visitedWords = new ArrayList<>();
        combinationOfConstruct(target, wordBank, combinations, visitedWords);
        if (combinations.isEmpty()) return null;
        else return combinations;
    }

    private void combinationOfConstruct(String target, String[] wordBank, List<List<String>> combinations, List<String> visitedWords) {

        //base case, when target is empty return true

        if (target.isEmpty()) {
            combinations.add(new ArrayList<>(visitedWords));
            return;
        }

        for (String word : wordBank) {

            //If word starts matching from the first end, ex: abcdef.indexOf(ab) = 0 || abcdef.indexOf(bc) = 1
            if (target.indexOf(word) == 0) {
                visitedWords.add(word);
                String newTarget = target.substring(word.length());

                combinationOfConstruct(newTarget, wordBank, combinations, visitedWords);

                //Once the above function has returned either with true or false, back track and do the next combination
                visitedWords.remove(visitedWords.size() - 1);
            }
        }


        return;
    }


}


