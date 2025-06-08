package PRACTICA05.EJERCICIOS_PROPUESTOS;

public interface Pila<E> {
    void apilar(E elemento);
    E desapilar();
    E cima();
    boolean estaVacia();
}