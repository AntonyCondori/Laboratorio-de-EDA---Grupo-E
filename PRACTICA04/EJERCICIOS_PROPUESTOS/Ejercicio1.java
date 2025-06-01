package PRACTICA04.EJERCICIOS_PROPUESTOS;

public class Ejercicio1 {
    Nodo inicio, fin;

    // Inserta un nuevo nodo al final de la lista
    public void insertarAlFinal(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (inicio == null) {
            inicio = fin = nuevoNodo;
        } else {
            fin.nodoSiguiente = nuevoNodo;
            nuevoNodo.nodoAnterior = fin;
            fin = nuevoNodo;
        }
    }

    // Muestra la lista desde el inicio hasta el final
    public void mostrarLista() {
        Nodo actual = inicio;
        System.out.print("Lista doblemente enlazada: ");
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.nodoSiguiente;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ejercicio1 lista = new Ejercicio1();

        for (int i = 1; i <= 10; i++) {
            lista.insertarAlFinal(i);
        }

        lista.mostrarLista();
    }
}

class Nodo {
    int valor;
    Nodo nodoAnterior;
    Nodo nodoSiguiente;

    public Nodo(int valor) {
        this.valor = valor;
        this.nodoAnterior = null;
        this.nodoSiguiente = null;
    }
}
