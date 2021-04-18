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

    BST<Integer> arbol = new BST<Integer>();
    BST<Integer> asociacion = new BST<Integer>();


    @Test
    public void pruebaBSTAdd(){

        int valor = 1;
        int valorDos = 4;
        int valorTres = 10;

        try {
            arbol.add(valor);
        } catch (Exception e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        try {
            arbol.add(valorDos);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            arbol.add(valorTres);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        assertEquals(false, arbol.isEmpty());

    }

    @Test
    public void pruebaBSTSearch(){
        
        int valor = 1;
        int valorDos = 4;
        int valorTres = 10;

        try {
            arbol.add(valor);
        } catch (Exception e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        try {
            arbol.add(valorDos);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            arbol.add(valorTres);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int busqueda = arbol.get(valorDos);

        assertEquals(valorDos, busqueda);
    }
}

