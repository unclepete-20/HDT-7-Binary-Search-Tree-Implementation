/**
 * @author unclepete-20
 * Carnet 20188
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 * Hoja de trabajo 7
 */

// Java program to demonstrate
// insert operation in binary
// search tree
class BST {
 
    /* Class containing left
       and right child of current node
     * and key value*/
    class Node {
        Association<Integer,String[]> associations;
        int key;
        Node left, right;
 
        public Node(int item, Association<Integer,String[]> association) {
            key = item;
            left = right = null;
            associations = association;
        }

        public String[] getKey(){ //Regresa el valor del nodo.
            return associations.getValue();
            
        }
    }
 
    // Root of BST
    Node root;
 
    // Constructor
    BST()
    {
         root = null;
    }
 
    
    /** 
     * @param key
     */
    // This method mainly calls insertRec()
    void insert(int key)
    {
         root = insertRec(root, key);
    }
 
    
    /** 
     * @param root
     * @param key
     * @return Node
     */
    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, int key)
    {
 
        /* If the tree is empty,
           return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
 
    // This method mainly calls InorderRec()
    void inorder()
    {
         inorderRec(root);
    }
 
    
    /** 
     * @param root
     */
    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    
    /** 
     * @param root
     * @param key
     * @return Node
     */
    // A utility function to search a given key in BST
    public Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root==null || root.key==key)
            return root;
    
        // Key is greater than root's key
        if (root.key < key)
        return search(root.right, key);
    
        // Key is smaller than root's key
        return search(root.left, key);
    }
}