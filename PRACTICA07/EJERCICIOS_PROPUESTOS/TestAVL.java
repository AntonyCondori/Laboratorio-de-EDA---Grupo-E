package PRACTICA07.EJERCICIOS_PROPUESTOS;

import java.util.Scanner;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println(
                "\nMenú AVL:\n" +
                "1.Insert    2.Remove    3.Search    4.Min    5.Max\n" +
                "6.InOrder   7.PreOrder   8.PostOrder   9.Graficar\n" +
                "10.Destroy  0.Salir\n" +
                "Elige → "
            );
            op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.print("Valor a insertar: ");
                    tree.insert(sc.nextInt());
                }
                case 2 -> {
                    System.out.print("Valor a eliminar: ");
                    tree.remove(sc.nextInt());
                }
                case 3 -> {
                    System.out.print("Valor a buscar: ");
                    System.out.println(tree.search(sc.nextInt()) ? "Encontrado" : "No existe");
                }
                case 4 -> System.out.println("Min = " + tree.Min());
                case 5 -> System.out.println("Max = " + tree.Max());
                case 6 -> tree.inOrder();
                case 7 -> tree.preOrder();
                case 8 -> tree.postOrder();
                case 9 -> tree.displayWithGraphStream();
                case 10 -> tree.destroy();
                case 0 -> { /* salir */ }
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
        sc.close();
    }
}