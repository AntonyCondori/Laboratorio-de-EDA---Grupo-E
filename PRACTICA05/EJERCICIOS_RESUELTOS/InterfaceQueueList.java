package PRACTICA05.EJERCICIOS_RESUELTOS;

public interface InterfaceQueueList<E> {
    boolean isEmpty();

    void enqueue(E elemento);

    E dequeue();

    E front();
}