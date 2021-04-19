/**
 * @author unclepete-20
 * Carnet 20188
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 * Hoja de trabajo 7
 */


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        //Instancias necesarias para llevar a cabo el traductor de palabras implementado el Binary Search Tree.
        Scanner scanner = new Scanner(System.in);
        BST tree = new BST();
        String[] sentence = {};
        int wordsize = 0;

        //Se leen los documentos que contienen las palabras en diferentes idiomas y la oracion a traducir.
       wordsize = Reader.dataToTree(wordsize, tree);
       sentence = Reader.sentenceReader(sentence);

        System.out.println("\n================================== PEDRO'S TRANSLATOR ==================================\n");
        	
		boolean cycle1 = false;
        
        while(cycle1 == false){//ciclo general.

            int LN = 0;
     
            boolean cycle2 = false;
            
            while(cycle2 == false){ //Ciclo interno.
                
                System.out.println("Escoga el idioma al que quiere traducir la oracion que ingreso: ");
                System.out.println("1) Ingles");
                System.out.println("2) Español");
                System.out.println("3) Francés");
                System.out.println("4) Cerrar sesion\n");

                try {
                    
                    //Se selecciona una opcion en base al idioma que el usuario desee para traducir su oracion.
                    int opcion = scanner.nextInt();

                    if(opcion == 1){ //Se selecciona el idioma ingles.
                        LN = 0;
                        cycle2 = true;
                    }
                    else if(opcion == 2){ //Se selecciona el idioma español.
                        LN = 1;
                        cycle2 = true;
                    }
                    else if(opcion == 3){ //Se selecciona el idioma frances.
                        LN = 2;
                        cycle2 = true;
                    }
                    else if(opcion == 4){ //Se cierra el programa.
                        System.out.println("Sesion finalizada");
                        cycle2 = true;
                        cycle1 = true;
                        
                    }
                    else{
                        System.out.println("\nLa opcion seleccionada no esta disponible.\n");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("\nOpcion Incorrecta, ingrese un valor valido\n");
                    scanner.nextLine();
                }
            }

            
            
            //Iteracion para obtener las asociaciones de las palabras en otros idiomas.
            for(int i = 0; i < sentence.length; i++){

                String word = sentence[i];
                int cw = 0;
    
                for(int j = 1; j <= wordsize; j++) {
                    
                    Node node = tree.search(tree.getRoot(), j);
                    String[] key = node.getKey(); //Se obtienen los valores, en otras palabras, la lista de palabras.

                    for(int l = 0; l < key.length; l++){
    
                        String s2 = key[l];
                        if(s2.equalsIgnoreCase(word)){
                            sentence[l] = key[LN];
                        }
                        else{
                            cw++;
                        }
                    }
                }

                int lss = wordsize * 3;

                if(cw == lss){

                    String translatedWord = ""; //Se almacenan las palabras traducidas.

                    if(word.charAt(0) != '*' && word.charAt(word.length() - 1) != '*'){

                        for(int j = -1; j < (word.length() + 1); j++){
                            if(j == -1 || j == word.length()){
                                translatedWord += "*"; //Se agrega un astericos si la palabra a traducir no esta en las asociaciones.

                            } else{
                                translatedWord += word.charAt(j);
                            }
                        }

                        sentence[i] = translatedWord;  
                    }
                }
            }

            String translatedSentence = ""; //Se juntan todas las palabras para formar la nueva oracion traducida.

            for(int i = 0; i < sentence.length; i++){

                translatedSentence += sentence[i];
                translatedSentence += " ";
            }

            System.out.println("");
            System.out.println(translatedSentence); //Se imprime la traduccion de la oracion.
        }

        //Se imprime el resultado de aplicar el algoritmo de In-order traversal.
        System.out.println("\n================================== In-order traversal algorithm demonstration ==================================\n");
        tree.inorder();
        
    }
}