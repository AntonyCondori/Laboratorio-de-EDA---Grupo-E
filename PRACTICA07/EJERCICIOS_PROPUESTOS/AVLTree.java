package PRACTICA07.EJERCICIOS_PROPUESTOS;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.HashMap;
import java.util.Map;

public class AVLTree<T extends Comparable<T>> {
    private NodeAVL<T> root;

    // Para el layout manual
    private Map<String, double[]> coords = new HashMap<>();
    private double xCounter;

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
    public void inOrder()   { inOrder(root);    System.out.println(); }
    public void preOrder()  { preOrder(root);   System.out.println(); }
    public void postOrder() { postOrder(root);  System.out.println(); }

    // —— Implementaciones internas ——
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

    // —— Altura, factor de equilibrio y rotaciones ——
    private int height(NodeAVL<T> n) { return n == null ? 0 : n.height; }
    private int bf(NodeAVL<T> n)     { return height(n.left) - height(n.right); }

    private NodeAVL<T> rotateRight(NodeAVL<T> y) {
        NodeAVL<T> x = y.left;
        y.left = x.right;
        x.right = y;
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return x;
    }

    private NodeAVL<T> rotateLeft(NodeAVL<T> x) {
        NodeAVL<T> y = x.right;
        x.right = y.left;
        y.left = x;
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

    // — Ejercicio 3: graficar con GraphStream —
    public void displayWithGraphStream() {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("AVL Tree");
        graph.setAttribute("ui.stylesheet",
            "node {" +
              "shape: circle;" +
              "size: 40px;" +
              "fill-color: white;" +
              "stroke-mode: plain;" +
              "stroke-color: green;" +
              "text-alignment: center;" +
              "text-size: 14;" +
            "}" +
            "edge {" +
              "fill-color: green;" +
              "arrow-shape: arrow;" +
            "}"
        );

        // calcula y asigna coordenadas
        coords.clear();
        xCounter = 0;
        assignCoords(root, 0);

        // construye grafos
        buildGraph(graph, root);

        // posiciona y etiqueta solo con clave
        for (Node n : graph) {
            double[] xy = coords.get(n.getId());
            if (xy != null) {
                n.setAttribute("xyz", xy[0], xy[1], 0);
                n.setAttribute("ui.label", n.getId());
            }
        }

        graph.display();
    }

    // Recorre in-order para asignar X según orden y Y según profundidad
    private void assignCoords(NodeAVL<T> node, int depth) {
        if (node == null) return;
        assignCoords(node.left,  depth + 1);
        coords.put(node.data.toString(), new double[]{ xCounter * 100, depth * 100 });
        xCounter++;
        assignCoords(node.right, depth + 1);
    }

    // Añade nodos/aristas al grafo
    private void buildGraph(Graph g, NodeAVL<T> node) {
        if (node == null) return;
        String id = node.data.toString();
        if (g.getNode(id) == null) g.addNode(id);

        if (node.left != null) {
            String lid = node.left.data.toString();
            if (g.getNode(lid) == null) g.addNode(lid);
            String eL = id + "_" + lid;
            if (g.getEdge(eL) == null) g.addEdge(eL, id, lid, true);
            buildGraph(g, node.left);
        }

        if (node.right != null) {
            String rid = node.right.data.toString();
            if (g.getNode(rid) == null) g.addNode(rid);
            String eR = id + "_" + rid;
            if (g.getEdge(eR) == null) g.addEdge(eR, id, rid, true);
            buildGraph(g, node.right);
        }
    }
}
