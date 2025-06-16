package PRACTICA06.EJERCICIOS_PROPUESTOS;

import java.util.Scanner;

public class BSTMain2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una palabra: ");
        String palabra = sc.nextLine();

        BST<Integer> bst = new BST<>();

        // Insertar el código ASCII de cada carácter
        for (char c : palabra.toCharArray()) {
            bst.insert((int) c);
        }

        // Mostrar recorridos basados en esos valores
        System.out.println("\nInOrder  (ASCII ordenados): " + bst.inOrder());
        System.out.println("PreOrder (estructura):     " + bst.preOrder());
        System.out.println("PostOrder(structura):     " + bst.postOrder());

        // Dibujar el árbol con valores ASCII
        System.out.println("\nÁrbol (valores ASCII):");
        bst.printTree();

        sc.close();
    }
}