package PRACTICA02.EJERCICIOS_PROPUESTOS;
import java.util.*;

public class CuadradoRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del cuadrado: ");
        int base = sc.nextInt();
        cuadradoRecursivo(base, 0);
    }

    public static void cuadradoRecursivo(int base, int fila) {
        if (fila < base) {
            if (fila == 0 || fila == base - 1) {
                for (int i = 0; i < base; i++) {
                    System.out.print("*");
                }
            } else {
                System.out.print("*");
                for (int i = 0; i < base - 2; i++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
            cuadradoRecursivo(base, fila + 1);
        }
    }

}