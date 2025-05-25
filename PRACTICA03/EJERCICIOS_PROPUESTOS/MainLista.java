package PRACTICA03.EJERCICIOS_PROPUESTOS;

public class MainLista {
    public static void main(String[] args) {
        Lista<String> listaAlumnos = new Lista<>();
        listaAlumnos.agregar("MARIA");
        listaAlumnos.agregar("DIEGO");
        listaAlumnos.agregar("RENE");
        listaAlumnos.agregar("ALONSO");

        System.out.println("Lista completa: " + listaAlumnos);
        System.out.println("¿Está vacía?: " + listaAlumnos.estaVacia());
        System.out.println("Tamaño de la lista: " + listaAlumnos.tamaño());
        System.out.println("Elemento en posición 2: " + listaAlumnos.obtener(2));
        System.out.println("¿Contiene 'RENE'?: " + listaAlumnos.contiene("RENE"));

        listaAlumnos.limpiar();
        System.out.println("Después de limpiar, ¿vacía?: " + listaAlumnos.estaVacia());
    }
}