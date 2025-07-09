package PRACTICA08.EJERCICIOS_PROPUESTOS;
import java.util.*;

/**
 * Nodo de B-Tree genérico con listas dinámicas evitando huecos null.
 * @param <E> tipo clave comparable
 */
public class BNode<E extends Comparable<E>> {
    int order;                   // orden máximo (máximo de hijos)
    List<E> keys;                // claves del nodo
    List<BNode<E>> children;     // apuntadores a hijos
    boolean leaf;                // indicador de hoja

    public BNode(int order, boolean leaf) {
        this.order = order;
        this.leaf = leaf;
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    /** Busca recursivamente una clave */
    public boolean search(E key) {
        int i = 0;
        while (i < keys.size() && key.compareTo(keys.get(i)) > 0) i++;
        if (i < keys.size() && key.compareTo(keys.get(i)) == 0) return true;
        if (leaf) return false;
        return children.get(i).search(key);
    }

    /** Retorna la clave mínima en este subárbol */
    public E min() {
        return leaf ? keys.get(0) : children.get(0).min();
    }

    /** Retorna la clave máxima en este subárbol */
    public E max() {
        return leaf ? keys.get(keys.size() - 1) : children.get(children.size() - 1).max();
    }

    /** Inserta en nodo no lleno siguiendo CLRS */
    public void insertNonFull(E key) {
        int i = keys.size() - 1;
        if (leaf) {
            // inserción ordenada en la lista de claves
            while (i >= 0 && key.compareTo(keys.get(i)) < 0) i--;
            keys.add(i + 1, key);
        } else {
            // encuentra hijo a descender
            while (i >= 0 && key.compareTo(keys.get(i)) < 0) i--;
            i++;
            BNode<E> child = children.get(i);
            // si el hijo está lleno, dividirlo
            if (child.keys.size() == order - 1) {
                splitChild(i);
                if (key.compareTo(keys.get(i)) > 0) i++;
            }
            children.get(i).insertNonFull(key);
        }
    }

    /** Divide el hijo en índice idx */
    public void splitChild(int idx) {
        BNode<E> y = children.get(idx);
        // nuevo nodo que copia la mitad derecha de y
        BNode<E> z = new BNode<>(order, y.leaf);
        int t = (order + 1) / 2;
        // mover claves de y a z
        for (int j = 0; j < t - 1; j++) {
            z.keys.add(y.keys.remove(t));
        }
        // si no es hoja, mover también hijos
        if (!y.leaf) {
            for (int j = 0; j < t; j++) {
                z.children.add(y.children.remove(t));
            }
        }
        // insertar nuevo hijo en lista de hijos
        children.add(idx + 1, z);
        // subir la clave media
        E middle = y.keys.remove(t - 1);
        keys.add(idx, middle);
    }

    /** Representación en preorden del subárbol */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < keys.size(); i++) {
            if (!leaf) sb.append(children.get(i).toString()).append(",");
            sb.append(keys.get(i));
            if (i < keys.size() - 1) sb.append(",");
        }
        if (!leaf) sb.append(",").append(children.get(children.size() - 1).toString());
        sb.append("]");
        return sb.toString();
    }
}