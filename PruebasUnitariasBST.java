/**
 * @author unclepete-20
 * Carnet 20188
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 * Hoja de trabajo 7
 */

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class PruebasUnitariasBST {

    BST arbol = new BST();
    BST asociacion = new BST();


    @Test
    public void pruebaBSTInsert(){

        String[] prueba = {"Hola", "Como estas", "Yeah"};
        Association<Integer, String[]> asso = new Association<Integer,String[]>(1, prueba);

        arbol.insert(1, asso);

        Node insertado = arbol.search(arbol.getRoot(), 1);

        Node root = arbol.getRoot();

        assertEquals(root, insertado);

    }

    @Test
    public void pruebaBSTSearch(){
        
        String[] prueba = {"Hola", "Como estas", "Yeah"};
        String[] prueba2 = {"Hola", "Como estas", "Yeah"};

        Association<Integer, String[]> asso = new Association<Integer,String[]>(1, prueba);
        Association<Integer, String[]> asso2 = new Association<Integer,String[]>(1, prueba2);

        arbol.insert(1, asso);
        arbol.insert(2, asso2);

        Node insertado = arbol.search(arbol.getRoot(), 2);

        String[] resultado = insertado.getKey();
        

        assertEquals(prueba2, resultado);
    }
}

