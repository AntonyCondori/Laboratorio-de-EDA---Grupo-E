package PRACTICA03.EJERCICIOS_PROPUESTOS;

public class Lista<T> {
    private Node<T> raiz; 

    public Lista() {
        raiz = null;
    }

    public boolean estaVacia() {
        return raiz == null;
    }

    public int tamaño() {
        int contador = 0;
        Node<T> actual = raiz;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    public void agregar(T elemento) {
        if (estaVacia()) {
            raiz = new Node<>(elemento);
        } else {
            Node<T> actual = raiz;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(new Node<>(elemento));
        }
    }

    public T obtener(int indice) {
        if (indice < 0) throw new IndexOutOfBoundsException();
        int i = 0;
        Node<T> actual = raiz;
        while (actual != null) {
            if (i++ == indice) return actual.getDato();
            actual = actual.getSiguiente();
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean contiene(T elemento) {
        Node<T> actual = raiz;
        while (actual != null) {
            if (actual.getDato().equals(elemento)) return true;
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void limpiar() {
        raiz = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> actual = raiz;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) sb.append(", ");
            actual = actual.getSiguiente();
        }
        sb.append("]");
        return sb.toString();
    }
}