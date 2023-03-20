public interface BinaryTreeNodeADT<E>
{
    void setElement(E element);
    E getElement();
    void addLeftChild(BinaryTreeNodeADT<E> leftChild);
    void addRightChild(BinaryTreeNodeADT<E> rightChild);
    BinaryTreeNodeADT<E> getLeftChild();
    BinaryTreeNodeADT<E> getRightChild();
}
