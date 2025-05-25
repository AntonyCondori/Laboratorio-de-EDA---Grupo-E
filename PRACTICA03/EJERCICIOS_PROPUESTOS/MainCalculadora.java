package PRACTICA03.EJERCICIOS_PROPUESTOS;

import java.util.Scanner;

public class MainCalculadora {
    static <T extends Number> double suma(T v1, T v2) {
        return v1.doubleValue() + v2.doubleValue();
    }
    static <T extends Number> double resta(T v1, T v2) {
        return v1.doubleValue() - v2.doubleValue();
    }
    static <T extends Number> double multiplicacion(T v1, T v2) {
        return v1.doubleValue() * v2.doubleValue();
    }
    static <T extends Number> double division(T v1, T v2) {
        return v1.doubleValue() / v2.doubleValue();
    }
    static <T extends Number> double potencia(T base, T exponente) {
        return Math.pow(base.doubleValue(), exponente.doubleValue());
    }
    static <T extends Number> double raizCuadrada(T valor) {
        return Math.sqrt(valor.doubleValue());
    }
    static <T extends Number> double raizCubica(T valor) {
        return Math.cbrt(valor.doubleValue());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de la calculadora genérica:");
            System.out.println("1. Suma\n2. Resta\n3. Multiplicación\n4. División");
            System.out.println("5. Potencia\n6. Raíz cuadrada\n7. Raíz cúbica\n8. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 7) {
                System.out.print("Tipo de dato (1=Entero, 2=Decimal): ");
                int tipoDato = scanner.nextInt();

                if (opcion <= 5) {
                    Number numero1 = (tipoDato == 1) ? scanner.nextInt() : scanner.nextDouble();
                    Number numero2 = (tipoDato == 1) ? scanner.nextInt() : scanner.nextDouble();
                    double resultado = 0;
                    switch (opcion) {
                        case 1: resultado = suma(numero1, numero2); break;
                        case 2: resultado = resta(numero1, numero2); break;
                        case 3: resultado = multiplicacion(numero1, numero2); break;
                        case 4: resultado = division(numero1, numero2); break;
                        case 5: resultado = potencia(numero1, numero2); break;
                    }
                    System.out.println("Resultado: " + resultado);
                } else {
                    Number numero = (tipoDato == 1) ? scanner.nextInt() : scanner.nextDouble();
                    double resultado = (opcion == 6)
                        ? raizCuadrada(numero)
                        : raizCubica(numero);
                    System.out.println("Resultado: " + resultado);
                }
            }
        } while (opcion != 8);

        scanner.close();
        System.out.println("¡Hasta luego!");
    }
}