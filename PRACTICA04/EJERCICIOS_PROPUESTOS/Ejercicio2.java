package PRACTICA04.EJERCICIOS_PROPUESTOS;

public class Ejercicio2 {
    Nodo cabeza = null;
    Nodo cola = null;

    public void insertar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
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

        Nodo actual = cabeza;
        System.out.print("Lista circular: ");
        do {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println();
    }

    public static void main(String[] args) {
        Ejercicio2 lista = new Ejercicio2();

        for (int i = 1; i <= 12; i++) {
            lista.insertar(i);
        }

        lista.mostrarLista();
    }
}

class Nodo {
    int valor;
    Nodo siguiente;

    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}
