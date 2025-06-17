package PRACTICA06.EJERCICIOS_PROPUESTOS;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class PruebaGraph {
    public static void main(String[] args) {
    System.setProperty("org.graphstream.ui", "swing");
    Graph g = new SingleGraph("Test");
    g.addNode("A");
    g.display();  // ahora sí encontrará el viewer Swing
    }
}