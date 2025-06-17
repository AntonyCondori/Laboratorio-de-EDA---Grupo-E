package PRACTICA06.EJERCICIOS_PROPUESTOS;

public class BSTGraphMain {
    public static void main(String[] args) {
        
        BST<Integer> bst = new BST<>();
        int[] vals = {23, 54, 76, 21, 34, 87, 45};
        for (int v : vals) {
            bst.insert(v);
        }

        bst.displayGraph("Árbol de Búsqueda");
    }
}
