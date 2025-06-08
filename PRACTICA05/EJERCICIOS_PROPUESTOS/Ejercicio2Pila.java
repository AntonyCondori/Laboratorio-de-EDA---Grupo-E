package PRACTICA05.EJERCICIOS_PROPUESTOS;
import java.util.*;

public class Ejercicio2Pila {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilaNodoOperaciones<Integer> pila = new PilaNodoOperaciones<>();
        int opcion;

        do {
            System.out.println("\n--- Menú Pila ---");
            System.out.println("1. Apilar");
            System.out.println("2. Desapilar");
            System.out.println("3. Ver cima");
            System.out.println("4. Vacía?");
            System.out.println("5. Llena?");
            System.out.println("6. Imprimir pila");
            System.out.println("7. Destruir pila");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Valor a apilar: ");
                    int valor = sc.nextInt();
                    pila.apilar(valor);
                    break;
                case 2:
                    try {
                        System.out.println("Desapilado: " + pila.desapilar());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Cima: " + pila.cima());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("¿Está vacía? " + pila.estaVacia());
                    break;
                case 5:
                    System.out.println("¿Está llena? " + pila.estaLlena());
                    break;
                case 6:
                    pila.imprimirPila();
                    break;
                case 7:
                    pila.destruirPila();
                    System.out.println("Pila destruida.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
