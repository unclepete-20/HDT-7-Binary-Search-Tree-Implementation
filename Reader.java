/**
 * @author unclepete-20
 * Carnet 20188
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 * Hoja de trabajo 7
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Reader {

    Scanner scanner = new Scanner(System.in);

    
    /** 
     * @param size
     * @param tree
     * Pre: Ingresa la informacion deseada al Binary Search Tree.
     * Post: La informacion ya esta almacenada en el arbol por medio de nodos.
     */
    public static int dataToTree(int size, BST tree){ //Ingresa la informacion deseada al Binary Search Tree.
        try {
            File file = new File("diccionario.txt");
            Scanner reader = new Scanner(file);
            int c = 0;
            while (reader.hasNextLine()) {
                c++;
                String dictionary = reader.nextLine();
                String[]  words = dictionary.split(","); 
                Association<Integer, String[]> translate = new Association<Integer,String[]>(c, words);
                tree.insert(c, translate);
            }
            size = c;
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }

        return size;
    }

    
    /** 
     * @param sentence
     * @return String[]
     * Pre: Lee la oracion desde el archivo de texto.
     * Post: Almacena cada palabra de la oracion en un array. 
     */
    public static String[] sentenceReader(String[] sentence){
        try {
            File file = new File("texto.txt");
            Scanner reader = new Scanner(file);
            String expression = reader.nextLine();
            expression = expression.replace(".", "");
            sentence = expression.split(" ");
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }

        return sentence;
    }
}
