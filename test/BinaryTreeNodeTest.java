import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest
{

    private BinaryTreeNodeADT<Integer> node;

    @BeforeEach
    void setUp()
    {
        node = new BinaryTreeNode<>();
    }

    @AfterEach
    void tearDown()
    {
        node = null;
    }

    @Test
    void oneElementSetAndGetCorrectly()
    {
        node.setElement(1);
        assertEquals(1, node.getElement());
    }

    @Test
    void oneElementSetAndGetIncorrectly()
    {
        node.setElement(1);
        assertNotEquals(2, node.getElement());
    }

    @Test
    void setElementAgainCorrectly()
    {
        node.setElement(1);
        node.setElement(2);
        assertEquals(2, node.getElement());
    }

    @Test
    void addAndGetLeftChildCorrectly()
    {
        BinaryTreeNodeADT<Integer> leftChild = new BinaryTreeNode<>();
        node.addLeftChild(leftChild);
        assertEquals(leftChild, node.getLeftChild());
    }

    @Test
    void addAndGetRightChildCorrectly()
    {
        BinaryTreeNodeADT<Integer> rightChild = new BinaryTreeNode<>();
        node.addRightChild(rightChild);
        assertEquals(rightChild, node.getRightChild());
    }

    @Test
    void addAndGetLeftChildIncorrectly()
    {
        BinaryTreeNodeADT<Integer> leftChild = new BinaryTreeNode<>();
        node.addLeftChild(leftChild);
        BinaryTreeNodeADT<Integer> temp = new BinaryTreeNode<>();
        assertNotEquals(temp, node.getLeftChild());
    }

    @Test
    void addAndGetRightChildIncorrectly()
    {
        BinaryTreeNodeADT<Integer> rightChild = new BinaryTreeNode<>();
        node.addRightChild(rightChild);
        BinaryTreeNodeADT<Integer> temp = new BinaryTreeNode<>();
        assertNotEquals(temp, node.getRightChild());
    }

    @Test
    void addAndGetLeftGrandchildCorrectly()
    {
        BinaryTreeNodeADT<Integer> leftChild = new BinaryTreeNode<>();
        BinaryTreeNodeADT<Integer> leftGrandchild = new BinaryTreeNode<>();
        node.addLeftChild(leftChild);
        leftChild.addLeftChild(leftGrandchild);
        assertEquals(leftGrandchild, node.getLeftChild().getLeftChild());
    }

    @Test
    void addAndGetRightGrandchildCorrectly()
    {
        BinaryTreeNodeADT<Integer> rightChild = new BinaryTreeNode<>();
        BinaryTreeNodeADT<Integer> rightGrandchild = new BinaryTreeNode<>();
        node.addRightChild(rightChild);
        rightChild.addRightChild(rightGrandchild);
        assertEquals(rightGrandchild, node.getRightChild().getRightChild());
    }

    @Test
    void addAndGetLeftGrandchildIncorrectly()
    {
        BinaryTreeNodeADT<Integer> leftChild = new BinaryTreeNode<>();
        BinaryTreeNodeADT<Integer> leftGrandchild = new BinaryTreeNode<>();
        node.addLeftChild(leftChild);
        leftChild.addLeftChild(leftGrandchild);
        BinaryTreeNodeADT<Integer> temp = new BinaryTreeNode<>();
        assertNotEquals(temp, node.getLeftChild().getLeftChild());
    }

    @Test
    void addAndGetRightGrandchildIncorrectly()
    {
        BinaryTreeNodeADT<Integer> rightChild = new BinaryTreeNode<>();
        BinaryTreeNodeADT<Integer> rightGrandchild = new BinaryTreeNode<>();
        node.addRightChild(rightChild);
        rightChild.addRightChild(rightGrandchild);
        BinaryTreeNodeADT<Integer> temp = new BinaryTreeNode<>();
        assertNotEquals(temp, node.getRightChild().getRightChild());
    }
}