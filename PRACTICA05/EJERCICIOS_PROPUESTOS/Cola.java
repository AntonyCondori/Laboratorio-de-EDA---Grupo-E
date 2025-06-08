package PRACTICA05.EJERCICIOS_PROPUESTOS;

public interface Cola<E> {
    void encolar(E elemento);
    E desencolar();
    E frente();
    boolean estaVacia();
}