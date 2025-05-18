package PRACTICA02.EJERCICIOS_PROPUESTOS;
import java.util.*;

public class TrianguloRecursivo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el valor de la base del triángulo: ");
        int base = sc.nextInt();
        trianguloRecursivo1(base);
    }

    public static void trianguloRecursivo1(int base) {
        if (base > 0) {
            trianguloRecursivo1(base - 1);
            for (int i = 0; i < base; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}