package PRACTICA06.EJERCICIOS_PROPUESTOS;

import java.util.List;

public interface BSTInterface<T extends Comparable<T>> {
   
    void destroy();

    boolean isEmpty();
    
    void insert(T key);
   
    void remove(T key);
    
    Node<T> search(T key);
    
    T min();
    T max();
    
    T predecessor(T key);
    T successor(T key);
    
    List<T> inOrder();
    List<T> preOrder();
    List<T> postOrder();
}