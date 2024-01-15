package datastructure.dynamicprogamming;

import dynamicprogamming.Fibonacci;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class FibonacciTest {


    @Test
    public void fibonacci()  {

        Fibonacci fib = new Fibonacci();
        Assert. assertEquals(Optional.of(13L).get(),fib.fibonacci(7L));
        Assert.assertEquals(Optional.of(13L).get(),fib.fibMemoized(7L));
        Assert.assertEquals(Optional.of(12586269025L).get(),fib.fibMemoized(50L));
    }

}