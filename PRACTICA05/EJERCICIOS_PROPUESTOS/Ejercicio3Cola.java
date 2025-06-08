package PRACTICA05.EJERCICIOS_PROPUESTOS;

public class Ejercicio3Cola {
    public static void main(String[] args) {
        ColaNodo<Integer> cola = new ColaNodo<>();

        for (int i = 1; i <= 10; i++) {
            cola.encolar(i);
        }

        System.out.println("Desencolando elementos:");
        while (!cola.estaVacia()) {
            System.out.println(cola.desencolar());
        }
    }
}