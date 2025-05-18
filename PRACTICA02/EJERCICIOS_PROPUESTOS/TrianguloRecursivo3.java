package PRACTICA02.EJERCICIOS_PROPUESTOS;
import java.util.*;

public class TrianguloRecursivo3 {

    public static void trianguloRecursivo3(int base, int current) {
        if (current <= base) {
            for (int i = 0; i < base - current; i++) {
                System.out.print(" ");
            }
            for (int j = 0; j < current; j++) {
                System.out.print("*");
            }
            System.out.println();
            trianguloRecursivo3(base, current + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el valor de la base del triángulo: ");
        int base = sc.nextInt();
        trianguloRecursivo3(base, 1);
    }
}