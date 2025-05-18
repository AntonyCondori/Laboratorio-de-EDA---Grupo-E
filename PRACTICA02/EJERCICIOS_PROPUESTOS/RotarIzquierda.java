package PRACTICA02.EJERCICIOS_PROPUESTOS;
import java.util.*;

public class RotarIzquierda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = sc.nextInt();
        int[] A = new int[n];

        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.print("Ingrese el número de posiciones a rotar a la izquierda: ");
        int d = sc.nextInt();

        int[] resultado = rotarIzquierdaArray(A, d);
        System.out.println("Arreglo rotado: " + Arrays.toString(resultado));
    }

    public static int[] rotarIzquierdaArray(int[] A, int d) {
        int[] Ainvertido = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            Ainvertido[i] = A[(i + d) % A.length];
        }
        return Ainvertido;
    }

}
