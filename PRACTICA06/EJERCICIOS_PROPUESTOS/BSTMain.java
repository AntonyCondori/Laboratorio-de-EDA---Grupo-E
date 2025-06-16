package PRACTICA06.EJERCICIOS_PROPUESTOS;

public class BSTMain {
    public static void main(String[] args) {
        BSTInterface<Integer> bst = new BST<>(); 

        int[] vals = {53, 34, 27, 41, 77, 69, 83};
        for (int v : vals) bst.insert(v);

        System.out.println("InOrder:   " + bst.inOrder());
        System.out.println("PreOrder:  " + bst.preOrder());
        System.out.println("PostOrder: " + bst.postOrder());

        System.out.println("Min: " + bst.min());
        System.out.println("Max: " + bst.max());

        System.out.println("Buscar 41: " + (bst.search(41) != null));
        System.out.println("Predecesor de 53: " + bst.predecessor(53));
        System.out.println("Sucesor de 53:   " + bst.successor(53));

        bst.remove(27);
        System.out.println("Luego de remove(27): " + bst.inOrder());
        bst.remove(34);
        System.out.println("Luego de remove(34): " + bst.inOrder());
        bst.remove(53);
        System.out.println("Luego de remove(53): " + bst.inOrder());
    }
}