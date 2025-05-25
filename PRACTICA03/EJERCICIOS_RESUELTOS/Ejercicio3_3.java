package PRACTICA03.EJERCICIOS_RESUELTOS;

import java.util.*;

public class Ejercicio3_3 {
    public static void main(String[] args){
        ArrayList<Animal> mascotas = new ArrayList<Animal>();
        List<Animal> mascotas2 = new ArrayList<Animal>();

        mascotas.add(new Animal("Perro", true));
        mascotas.add(new Animal("Gato", false));
        mascotas2.add(new Animal("Loro", true));
        mascotas2.add(new Animal("Pez", false));

        Iterator<Animal> itAnimal = mascotas2.iterator();
        while (itAnimal.hasNext()) {
            Animal a = itAnimal.next();
            System.out.printf("Nombre: %s, Genero: %s%n", a.getNombre() , a.isGenero() ? "Macho" : "Hembra");
        }
    }
}

