package PRACTICA01.EJERCICIOS_PROPUESTOS;
import java.util.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número inicial del rango: ");
        int inicio = sc.nextInt();
        System.out.print("Ingrese el número final del rango: ");
        int fin = sc.nextInt();

        boolean[] esPrimo = new boolean[fin + 1];
        Arrays.fill(esPrimo, true);
        esPrimo[0] = esPrimo[1] = false;

        for (int i = 2; i * i <= fin; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= fin; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        System.out.println("Números primos en el rango:");
        for (int i = Math.max(inicio, 2); i <= fin; i++) {
            if (esPrimo[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
