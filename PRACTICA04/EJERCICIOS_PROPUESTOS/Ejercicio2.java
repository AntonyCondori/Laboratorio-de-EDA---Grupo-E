package PRACTICA04.EJERCICIOS_PROPUESTOS;

public class Ejercicio2<E> {
    NodoCircular<E> cabeza = null;
    NodoCircular<E> cola = null;

    public void insertar(E valor) {
        NodoCircular<E> nuevoNodo = new NodoCircular<>(valor);
        if (cabeza == null) {
            cabeza = cola = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
            cola.siguiente = cabeza;
        }
    }

    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoCircular<E> actual = cabeza;
        System.out.print("Lista circular: ");
        do {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println();
    }

    public static void main(String[] args) {
        Ejercicio2<Integer> lista = new Ejercicio2<>();
        for (int i = 1; i <= 12; i++) {
            lista.insertar(i);
        }
        lista.mostrarLista();
    }
}

class NodoCircular<E> {
    E valor;
    NodoCircular<E> siguiente;

    public NodoCircular(E valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}
