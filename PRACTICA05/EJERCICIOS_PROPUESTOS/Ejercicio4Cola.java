package PRACTICA05.EJERCICIOS_PROPUESTOS;
import java.util.*;

public class Ejercicio4Cola {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ColaNodoOperaciones<Integer> cola = new ColaNodoOperaciones<>();
        int opcion;

        do {
            System.out.println("\n--- Menú Cola ---");
            System.out.println("1. Encolar");
            System.out.println("2. Desencolar");
            System.out.println("3. Ver frente");
            System.out.println("4. Vacía?");
            System.out.println("5. Llena?");
            System.out.println("6. Ver fin");
            System.out.println("7. Imprimir cola");
            System.out.println("8. Destruir cola");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Valor a encolar: ");
                    int valor = sc.nextInt();
                    cola.encolar(valor);
                    break;
                case 2:
                    try {
                        System.out.println("Desencolado: " + cola.desencolar());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Frente: " + cola.frente());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("¿Está vacía? " + cola.estaVacia());
                    break;
                case 5:
                    System.out.println("¿Está llena? " + cola.estaLlena());
                    break;
                case 6:
                    try {
                        System.out.println("Fin: " + cola.fin());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    cola.imprimirCola();
                    break;
                case 8:
                    cola.destruirCola();
                    System.out.println("Cola destruida.");
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