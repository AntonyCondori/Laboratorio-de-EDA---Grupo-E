package PRACTICA05.EJERCICIOS_RESUELTOS;

public class Node<E> {
    private E dato;
    private Node<E> siguiente;

    public Node(E dato) {
        this(dato, null);
    }

    public Node(E dato, Node<E> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public E getDato() {
        return dato;
    }

    public Node<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Node<E> siguiente) {
        this.siguiente = siguiente;
    }
}