package PRACTICA05.EJERCICIOS_PROPUESTOS;

public interface IPilaOperaciones<E> extends Pila<E> {
    void destruirPila();
    boolean estaLlena();
    void imprimirPila();
}