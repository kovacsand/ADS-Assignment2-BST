public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements BinarySearchTreeADT<E>
{

    @Override
    public boolean insert(E element)
    {
        if (super.contains(element))
            return false;

        BinaryTreeNodeADT<E> newNode = new BinaryTreeNode<>();
        newNode.setElement(element);

        if (super.isEmpty())
        {
            super.setRoot(newNode);
            return true;
        }

        BinaryTreeNodeADT<E> current = super.getRoot();
        while (true)
        {
            if (element.compareTo(current.getElement()) < 0)
            {
                if (current.getLeftChild() == null)
                {
                    current.addLeftChild(newNode);
                    return true;
                }
                current = current.getLeftChild();
            }
            else
            {
                if (current.getRightChild() == null)
                {
                    current.addRightChild(newNode);
                    return true;
                }
                current = current.getRightChild();
            }
        }
    }

    @Override
    public boolean removeElement(E element)
    {
        if (!super.contains(element))
            return false;

        BinaryTreeNodeADT<E> current = super.getRoot();
        BinaryTreeNodeADT<E> parent = null;
        while (true)
        {
            if (element.compareTo(current.getElement()) < 0)
            {
                parent = current;
                current = current.getLeftChild();
            }
            else if (element.compareTo(current.getElement()) > 0)
            {
                parent = current;
                current = current.getRightChild();
            }
            //Found the element
            else
            {
                //No children
                if (current.getLeftChild() == null && current.getRightChild() == null)
                {
                    if (parent == null)
                    {
                        super.setRoot(null);
                        return true;
                    }
                    if (current == parent.getLeftChild())
                        parent.addLeftChild(null);
                    else
                        parent.addRightChild(null);
                    return true;
                }
                //Only right child
                else if (current.getLeftChild() == null)
                {
                    if (parent == null)
                    {
                        super.setRoot(current.getRightChild());
                        return true;
                    }
                    if (current == parent.getLeftChild())
                        parent.addLeftChild(current.getRightChild());
                    else
                        parent.addRightChild(current.getRightChild());
                    return true;
                }
                //Only left child
                else if (current.getRightChild() == null)
                {
                    if (parent == null)
                    {
                        super.setRoot(current.getLeftChild());
                        return true;
                    }
                    if (current == parent.getLeftChild())
                        parent.addLeftChild(current.getLeftChild());
                    else
                        parent.addRightChild(current.getLeftChild());
                    return true;
                }
                //Two children -> get the minimum of the right subtree
                else
                {
                    BinarySearchTreeADT<E> right = new BinarySearchTree<>();
                    right.setRoot(current.getRightChild());
                    E min = right.findMin();
                    removeElement(min);
                    current.setElement(min);
                    return true;
                }
            }
        }
    }

    @Override
    public E findMin()
    {
        if (super.isEmpty())
            return null;

        BinaryTreeNodeADT<E> current = super.getRoot();
        while (current.getLeftChild() != null)
            current = current.getLeftChild();
        return current.getElement();
    }

    @Override
    public E findMax()
    {
        if (super.isEmpty())
            return null;

        BinaryTreeNodeADT<E> current = super.getRoot();
        while (current.getRightChild() != null)
            current = current.getRightChild();
        return current.getElement();
    }

    @Override
    public void rebalance()
    {
        //I used the DSW algorithm to create a balanced binary search tree
        //https://en.wikipedia.org/wiki/Day%E2%80%93Stout%E2%80%93Warren_algorithm
        //And used this website for some help
        //https://www.geeksforgeeks.org/day-stout-warren-algorithm-to-balance-given-binary-search-tree/

        //First, I create a right-sided linked list from the tree
        BinarySearchTreeADT<E> copy = new BinarySearchTree<>();
        while (!super.isEmpty())
        {
            copy.insert(findMin());
            removeElement(findMin());
        }
        super.setRoot(copy.getRoot());

        //Then, I calculate the number of nodes to rotate
        int h = (int) (Math.log(copy.size() + 1) / Math.log(2));
        int m = (int) Math.pow(2, h) - 1;

        //Then, I rotate the nodes
        BinaryTreeNodeADT<E> grandParent = new BinaryTreeNode<>();
        grandParent.addRightChild(super.getRoot());
        leftRotate(grandParent, copy.size() - m);
        for (m = m / 2; m > 0; m /= 2)
            leftRotate(grandParent, m);

        super.setRoot(grandParent.getRightChild());
    }

    private void leftRotate(BinaryTreeNodeADT<E> grandParent, int m)
    {
        BinaryTreeNodeADT<E> temp = grandParent.getRightChild();

        for (int i = 0; i < m; i++)
        {
            BinaryTreeNodeADT<E> oldTemp = temp;
            temp = temp.getRightChild();
            grandParent.addRightChild(temp);
            oldTemp.addRightChild(temp.getLeftChild());
            temp.addLeftChild(oldTemp);
            grandParent = temp;
            temp = temp.getRightChild();
        }
    }
}