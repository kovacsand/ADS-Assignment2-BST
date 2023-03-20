import java.util.ArrayList;

public class BinaryTree<E> implements BinaryTreeADT<E>
{
    private BinaryTreeNodeADT<E> root;

    public BinaryTree()
    {
        root = null;
    }

    @Override
    public BinaryTreeNodeADT<E> getRoot()
    {
        return root;
    }

    @Override
    public void setRoot(BinaryTreeNodeADT<E> root)
    {
        this.root = root;
    }

    @Override
    public boolean isEmpty()
    {
        return root == null;
    }

    @Override
    public int size()
    {
        if (isEmpty())
            return 0;
        BinaryTreeADT<E> left = new BinaryTree<>();
        BinaryTreeADT<E> right = new BinaryTree<>();
        left.setRoot(root.getLeftChild());
        right.setRoot(root.getRightChild());
        return 1 + left.size() + right.size();
    }

    @Override
    public boolean contains(E element)
    {
        if (isEmpty())
            return false;
        if (root.getElement().equals(element))
            return true;
        BinaryTreeADT<E> left = new BinaryTree<>();
        BinaryTreeADT<E> right = new BinaryTree<>();
        left.setRoot(root.getLeftChild());
        right.setRoot(root.getRightChild());
        return left.contains(element) || right.contains(element);
    }

    @Override
    public ArrayList<E> inOrder()
    {
        if (isEmpty())
            return null;
        BinaryTreeADT<E> left = new BinaryTree<>();
        BinaryTreeADT<E> right = new BinaryTree<>();
        left.setRoot(root.getLeftChild());
        right.setRoot(root.getRightChild());

        ArrayList<E> list = new ArrayList<>();
        list.addAll(left.inOrder() == null ? new ArrayList<>() : left.inOrder());
        list.add(root.getElement());
        list.addAll(right.inOrder() == null ? new ArrayList<>() : right.inOrder());
        return list;
    }

    @Override
    public ArrayList<E> preOrder()
    {
        if (isEmpty())
            return null;
        BinaryTreeADT<E> left = new BinaryTree<>();
        BinaryTreeADT<E> right = new BinaryTree<>();
        left.setRoot(root.getLeftChild());
        right.setRoot(root.getRightChild());

        ArrayList<E> list = new ArrayList<>();
        list.add(root.getElement());
        list.addAll(left.preOrder() == null ? new ArrayList<>() : left.preOrder());
        list.addAll(right.preOrder() == null ? new ArrayList<>() : right.preOrder());
        return list;
    }

    @Override
    public ArrayList<E> postOrder()
    {
        if (isEmpty())
            return null;
        BinaryTreeADT<E> left = new BinaryTree<>();
        BinaryTreeADT<E> right = new BinaryTree<>();
        left.setRoot(root.getLeftChild());
        right.setRoot(root.getRightChild());

        ArrayList<E> list = new ArrayList<>();
        list.addAll(left.postOrder() == null ? new ArrayList<>() : left.postOrder());
        list.addAll(right.postOrder() == null ? new ArrayList<>() : right.postOrder());
        list.add(root.getElement());
        return list;
    }

    @Override
    public ArrayList<E> levelOrder()
    {
        if (isEmpty())
            return null;
        ArrayList<E> list = new ArrayList<>();
        ArrayList<BinaryTreeNodeADT<E>> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            BinaryTreeNodeADT<E> node = queue.remove(0);
            list.add(node.getElement());
            if (node.getLeftChild() != null)
                queue.add(node.getLeftChild());
            if (node.getRightChild() != null)
                queue.add(node.getRightChild());
        }
        return list;
    }

    @Override
    public int height()
    {
        if (isEmpty())
            return -1;
        BinaryTreeADT<E> left = new BinaryTree<>();
        BinaryTreeADT<E> right = new BinaryTree<>();
        left.setRoot(root.getLeftChild());
        right.setRoot(root.getRightChild());
        return 1 + Math.max(left.height() == -1 ? 0 : left.height(), right.height() == -1 ? 0 : right.height());
    }
}
