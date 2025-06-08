package PRACTICA05.EJERCICIOS_RESUELTOS;

public class StackList<E> implements InterfaceStackList<E> {
    private Node<E> tope;

    public StackList() {
        tope = null;
    }

    @Override
    public boolean isEmpty() {
        return tope == null;
    }

    @Override
    public void push(E elemento) {
        Node<E> nuevoNodo = new Node<>(elemento, tope);
        tope = nuevoNodo;
        System.out.println("Apilado: " + elemento);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: la pila está vacía");
        }
        E elementoTope = tope.getDato();
        tope = tope.getSiguiente();
        return elementoTope;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return tope.getDato();
    }

    public static void main(String[] args) {
        InterfaceStackList<Integer> pila = new StackList<>();

        for (int i = 1; i <= 8; i++) {
            pila.push(i);
        }

        System.out.println("Cima actual: " + pila.peek());

        System.out.print("Contenido de la pila al desapilar: ");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop() + " ");
        }
        System.out.println();
    }
}