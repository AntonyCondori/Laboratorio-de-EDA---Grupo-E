package PRACTICA07.EJERCICIOS_PROPUESTOS;

public class AVLTree<T extends Comparable<T>> {
    private NodeAVL<T> root;

    // 1. destroy y consulta vaciado
    public void destroy() { root = null; }
    public boolean isEmpty() { return root == null; }

    // 2. inserción y eliminación pública
    public void insert(T x) { root = insert(root, x); }
    public void remove(T x) { root = remove(root, x); }

    // 3. búsqueda
    public boolean search(T x) { return search(root, x) != null; }

    // 4. extremos y sucesores/predecesores
    public T Min() { 
        NodeAVL<T> n = minNode(root);
        return n != null ? n.data : null;
    }
    public T Max() { 
        NodeAVL<T> n = maxNode(root);
        return n != null ? n.data : null;
    }
    public T predecessor(T x) { /* TODO */ return null; }
    public T successor(T x)   { /* TODO */ return null; }

    // 5. recorridos
    public void inOrder()    { inOrder(root);    System.out.println(); }
    public void preOrder()   { preOrder(root);   System.out.println(); }
    public void postOrder()  { postOrder(root);  System.out.println(); }

    // ——— Implementaciones internas ———

    private NodeAVL<T> insert(NodeAVL<T> node, T x) {
        if (node == null) return new NodeAVL<>(x);
        int cmp = x.compareTo(node.data);
        if      (cmp < 0) node.left  = insert(node.left,  x);
        else if (cmp > 0) node.right = insert(node.right, x);
        else              return node; // duplicado
        return rebalance(node);
    }

    private NodeAVL<T> remove(NodeAVL<T> node, T x) {
        if (node == null) return null;
        int cmp = x.compareTo(node.data);
        if      (cmp < 0) node.left  = remove(node.left,  x);
        else if (cmp > 0) node.right = remove(node.right, x);
        else {
            if (node.left == null)  return node.right;
            if (node.right == null) return node.left;
            NodeAVL<T> m = minNode(node.right);
            node.data = m.data;
            node.right = remove(node.right, m.data);
        }
        return rebalance(node);
    }

    private NodeAVL<T> search(NodeAVL<T> node, T x) {
        if (node == null) return null;
        int cmp = x.compareTo(node.data);
        if      (cmp < 0) return search(node.left,  x);
        else if (cmp > 0) return search(node.right, x);
        else              return node;
    }

    private NodeAVL<T> minNode(NodeAVL<T> node) {
        return (node == null || node.left == null) ? node : minNode(node.left);
    }
    private NodeAVL<T> maxNode(NodeAVL<T> node) {
        return (node == null || node.right == null) ? node : maxNode(node.right);
    }

    private void inOrder(NodeAVL<T> n)   { if (n != null) { inOrder(n.left);  System.out.print(n.data+" "); inOrder(n.right); } }
    private void preOrder(NodeAVL<T> n)  { if (n != null) { System.out.print(n.data+" "); preOrder(n.left);  preOrder(n.right); } }
    private void postOrder(NodeAVL<T> n) { if (n != null) { postOrder(n.left); postOrder(n.right); System.out.print(n.data+" "); } }

    // ——— Altura, factor de equilibrio y rotaciones ———
    private int height(NodeAVL<T> n) { return n == null ? 0 : n.height; }
    private int bf(NodeAVL<T> n)     { return height(n.left) - height(n.right); }

    private NodeAVL<T> rotateRight(NodeAVL<T> y) {
        NodeAVL<T> x = y.left;
        y.left = x.right;
        x.right = y;
        // actualizar alturas
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return x;
    }

    private NodeAVL<T> rotateLeft(NodeAVL<T> x) {
        NodeAVL<T> y = x.right;
        x.right = y.left;
        y.left = x;
        // actualizar alturas
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    private NodeAVL<T> rebalance(NodeAVL<T> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = bf(node);
        if (balance > 1) {
            if (bf(node.left) < 0) node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1) {
            if (bf(node.right) > 0) node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }
}