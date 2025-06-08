package PRACTICA05.EJERCICIOS_PROPUESTOS;

public class Nodo<E> {
    E dato;
    Nodo<E> siguiente;

    public Nodo(E dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
