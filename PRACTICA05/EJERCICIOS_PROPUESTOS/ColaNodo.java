package PRACTICA05.EJERCICIOS_PROPUESTOS;

public class ColaNodo<E> implements Cola<E> {
    private Nodo<E> frente;
    private Nodo<E> fin;
    private int tamaño;

    public ColaNodo() {
        frente = fin = null;
        tamaño = 0;
    }

    @Override
    public void encolar(E elemento) {
        Nodo<E> nuevo = new Nodo<>(elemento);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamaño++;
    }

    @Override
    public E desencolar() {
        if (estaVacia()) {
            throw new RuntimeException("Cola vacía");
        }
        E aux = frente.dato;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        tamaño--;
        return aux;
    }

    @Override
    public E frente() {
        if (estaVacia()) {
            throw new RuntimeException("Cola vacía");
        }
        return frente.dato;
    }

    @Override
    public boolean estaVacia() {
        return frente == null;
    }
}