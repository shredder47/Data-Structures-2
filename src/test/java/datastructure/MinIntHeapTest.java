package datastructure;

import org.junit.Assert;
import org.junit.Test;

public class MinIntHeapTest {

        private MinIntHeap minHeap;

    @Test
    public void extractMin() {
        minHeap = new MinIntHeap();
        minHeap.insert(42);
        minHeap.insert(29);
        minHeap.insert(18);

        // Insert(35)
        minHeap.insert(35);

        // Test insert
        Assert.assertEquals(18, minHeap.data[0]);
        Assert.assertEquals(35, minHeap.data[1]);
        Assert.assertEquals(29, minHeap.data[2]);
        Assert.assertEquals(42, minHeap.data[3]);

//         Text extract max
        Assert.assertEquals(18, minHeap.extractMin());
        Assert.assertEquals(29, minHeap.extractMin());
        Assert.assertEquals(35, minHeap.extractMin());
        Assert.assertEquals(42, minHeap.extractMin());

    }

    @Test
    public void extractMinBigger() {
        minHeap = new MinIntHeap();
        minHeap.insert(42);
        minHeap.insert(29);
        minHeap.insert(18);
        minHeap.insert(14);
        minHeap.insert(7);
        minHeap.insert(18);
        minHeap.insert(12);
        minHeap.insert(11);
        minHeap.insert(13);

        Assert.assertEquals(7, minHeap.extractMin());
        Assert.assertEquals(11, minHeap.extractMin());
        Assert.assertEquals(12, minHeap.extractMin());
        Assert.assertEquals(13, minHeap.extractMin());
        Assert.assertEquals(14, minHeap.extractMin());
        Assert.assertEquals(18, minHeap.extractMin());
        Assert.assertEquals(18, minHeap.extractMin());
        Assert.assertEquals(29, minHeap.extractMin());
        Assert.assertEquals(42, minHeap.extractMin());
    }

}
