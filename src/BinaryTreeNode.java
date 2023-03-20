public class BinaryTreeNode<E> implements BinaryTreeNodeADT<E>
{
    private E element;
    private BinaryTreeNodeADT<E> leftChild;
    private BinaryTreeNodeADT<E> rightChild;

    public BinaryTreeNode()
    {
        this.element = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public void setElement(E element)
    {
        this.element = element;
    }

    @Override
    public E getElement()
    {
        return element;
    }

    @Override
    public void addLeftChild(BinaryTreeNodeADT<E> leftChild)
    {
        this.leftChild = leftChild;
    }

    @Override
    public void addRightChild(BinaryTreeNodeADT<E> rightChild)
    {
        this.rightChild = rightChild;
    }

    @Override
    public BinaryTreeNodeADT<E> getLeftChild()
    {
        return leftChild;
    }

    @Override
    public BinaryTreeNodeADT<E> getRightChild()
    {
        return rightChild;
    }
}
