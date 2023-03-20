import java.util.ArrayList;

public interface BinaryTreeADT<E>
{
    BinaryTreeNodeADT<E> getRoot();
    void setRoot(BinaryTreeNodeADT<E> root);
    boolean isEmpty();
    int size();
    boolean contains(E element);
    ArrayList<E> inOrder();
    ArrayList<E> preOrder();
    ArrayList<E> postOrder();
    ArrayList<E> levelOrder();
    int height();
}
