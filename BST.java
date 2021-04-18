/**
 * @author unclepete-20
 * Carnet 20188
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 * Hoja de trabajo 7
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BST<T extends Comparable<T>>
{
    private BSTNode<T> root;
    private int size;

    public BST() {}

    private BSTNode<T> root()
    {
        return root;
    }

    private void addRoot(T data) throws Exception
    {
        if(root != null) throw new Exception("Root exists is the tree.");
        root = new BSTNode <>(data);
        size++;
    }

    public void add(T data) throws Exception
    {
        BSTNode<T> node = find(data);
        if (node == null)
            addRoot(data);
        else if (node.getData().compareTo(data) > 0)
            addLeft(node, data);
        else if (node.getData().compareTo(data) < 0)
            addRight(node, data);
        else node.setData(data);
    }

    private void addLeft(BSTNode<T> parent, T data)
    {
        BSTNode<T> left = new BSTNode <>(data);
        parent.setLeftChild(left);
        left.setParent(parent);
        size++;
    }

    private void addRight(BSTNode<T> parent, T data)
    {
        BSTNode<T> right = new BSTNode <>(data);
        parent.setRightChild(right);
        right.setParent(parent);
        size++;
    }

    public void remove(T data)
    {
        BSTNode<T> node = find(data);
        if(node == null || !node.getData().equals(data)) return;
        remove(node);
    }

    private BSTNode<T> remove(BSTNode<T> node)
    {
        if (isLeaf(node))
        {
            BSTNode<T> parent = node.getParent();
            if (parent == null) root = null;
            else parent.removeChild(node);
            size--;
            return parent;
        }
        BSTNode<T> descendant = descendant(node);
        promoteDescendant(node, descendant);
        return remove(descendant);
    }

    private void promoteDescendant(BSTNode<T> parent, BSTNode<T> descendant)
    {
        parent.setData(descendant.getData());
    }

    private BSTNode<T> descendant(BSTNode<T> parent)
    {
        BSTNode<T> child = parent.getLeftChild();
        if (child != null)
        {
            while (child.getRightChild() != null) child = child.getRightChild();
            return child;
        }
        child = parent.getRightChild();
        if (child != null)
        {
            while (child.getLeftChild() != null) child = child.getLeftChild();
            return child;
        }
        return child;
    }

    public T get(T data)
    {
        BSTNode<T> node = find(data);
        if(node == null || !node.getData().equals(data)) return null;
        return node.getData();
    }

    public boolean contains(T data)
    {
        BSTNode<T> node = find(data);
        if(node == null || !node.getData().equals(data)) return false;
        return true;
    }

    private BSTNode<T> find(T data)
    {
        if(root() == null) return null;
        return findRecursively(root(), data);
    }

    private BSTNode<T> findRecursively(BSTNode<T> parent, T data)
    {
        int comparison = data.compareTo(parent.getData());
        if(comparison == 0) return parent;
        else if(comparison < 0 && parent.getLeftChild() != null) return findRecursively(parent.getLeftChild(), data);
        else if(comparison > 0 && parent.getRightChild() != null) return findRecursively(parent.getRightChild(), data);
        return parent;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public int size()
    {
        return size;
    }

    private BSTNode<T> parent(BSTNode<T> child)
    {
        return child.getParent();
    }

    private boolean isInternal(BSTNode<T> node)
    {
        return node.children().hasNext();
    }

    private boolean isLeaf(BSTNode<T> node)
    {
        return !isInternal(node);
    }

    private int depth(BSTNode<T> node)
    {
        if(isLeaf(node)) return 0;
        return depth(node.getParent()) + 1;
    }

    private int height(BSTNode<T> node)
    {
        if(isLeaf(node)) return 0;

        int maxHeight = 0;
        Iterator<BSTNode> children = node.children();
        while (children.hasNext())
        {
            int height = height(children.next());
            if(height > maxHeight) maxHeight = height;
        }
        return maxHeight + 1;
    }

    public int height()
    {
        if(root == null) return -1;
        return height(root);
    }

    public List<T> preOrder()
    {
        List<T> list = new LinkedList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(BSTNode<T> node, List<T> list)
    {
        if(node == null) return;
        list.add(node.getData());

        Iterator<BSTNode> children = node.children();
        while (children.hasNext())
        {
            preOrder(children.next(), list);
        }
    }

    public List<T> postOrder()
    {
        List<T> list = new LinkedList <>();
        postOrder(root(), list);
        return list;
    }

    private void postOrder(BSTNode<T> node, List<T> list)
    {
        if(node == null) return;

        Iterator<BSTNode> children = node.children();
        while (children.hasNext())
        {
            postOrder(children.next(), list);
        }
        list.add(node.getData());
    }

    public List<T> levelOrder()
    {
        List<T> nodeList = new LinkedList <>();

        if(root() == null) return nodeList;

        Queue<BSTNode> nodeQueue = new ConcurrentLinkedQueue <>();

        try
        {
            nodeList.add(root().getData());
            nodeQueue.add(root());

            while (!nodeQueue.isEmpty())
            {
                BSTNode<T> node = nodeQueue.poll();
                Iterator<BSTNode> nodeItr = node.children();

                while (nodeItr.hasNext())
                {
                    BSTNode<T> treeNode = nodeItr.next();
                    nodeQueue.add(treeNode);
                    nodeList.add(treeNode.getData());
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return nodeList;
    }

    public List<T> inOrder()
    {
        List<T> answer = new LinkedList <>();
        inOrder(root(), answer);
        return answer;
    }

    private void inOrder(BSTNode<T> node, List<T> list)
    {
        if (node == null) return;
        inOrder(node.getLeftChild(), list);
        list.add(node.getData());
        inOrder(node.getRightChild(), list);
    }

    @Override
    public String toString()
    {
        return inOrder().toString();
    }
}