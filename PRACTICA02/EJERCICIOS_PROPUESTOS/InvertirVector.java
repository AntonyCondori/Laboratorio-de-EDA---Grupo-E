package PRACTICA02.EJERCICIOS_PROPUESTOS;

import java.util.*;

public class InvertirVector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = sc.nextInt();
        int[] A = new int[n];

        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int[] resultado = invertirArray(A);
        System.out.println("Arreglo invertido: " + Arrays.toString(resultado));
    }

    public static int[] invertirArray(int[] A) {
        int[] Asalida = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            Asalida[i] = A[A.length - 1 - i];
        }
        return Asalida;
    }

}
