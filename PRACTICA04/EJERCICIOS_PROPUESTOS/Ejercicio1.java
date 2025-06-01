package PRACTICA04.EJERCICIOS_PROPUESTOS;

public class Ejercicio1<E> {
    Nodo<E> inicio, fin;

    public void insertarAlFinal(E valor) {
        Nodo<E> nuevoNodo = new Nodo<>(valor);
        if (inicio == null) {
            inicio = fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            nuevoNodo.anterior = fin;
            fin = nuevoNodo;
        }
    }

    public void mostrarLista() {
        Nodo<E> actual = inicio;
        System.out.print("Lista doblemente enlazada: ");
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ejercicio1<Integer> lista = new Ejercicio1<>();
        for (int i = 1; i <= 10; i++) {
            lista.insertarAlFinal(i);
        }
        lista.mostrarLista();
    }
}

class Nodo<E> {
    E valor;
    Nodo<E> anterior;
    Nodo<E> siguiente;

    public Nodo(E valor) {
        this.valor = valor;
        this.anterior = null;
        this.siguiente = null;
    }
}
