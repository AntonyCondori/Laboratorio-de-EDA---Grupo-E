package PRACTICA05.EJERCICIOS_RESUELTOS;

public class QueueList<E> implements InterfaceQueueList<E> {
    private Node<E> frente;
    private Node<E> fin;

    public QueueList() {
        frente = fin = null;
    }

    @Override
    public boolean isEmpty() {
        return frente == null;
    }

    @Override
    public void enqueue(E elemento) {
        Node<E> nuevoNodo = new Node<>(elemento);
        if (isEmpty()) {
            frente = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
        }
        fin = nuevoNodo;
        System.out.println("Encolado: " + elemento);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: la cola está vacía");
        }
        E elementoFrente = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return elementoFrente;
    }

    @Override
    public E front() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }
        return frente.getDato();
    }

    public static void main(String[] args) {
        InterfaceQueueList<Integer> cola = new QueueList<>();

        for (int i = 1; i <= 8; i++) {
            cola.enqueue(i);
        }

        System.out.println("Frente actual: " + cola.front());

        System.out.print("Contenido de la cola al desencolar: ");
        while (!cola.isEmpty()) {
            System.out.print(cola.dequeue() + " ");
        }
        System.out.println();
    }
}