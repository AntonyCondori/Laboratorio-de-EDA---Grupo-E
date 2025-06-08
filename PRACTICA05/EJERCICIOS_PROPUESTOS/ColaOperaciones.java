package PRACTICA05.EJERCICIOS_PROPUESTOS;

public interface ColaOperaciones<E> extends Cola<E> {
    void destruirCola();
    boolean estaLlena();
    E fin();
    void imprimirCola();
}