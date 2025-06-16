package PRACTICA06.EJERCICIOS_PROPUESTOS;

import java.util.ArrayList;
import java.util.List;

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
}