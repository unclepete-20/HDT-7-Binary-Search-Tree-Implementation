/**
 * @author unclepete-20
 * Carnet 20188
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 * Hoja de trabajo 7
 * Codigo extraido de https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 */

public class Node {
    
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
