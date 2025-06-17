package PRACTICA06.EJERCICIOS_PROPUESTOS;

import java.util.ArrayList;
import java.util.List;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class BST<T extends Comparable<T>> implements BSTInterface<T> {
    private Node<T> root;

    public BST() {
        root = null;
    }

    @Override
    public void destroy() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void insert(T key) {
        root = insertRec(root, key);
    }
    private Node<T> insertRec(Node<T> node, T key) {
        if (node == null) return new Node<>(key);
        if (key.compareTo(node.getData()) < 0)
            node.setLeft(insertRec(node.getLeft(), key));
        else if (key.compareTo(node.getData()) > 0)
            node.setRight(insertRec(node.getRight(), key));
        return node;
    }

    @Override
    public void remove(T key) {
        root = removeRec(root, key);
    }
    private Node<T> removeRec(Node<T> node, T key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.getData());
        if (cmp < 0) {
            node.setLeft(removeRec(node.getLeft(), key));
        } else if (cmp > 0) {
            node.setRight(removeRec(node.getRight(), key));
        } else {
            // Caso 0 o 1 hijos
            if (node.getLeft() == null)  return node.getRight();
            if (node.getRight() == null) return node.getLeft();
            // Caso 2 hijos: sustituir con sucesor
            Node<T> succ = minNode(node.getRight());
            node.setData(succ.getData());
            node.setRight(removeRec(node.getRight(), succ.getData()));
        }
        return node;
    }

    @Override
    public Node<T> search(T key) {
        return searchRec(root, key);
    }
    private Node<T> searchRec(Node<T> node, T key) {
        if (node == null || node.getData().equals(key)) return node;
        if (key.compareTo(node.getData()) < 0)
            return searchRec(node.getLeft(), key);
        else
            return searchRec(node.getRight(), key);
    }

    @Override
    public T min() {
        Node<T> n = minNode(root);
        return (n != null) ? n.getData() : null;
    }
    private Node<T> minNode(Node<T> node) {
        while (node != null && node.getLeft() != null)
            node = node.getLeft();
        return node;
    }

    @Override
    public T max() {
        Node<T> n = maxNode(root);
        return (n != null) ? n.getData() : null;
    }
    private Node<T> maxNode(Node<T> node) {
        while (node != null && node.getRight() != null)
            node = node.getRight();
        return node;
    }

    @Override
    public T predecessor(T key) {
        Node<T> node = search(key);
        if (node == null) return null;
        if (node.getLeft() != null)
            return maxNode(node.getLeft()).getData();
        Node<T> pred = null, anc = root;
        while (anc != null) {
            int cmp = key.compareTo(anc.getData());
            if (cmp > 0) {
                pred = anc;
                anc = anc.getRight();
            } else {
                anc = anc.getLeft();
            }
        }
        return (pred != null) ? pred.getData() : null;
    }

    @Override
    public T successor(T key) {
        Node<T> node = search(key);
        if (node == null) return null;
        if (node.getRight() != null)
            return minNode(node.getRight()).getData();
        Node<T> succ = null, anc = root;
        while (anc != null) {
            int cmp = key.compareTo(anc.getData());
            if (cmp < 0) {
                succ = anc;
                anc = anc.getLeft();
            } else {
                anc = anc.getRight();
            }
        }
        return (succ != null) ? succ.getData() : null;
    }

    @Override
    public List<T> inOrder() {
        List<T> res = new ArrayList<>();
        inOrderRec(root, res);
        return res;
    }
    private void inOrderRec(Node<T> n, List<T> r) {
        if (n != null) {
            inOrderRec(n.getLeft(), r);
            r.add(n.getData());
            inOrderRec(n.getRight(), r);
        }
    }

    @Override
    public List<T> preOrder() {
        List<T> res = new ArrayList<>();
        preOrderRec(root, res);
        return res;
    }
    private void preOrderRec(Node<T> n, List<T> r) {
        if (n != null) {
            r.add(n.getData());
            preOrderRec(n.getLeft(), r);
            preOrderRec(n.getRight(), r);
        }
    }

    @Override
    public List<T> postOrder() {
        List<T> res = new ArrayList<>();
        postOrderRec(root, res);
        return res;
    }
    private void postOrderRec(Node<T> n, List<T> r) {
        if (n != null) {
            postOrderRec(n.getLeft(), r);
            postOrderRec(n.getRight(), r);
            r.add(n.getData());
        }
    }
    /** Imprime el árbol girado 90° */
    public void printTree() {
        printNode(root, 0);
    }

    private void printNode(Node<T> node, int indent) {
        if (node == null) return;
        // primero el subárbol derecho
        printNode(node.getRight(), indent + 4);
        // luego este nodo, con indent espacios
        for (int i = 0; i < indent; i++) System.out.print(" ");
        System.out.println(node.getData());
        // finalmente el subárbol izquierdo
        printNode(node.getLeft(), indent + 4);
    }

   

    public Node<T> getRoot() {
        return root;
    }

    public void displayGraph(String graphId) {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph(graphId);
        graph.setAttribute("ui.stylesheet",
            "node { fill-color: #FFDD88; size: 30px; text-alignment: center; }" +
            "edge { fill-color: #333333; }"
        );

        addToGraph(graph, root);

        InOrderLayouter lay = new InOrderLayouter();
        lay.layout(root);
        lay.applyToGraph(graph);

        Viewer viewer = graph.display();
        viewer.disableAutoLayout();
    }

    private void addToGraph(Graph g, Node<T> n) {
        if (n == null) return;
        String id = n.getData().toString();
        if (g.getNode(id) == null)
            g.addNode(id).setAttribute("ui.label", id);
        if (n.getLeft() != null) {
            String lid = n.getLeft().getData().toString();
            addToGraph(g, n.getLeft());
            g.addEdge(id + "_L_" + lid, id, lid, true);
        }
        if (n.getRight() != null) {
            String rid = n.getRight().getData().toString();
            addToGraph(g, n.getRight());
            g.addEdge(id + "_R_" + rid, id, rid, true);
        }
    }


    private class InOrderLayouter {
        private int counter = 0;
        private java.util.Map<Node<T>, double[]> pos = new java.util.HashMap<>();

        public void layout(Node<T> nodo) {
            layoutRec(nodo, 0);
        }

        private void layoutRec(Node<T> nodo, int depth) {
            if (nodo == null) return;
            layoutRec(nodo.getLeft(), depth + 1);
            double x = counter * 2.0;
            double y = -depth * 2.0;
            pos.put(nodo, new double[]{x, y});
            counter++;
            layoutRec(nodo.getRight(), depth + 1);
        }

        public void applyToGraph(Graph g) {
            for (java.util.Map.Entry<Node<T>, double[]> e : pos.entrySet()) {
                String id = e.getKey().getData().toString();
                double[] xy = e.getValue();
                g.getNode(id).setAttribute("xy", xy[0], xy[1]);
            }
        }
    }
}