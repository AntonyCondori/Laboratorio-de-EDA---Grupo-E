package PRACTICA05.EJERCICIOS_PROPUESTOS;

public class Ejercicio1Pila {
    public static void main(String[] args) {
        PilaNodo<Integer> pila = new PilaNodo<>();
        for (int i = 1; i <= 10; i++) {
            pila.apilar(i);
        }

        System.out.println("Desapilando elementos:");
        while (!pila.estaVacia()) {
            System.out.println(pila.desapilar());
        }
    }
}