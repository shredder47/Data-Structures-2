package datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class DynamicArrayTest {


    private DynamicArray array;

    @Before
    public void SetUp() {
        array = new DynamicArray(2);
    }

    @Test
    public void GetAndSet() {
        array.set(0, "a");
        Assert.assertEquals("a", array.get(0));
    }

    @Test
    public void Insert() {
        array.add("a"); // 0
        array.add("b"); // 1
        array.add("c"); // 2

        array.insert(1, "d");

        Assert.assertEquals(4, array.size());
        Assert.assertEquals("a", array.get(0));
        Assert.assertEquals("d", array.get(1));
        Assert.assertEquals("b", array.get(2));
        Assert.assertEquals("c", array.get(3));
    }

    @Test
    public void DeleteFirst() {
        array.add("a");
        array.add("b");
        array.add("c");

        array.delete(0);

        Assert.assertEquals(2, array.size());
        Assert.assertEquals("b", array.get(0));
        Assert.assertEquals("c", array.get(1));
        Assert.assertEquals(null, array.get(2));
    }

    @Test
    public void DeleteMiddle() {
        array.add("a");
        array.add("b");
        array.add("c");
        array.add("d");

        array.delete(1);

        Assert.assertEquals(3, array.size());
        Assert.assertEquals("a", array.get(0));
        Assert.assertEquals("c", array.get(1));
        Assert.assertEquals("d", array.get(2));
        Assert.assertEquals(null, array.get(3));
    }

    @Test
    public void deleteAll() {
        array.add("a");
        array.add("b");
        array.add("c");
        array.add("d");

        array.delete(7);// Greater than capacity,Ignore

        array.delete(0);
        array.delete(1);
        array.delete(2);
        array.delete(3);
        array.delete(0);// Array is empty but trying to delete element from 0 index
        array.delete(2);// Array is empty but trying to delete random element

        Assert.assertEquals(0, array.size());
        Assert.assertEquals(null, array.get(0));

    }
    @Test
    public void DeleteLast() {
        array.add("a");
        array.add("b");
        array.add("c");

        array.delete(2);

        Assert.assertEquals(2, array.size());
        Assert.assertEquals("a", array.get(0));
        Assert.assertEquals("b", array.get(1));
        Assert.assertEquals(null, array.get(2));
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(array.isEmpty());
        array.add("a");
        Assert.assertFalse(array.isEmpty());
    }

    @Test
    public void contains()  {
        Assert.assertFalse(array.contains("a"));
        array.add("a");
        Assert.assertTrue(array.contains("a"));
        array.add("b");
        array.add("b");
        array.add("c");
        Assert.assertTrue(array.contains("b"));
        Assert.assertTrue(array.contains("c"));
        array.delete(3);
        Assert.assertFalse(array.contains("c"));
        array.delete(2);
        Assert.assertTrue(array.contains("b"));
        array.delete(1);
        Assert.assertFalse(array.contains("b"));
        array.delete(0);
        Assert.assertFalse(array.contains("a"));
    }

}