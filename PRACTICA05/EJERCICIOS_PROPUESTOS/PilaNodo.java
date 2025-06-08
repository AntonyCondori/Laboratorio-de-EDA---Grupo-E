package PRACTICA05.EJERCICIOS_PROPUESTOS;

public class PilaNodo<E> implements Pila<E> {
    private Nodo<E> cima;
    private int tamaño;

    public PilaNodo() {
        cima = null;
        tamaño = 0;
    }

    @Override
    public void apilar(E elemento) {
        Nodo<E> nuevo = new Nodo<>(elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamaño++;
    }

    @Override
    public E desapilar() {
        if (estaVacia()) {
            throw new RuntimeException("Pila vacía");
        }
        E aux = cima.dato;
        cima = cima.siguiente;
        tamaño--;
        return aux;
    }

    @Override
    public E cima() {
        if (estaVacia()) {
            throw new RuntimeException("Pila vacía");
        }
        return cima.dato;
    }

    @Override
    public boolean estaVacia() {
        return cima == null;
    }
}