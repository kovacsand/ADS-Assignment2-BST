import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest
{
    private BinarySearchTreeADT<Integer> tree;

    @BeforeEach
    void setUp()
    {
        tree = new BinarySearchTree<>();
    }

    @AfterEach
    void tearDown()
    {
        tree = null;
    }

    @Test
    void insertOne()
    {
        assertTrue(tree.insert(1));
        assertEquals(1, tree.size());
        assertTrue(tree.contains(1));
    }

    @Test
    void insertFiveElements()
    {
        assertTrue(tree.insert(1));
        assertTrue(tree.insert(2));
        assertTrue(tree.insert(3));
        assertTrue(tree.insert(4));
        assertTrue(tree.insert(5));
        assertEquals(5, tree.size());
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(5));
    }

    @Test
    void insertAlreadyPresent()
    {
        assertTrue(tree.insert(1));
        assertFalse(tree.insert(1));
        assertEquals(1, tree.size());
        assertTrue(tree.contains(1));
    }

    @Test
    void removeOne()
    {
        assertTrue(tree.insert(1));
        assertTrue(tree.removeElement(1));
        assertEquals(0, tree.size());
        assertFalse(tree.contains(1));
    }

    @Test
    void removeNotPresent()
    {
        assertFalse(tree.removeElement(1));
        assertEquals(0, tree.size());
        assertFalse(tree.contains(1));
    }

    @Test
    void removeFiveElements()
    {
        assertTrue(tree.insert(1));
        assertTrue(tree.insert(2));
        assertTrue(tree.insert(3));
        assertTrue(tree.insert(4));
        assertTrue(tree.insert(5));
        assertTrue(tree.removeElement(1));
        assertTrue(tree.removeElement(2));
        assertTrue(tree.removeElement(3));
        assertTrue(tree.removeElement(4));
        assertTrue(tree.removeElement(5));
        assertEquals(0, tree.size());
        assertFalse(tree.contains(1));
        assertFalse(tree.contains(2));
        assertFalse(tree.contains(3));
        assertFalse(tree.contains(4));
        assertFalse(tree.contains(5));
    }

    @Test
    void removeChildless()
    {
        assertTrue(tree.insert(1));
        assertTrue(tree.insert(2));
        assertTrue(tree.removeElement(2));
        assertEquals(1, tree.size());
        assertFalse(tree.contains(2));
    }

    @Test
    void removeHasOnlyLeftChild()
    {
        assertTrue(tree.insert(4));
        assertTrue(tree.insert(2));
        assertTrue(tree.insert(1));
        assertTrue(tree.removeElement(2));
        assertEquals(2, tree.size());
        assertFalse(tree.contains(2));
        assertTrue(tree.contains(1));
    }

    @Test
    void removeHasOnlyRightChild()
    {
        assertTrue(tree.insert(4));
        assertTrue(tree.insert(5));
        assertTrue(tree.insert(7));
        assertTrue(tree.removeElement(5));
        assertEquals(2, tree.size());
        assertFalse(tree.contains(5));
        assertTrue(tree.contains(7));
    }

    @Test
    void removeHasTwoChildren()
    {
        assertTrue(tree.insert(4));
        assertTrue(tree.insert(2));
        assertTrue(tree.insert(1));
        assertTrue(tree.insert(3));
        assertTrue(tree.removeElement(2));
        assertEquals(3, tree.size());
        assertFalse(tree.contains(2));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(3));
    }

    @Test
    void findMin()
    {
        assertTrue(tree.insert(3));
        assertTrue(tree.insert(4));
        assertTrue(tree.insert(2));
        assertTrue(tree.insert(5));
        assertTrue(tree.insert(1));
        assertEquals(1, tree.findMin());
    }

    @Test
    void findMax()
    {
        assertTrue(tree.insert(1));
        assertTrue(tree.insert(2));
        assertTrue(tree.insert(3));
        assertTrue(tree.insert(5));
        assertTrue(tree.insert(4));
        assertEquals(5, tree.findMax());
    }

    @Test
    void rebalance()
    {
        //create an unbalanced tree with 5 elements
        assertTrue(tree.insert(5));
        assertTrue(tree.insert(1));
        assertTrue(tree.insert(2));
        assertTrue(tree.insert(4));
        assertTrue(tree.insert(3));
        assertEquals(tree.height(), 5);
        tree.rebalance();
        //check if the tree is balanced
        assertEquals(5, tree.size());
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(5));
        assertEquals(tree.height(), 3);
    }
}