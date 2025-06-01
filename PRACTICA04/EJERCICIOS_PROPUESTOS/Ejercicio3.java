package PRACTICA04.EJERCICIOS_PROPUESTOS;
import java.util.LinkedList;

public class Ejercicio3 {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();

        for (int i = 1; i <= 10; i++) {
            lista.add(i);
        }

        System.out.print("Lista doblemente enlazada con java.util: ");
        for (Integer numero : lista) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}