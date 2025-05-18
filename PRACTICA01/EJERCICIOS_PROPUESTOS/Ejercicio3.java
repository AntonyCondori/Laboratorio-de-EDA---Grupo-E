package PRACTICA01.EJERCICIOS_PROPUESTOS;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese cuántos números desea ordenar: ");
        int n = sc.nextInt();

        int[] arreglo = new int[n];
        System.out.println("Ingrese los números:");

        for (int i = 0; i < n; i++) {
            arreglo[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int actual = arreglo[i];
            int j = i - 1;

            while (j >= 0 && arreglo[j] > actual) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }

            arreglo[j + 1] = actual;

            System.out.print("Paso " + i + ": ");
            for (int k = 0; k <= i; k++) {
                System.out.print(arreglo[k] + " ");
            }
            System.out.println();
        }

        System.out.println("Arreglo final ordenado:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
    }
}
