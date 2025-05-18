package PRACTICA01.EJERCICIOS_PROPUESTOS;

import java.util.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de estudiantes: ");
        int n = sc.nextInt();

        double[] notas = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese la nota del estudiante " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
        }

        Arrays.sort(notas);

        System.out.println("\n--- Resultados ---");
        System.out.println("Mediana: " + calcularMediana(notas));
        System.out.println("Moda: " + calcularModa(notas));
        System.out.println("Desviación estándar: " + calcularDesviacion(notas));
    }

    public static double calcularMediana(double[] datos) {
        int n = datos.length;
        if (n % 2 == 0) {
            return (datos[n/2 - 1] + datos[n/2]) / 2.0;
        } else {
            return datos[n/2];
        }
    }

    public static double calcularModa(double[] datos) {
        Map<Double, Integer> frecuencias = new HashMap<>();
        for (double nota : datos) {
            frecuencias.put(nota, frecuencias.getOrDefault(nota, 0) + 1);
        }

        double moda = datos[0];
        int max = 0;

        for (double nota : frecuencias.keySet()) {
            if (frecuencias.get(nota) > max) {
                max = frecuencias.get(nota);
                moda = nota;
            }
        }

        return moda;
    }

    public static double calcularDesviacion(double[] datos) {
        double suma = 0;
        for (double nota : datos) {
            suma += nota;
        }

        double promedio = suma / datos.length;
        double sumaCuadrados = 0;

        for (double nota : datos) {
            sumaCuadrados += Math.pow(nota - promedio, 2);
        }

        return Math.sqrt(sumaCuadrados / datos.length);
    }
}
