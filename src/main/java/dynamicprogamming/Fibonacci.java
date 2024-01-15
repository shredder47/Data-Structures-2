package dynamicprogamming;

import java.util.HashMap;

public class Fibonacci {

    //0 1 1 2 3 5 8 13
    public  Long fibonacci(long n) {

        if (n == 0L) return 0L;
        if (n == 1L) return 1L;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public  Long fibMemoized(Long n) {
        return fibonacciMemoized(n, new HashMap<>());
    }

    private  Long fibonacciMemoized(Long n, HashMap<Long,Long> memo) {

        if (n == 0L) return 0L;
        if (n == 1L) return 1L;
        if(memo.containsKey(n))
            return memo.get(n);

        if (!memo.containsKey(n))
            memo.put(n,fibonacciMemoized(n - 1, memo) + fibonacciMemoized(n - 2, memo)) ;

        return memo.get(n);
    }

}
