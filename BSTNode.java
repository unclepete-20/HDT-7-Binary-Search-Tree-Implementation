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

public class BSTNode<T>
{
    private BSTNode<T> parent;
    private BSTNode<T> leftChild;
    private BSTNode<T> rightChild;
    private T data;

    public BSTNode(T data)
    {
        this(null, null, null, data);
    }

    public BSTNode(BSTNode<T> parent, BSTNode<T> leftChild, BSTNode<T> rightChild, T data)
    {
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    
    /** 
     * @return BSTNode<T>
     */
    public BSTNode <T> getParent()
    {
        return parent;
    }

    
    /** 
     * @param parent
     */
    public void setParent(BSTNode <T> parent)
    {
        this.parent = parent;
    }

    
    /** 
     * @return BSTNode<T>
     */
    public BSTNode <T> getLeftChild()
    {
        return leftChild;
    }

    
    /** 
     * @param leftChild
     */
    public void setLeftChild(BSTNode <T> leftChild)
    {
        this.leftChild = leftChild;
    }

    
    /** 
     * @return BSTNode<T>
     */
    public BSTNode <T> getRightChild()
    {
        return rightChild;
    }

    
    /** 
     * @param rightChild
     */
    public void setRightChild(BSTNode <T> rightChild)
    {
        this.rightChild = rightChild;
    }

    
    /** 
     * @return T
     */
    public T getData()
    {
        return data;
    }

    
    /** 
     * @param data
     */
    public void setData(T data)
    {
        this.data = data;
    }

    
    /** 
     * @param child
     */
    public void removeChild(BSTNode<T> child)
    {
        if(child == null) return;
        if(this.getRightChild() == child)
        {
            this.setRightChild(null);
            return;
        }
        if(this.getLeftChild() == child)
            this.setLeftChild(null);
    }

    
    /** 
     * @return Iterator<BSTNode>
     */
    public Iterator<BSTNode> children()
    {
        List<BSTNode> childList = new LinkedList<>();
        if(this.leftChild != null) childList.add(leftChild);
        if(this.rightChild != null) childList.add(rightChild);
        return childList.iterator();
    }
}
