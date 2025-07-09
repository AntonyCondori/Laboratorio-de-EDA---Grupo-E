package PRACTICA08.EJERCICIOS_PROPUESTOS;
import java.util.Scanner;

public class TestBTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese orden del B-Tree: ");
        int m = sc.nextInt();
        BTree<Integer> tree = new BTree<>(m);
        int opcion;
        do {
            System.out.println("\n--- Menú B-Tree ---");
            System.out.println("1. Insertar clave");
            System.out.println("2. Eliminar clave");
            System.out.println("3. Buscar clave");
            System.out.println("4. Mínimo");
            System.out.println("5. Máximo");
            System.out.println("6. Mostrar árbol");
            System.out.println("0. Salir");
            System.out.print("Opción: "); opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.print("Clave a insertar: ");
                    tree.insert(sc.nextInt());
                }
                case 2 -> System.out.println("-- Operación remove aún no implementada --");
                case 3 -> {
                    System.out.print("Clave a buscar: ");
                    System.out.println(tree.search(sc.nextInt()) ? "Encontrada" : "No encontrada");
                }
                case 4 -> System.out.println("Mínimo: " + tree.min());
                case 5 -> System.out.println("Máximo: " + tree.max());
                case 6 -> System.out.println(tree);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
        sc.close();
    }
}
