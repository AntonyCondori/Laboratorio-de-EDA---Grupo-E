package PRACTICA04.EJERCICIOS_PROPUESTOS;
import java.util.LinkedList;

public class Ejercicio4 {
    public static void main(String[] args) {
        LinkedList<Integer> listaCircular = new LinkedList<>();

        for (int i = 1; i <= 12; i++) {
            listaCircular.add(i);
        }

        System.out.print("Lista circular (simulada): ");
        for (int i = 0; i < listaCircular.size() * 2; i++) {
            int valor = listaCircular.get(i % listaCircular.size());
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}