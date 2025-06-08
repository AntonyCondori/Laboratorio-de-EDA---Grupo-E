package PRACTICA05.EJERCICIOS_PROPUESTOS;

public class ColaNodoOperaciones<E> implements ColaOperaciones<E> {
    private Nodo<E> frente;
    private Nodo<E> fin;
    private int numElementos;

    public ColaNodoOperaciones() {
        frente = fin = null;
        numElementos = 0;
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
        numElementos++;
    }

    @Override
    public E desencolar() {
        if (estaVacia()) {
            throw new RuntimeException("Cola vacía");
        }
        E aux = frente.dato;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        numElementos--;
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

    @Override
    public void destruirCola() {
        frente = fin = null;
        numElementos = 0;
    }

    @Override
    public boolean estaLlena() {
        return false; 
    }

    @Override
    public E fin() {
        if (estaVacia()) {
            throw new RuntimeException("Cola vacía");
        }
        return fin.dato;
    }

    @Override
    public void imprimirCola() {
        System.out.println("Contenido de la cola:");
        Nodo<E> recorrido = frente;
        while (recorrido != null) {
            System.out.println(recorrido.dato);
            recorrido = recorrido.siguiente;
        }
    }
}