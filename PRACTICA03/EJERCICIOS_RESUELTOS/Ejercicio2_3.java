package PRACTICA03.EJERCICIOS_RESUELTOS;

import java.util.*;

public class Ejercicio2_3{
    public static void main(String[] args){
        ArrayList<String> alumnos = new ArrayList<String>();
        ArrayList<Integer> notas = new ArrayList<Integer>();
        alumnos.add("MARIA");
        alumnos.add("DIEGO");
        alumnos.add("RENE");
        alumnos.add("ALONSO");
        System.out.println(alumnos.hashCode());
        System.out.println(alumnos.isEmpty());
        System.out.println(alumnos.size());

        Iterator<String> itA = alumnos.iterator();
        while (itA.hasNext()) {
        System.out.println(itA.next());
        }
    }
}