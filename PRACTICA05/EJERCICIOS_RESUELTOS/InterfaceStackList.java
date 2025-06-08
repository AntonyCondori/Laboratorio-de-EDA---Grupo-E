package PRACTICA05.EJERCICIOS_RESUELTOS;

public interface InterfaceStackList<E> {
    boolean isEmpty();

    void push(E elemento);

    E pop();

    E peek();
}