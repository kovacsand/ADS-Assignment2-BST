import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest
{

    private BinaryTreeADT<Integer> tree;

    @BeforeEach
    void setUp()
    {
        tree = new BinaryTree<>();
    }

    @AfterEach
    void tearDown()
    {
        tree = null;
    }

    @Test
    void empty()
    {
        assertTrue(tree.isEmpty());
    }

    @Test
    void notEmpty()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        tree.setRoot(root);
        assertFalse(tree.isEmpty());
    }

    @Test
    void sizeZero()
    {
        assertEquals(0, tree.size());
    }

    @Test
    void sizeOne()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        tree.setRoot(root);
        assertEquals(1, tree.size());
    }

    @Test
    void sizeTwo()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        BinaryTreeNodeADT<Integer> left = new BinaryTreeNode<>();
        left.setElement(2);
        root.addLeftChild(left);
        tree.setRoot(root);
        assertEquals(2, tree.size());
    }

    @Test
    void sizeFive()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        BinaryTreeNodeADT<Integer> left = new BinaryTreeNode<>();
        left.setElement(2);
        BinaryTreeNodeADT<Integer> right = new BinaryTreeNode<>();
        right.setElement(3);
        root.addLeftChild(left);
        root.addRightChild(right);
        BinaryTreeNodeADT<Integer> leftLeft = new BinaryTreeNode<>();
        leftLeft.setElement(4);
        BinaryTreeNodeADT<Integer> leftRight = new BinaryTreeNode<>();
        leftRight.setElement(5);
        left.addLeftChild(leftLeft);
        left.addRightChild(leftRight);
        tree.setRoot(root);
        assertEquals(5, tree.size());
    }

    @Test
    void rootIsNull()
    {
        assertNull(tree.getRoot());
    }

    @Test
    void rootIsNotNull()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        tree.setRoot(root);
        assertNotNull(tree.getRoot());
    }

    @Test
    void addAndGetRoot()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        tree.setRoot(root);
        assertEquals(root, tree.getRoot());
    }

    @Test
    void oneInTreeContains()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        tree.setRoot(root);
        assertTrue(tree.contains(1));
    }

    @Test
    void oneInTreeNotContains()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        tree.setRoot(root);
        assertFalse(tree.contains(2));
    }

    @Test
    void fiveElementsInTreeContains()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        BinaryTreeNodeADT<Integer> left = new BinaryTreeNode<>();
        left.setElement(2);
        BinaryTreeNodeADT<Integer> right = new BinaryTreeNode<>();
        right.setElement(3);
        root.addLeftChild(left);
        root.addRightChild(right);
        BinaryTreeNodeADT<Integer> leftLeft = new BinaryTreeNode<>();
        leftLeft.setElement(4);
        BinaryTreeNodeADT<Integer> leftRight = new BinaryTreeNode<>();
        leftRight.setElement(5);
        left.addLeftChild(leftLeft);
        left.addRightChild(leftRight);
        tree.setRoot(root);
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(5));
    }

    @Test
    void heightOfEmpty()
    {
        assertEquals(-1, tree.height());
    }

    @Test
    void heightOne()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        tree.setRoot(root);
        assertEquals(1, tree.height());
    }

    @Test
    void heightThree()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        BinaryTreeNodeADT<Integer> left = new BinaryTreeNode<>();
        left.setElement(2);
        BinaryTreeNodeADT<Integer> leftLeft = new BinaryTreeNode<>();
        leftLeft.setElement(4);
        tree.setRoot(root);
        root.addLeftChild(left);
        left.addLeftChild(leftLeft);
        assertEquals(3, tree.height());
    }

    @Test
    void inOrder()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        BinaryTreeNodeADT<Integer> left = new BinaryTreeNode<>();
        left.setElement(2);
        BinaryTreeNodeADT<Integer> right = new BinaryTreeNode<>();
        right.setElement(3);
        root.addLeftChild(left);
        root.addRightChild(right);
        BinaryTreeNodeADT<Integer> leftLeft = new BinaryTreeNode<>();
        leftLeft.setElement(4);
        BinaryTreeNodeADT<Integer> leftRight = new BinaryTreeNode<>();
        leftRight.setElement(5);
        left.addLeftChild(leftLeft);
        left.addRightChild(leftRight);
        tree.setRoot(root);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(2);
        expected.add(5);
        expected.add(1);
        expected.add(3);
        assertEquals(expected, tree.inOrder());
    }

    @Test
    void preOrder()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        BinaryTreeNodeADT<Integer> left = new BinaryTreeNode<>();
        left.setElement(2);
        BinaryTreeNodeADT<Integer> right = new BinaryTreeNode<>();
        right.setElement(3);
        root.addLeftChild(left);
        root.addRightChild(right);
        BinaryTreeNodeADT<Integer> leftLeft = new BinaryTreeNode<>();
        leftLeft.setElement(4);
        BinaryTreeNodeADT<Integer> leftRight = new BinaryTreeNode<>();
        leftRight.setElement(5);
        left.addLeftChild(leftLeft);
        left.addRightChild(leftRight);
        tree.setRoot(root);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(3);
        assertEquals(expected, tree.preOrder());
    }

    @Test
    void postOrder()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        BinaryTreeNodeADT<Integer> left = new BinaryTreeNode<>();
        left.setElement(2);
        BinaryTreeNodeADT<Integer> right = new BinaryTreeNode<>();
        right.setElement(3);
        root.addLeftChild(left);
        root.addRightChild(right);
        BinaryTreeNodeADT<Integer> leftLeft = new BinaryTreeNode<>();
        leftLeft.setElement(4);
        BinaryTreeNodeADT<Integer> leftRight = new BinaryTreeNode<>();
        leftRight.setElement(5);
        left.addLeftChild(leftLeft);
        left.addRightChild(leftRight);
        tree.setRoot(root);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(5);
        expected.add(2);
        expected.add(3);
        expected.add(1);
        assertEquals(expected, tree.postOrder());
    }

    @Test
    void levelOder()
    {
        BinaryTreeNodeADT<Integer> root = new BinaryTreeNode<>();
        root.setElement(1);
        BinaryTreeNodeADT<Integer> left = new BinaryTreeNode<>();
        left.setElement(2);
        BinaryTreeNodeADT<Integer> right = new BinaryTreeNode<>();
        right.setElement(3);
        root.addLeftChild(left);
        root.addRightChild(right);
        BinaryTreeNodeADT<Integer> leftLeft = new BinaryTreeNode<>();
        leftLeft.setElement(4);
        BinaryTreeNodeADT<Integer> leftRight = new BinaryTreeNode<>();
        leftRight.setElement(5);
        left.addLeftChild(leftLeft);
        left.addRightChild(leftRight);
        tree.setRoot(root);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        assertEquals(expected, tree.levelOrder());
    }
}