package datastructure.dynamicprogamming;

import dynamicprogamming.StandaloneFunctions;
import org.junit.Assert;
import org.junit.Test;

public class StandaloneFunctionsTest {


    @Test
    public void canSum() {

        StandaloneFunctions s = new StandaloneFunctions();
        System.out.println(s.canSum(7, new long[]{2, 3})); // [3,2,2]
        System.out.println(s.canSum(7, new long[]{5,3,4,7})); // [4,3]
        System.out.println(s.canSum(7, new long[]{2, 4})); // null
        System.out.println(s.canSum(8, new long[]{2, 3,5})); // [2,2,2,2]
        System.out.println(s.canSum(300, new long[]{7, 14})); // null

    }

    @Test
    public void allCombinations() {

        StandaloneFunctions s = new StandaloneFunctions();
        System.out.println(s.allCombinations(4, new int[]{1, 2}));
        System.out.println(s.bestSum(4, new int[]{1, 2}));


    }

    @Test
    public void canConstruct() {

        StandaloneFunctions s = new StandaloneFunctions();
        Assert.assertTrue(s.canConstruct("abcdef", new String[]{"ab","abc","cd","def","abcd"}));
        Assert.assertFalse(s.canConstruct("skateboard", new String[]{"bo","rd","ate","t","ska","sk","boar"}));
        Assert.assertTrue(s.canConstruct("enterapotentpot", new String[]{"a","p","ent","enter","ot","o","t"}));


    }

    @Test
    public void numWaysCanConstruct() {

        StandaloneFunctions s = new StandaloneFunctions();
        Assert.assertEquals(1,s.numWaysCanConstruct("abcdef", new String[]{"ab","abc","cd","def","abcd"}));
        Assert.assertEquals(0,s.numWaysCanConstruct("skateboard", new String[]{"bo","rd","ate","t","ska","sk","boar"}));
        Assert.assertEquals(4,s.numWaysCanConstruct("enterapotentpot", new String[]{"a","p","ent","enter","ot","o","t"}));
    }

    @Test
    public void combOfConstructs() {

        StandaloneFunctions s = new StandaloneFunctions();
        System.out.println(s.combinationOfConstruct("abcdef", new String[]{"ab","abc","cd","def","abcd"}));
        System.out.println(s.combinationOfConstruct("skateboard", new String[]{"bo","rd","ate","t","ska","sk","boar"}));
        System.out.println(s.combinationOfConstruct("enterapotentpot", new String[]{"a","p","ent","enter","ot","o","t"}));
    }



}