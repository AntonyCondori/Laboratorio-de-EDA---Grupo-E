package PRACTICA05.EJERCICIOS_PROPUESTOS;

public class PilaNodoOperaciones<E> implements IPilaOperaciones<E> {
    private Nodo<E> cima;
    private int numElementos;

    public PilaNodoOperaciones() {
        cima = null;
        numElementos = 0;
    }

    @Override
    public void apilar(E elemento) {
        Nodo<E> nuevo = new Nodo<>(elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
        numElementos++;
    }

    @Override
    public E desapilar() {
        if (estaVacia()) {
            throw new RuntimeException("Pila vacía");
        }
        E aux = cima.dato;
        cima = cima.siguiente;
        numElementos--;
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

    @Override
    public void destruirPila() {
        cima = null;
        numElementos = 0;
    }

    @Override
    public boolean estaLlena() {
        return false;
    }

    @Override
    public void imprimirPila() {
        System.out.println("Contenido de la pila:");
        Nodo<E> recorrido = cima;
        while (recorrido != null) {
            System.out.println(recorrido.dato);
            recorrido = recorrido.siguiente;
        }
    }
}