package PRACTICA08.EJERCICIOS_PROPUESTOS;
/**
 * Árbol B genérico usando BNode dinámico.
 */
public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int order;

    public BTree(int order) {
        this.order = order;
        this.root = new BNode<>(order, true);
    }

    public boolean isEmpty() {
        return root.keys.isEmpty();
    }

    /** Inserta una clave en el árbol */
    public void insert(E key) {
        if (root.keys.size() == order - 1) {
            // raíz llena: crear nueva raíz y dividir
            BNode<E> s = new BNode<>(order, false);
            s.children.add(root);
            s.splitChild(0);
            int i = key.compareTo(s.keys.get(0)) > 0 ? 1 : 0;
            s.children.get(i).insertNonFull(key);
            root = s;
        } else {
            root.insertNonFull(key);
        }
    }

    /** Busca una clave */
    public boolean search(E key) {
        return root.search(key);
    }

    /** Retorna mínimo y máximo */
    public E min() { return root.min(); }
    public E max() { return root.max(); }

    @Override
    public String toString() {
        return isEmpty() ? "BTree vacío" : root.toString();
    }

}
