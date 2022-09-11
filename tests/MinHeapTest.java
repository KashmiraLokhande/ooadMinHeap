import static org.junit.Assert.*;

public class MinHeapTest {

    @org.junit.Test
    public void insertNode() {
        MinHeap m1 = new MinHeap();
        m1.insertNode(45);
        m1.insertNode(65);
        m1.insertNode(90);
        assertEquals("30 Inserted", m1.insertNode(30));
    }


    @org.junit.Test
    public void swapNodeData() {
        MinHeap m1 = new MinHeap();
        m1.insertNode(10);
        int original = m1.swapNodeData(m1.root,11);
        assertEquals(m1.root.data, 11);
        assertEquals(original, 10);
    }

    @org.junit.Test
    public void postorder() {
        MinHeap m1 = new MinHeap();
        m1.insertNode(45);
        m1.insertNode(65);
        m1.insertNode(90);
        m1.insertNode(30);
        int a[] = new int[50];
        a[0] = 65;
        a[1] = 45;
        a[2] = 90;
        a[3] = 30;
        assertArrayEquals(m1.postorder(m1.root), a ) ;
    }

    @org.junit.Test
    public void preorder() {
        MinHeap m1 = new MinHeap();
        m1.insertNode(45);
        m1.insertNode(65);
        m1.insertNode(90);
        m1.insertNode(30);
        int preOrderTest[] = new int[50];
        preOrderTest[0] = 45;
        preOrderTest[1] = 65;
        assertArrayEquals(m1.oddPreorder(m1.root), preOrderTest ) ;

    }
}