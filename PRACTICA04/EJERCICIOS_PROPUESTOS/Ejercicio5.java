package PRACTICA04.EJERCICIOS_PROPUESTOS;

import java.util.Scanner;

public class Ejercicio5 {

    static class LinkedList<E> {
        static class Nodo<E> {
            E dato;
            Nodo<E> siguiente;

            Nodo(E dato) {
                this.dato = dato;
                this.siguiente = null;
            }
        }

        private Nodo<E> cabeza; 

        public LinkedList() {
            cabeza = null;
        }

        public void addLast(E dato) {
            Nodo<E> nuevoNodo = new Nodo<>(dato);
            if (cabeza == null) {
                cabeza = nuevoNodo;
                return;
            }
            Nodo<E> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }

        public void addFirst(E dato) {
            Nodo<E> nuevoNodo = new Nodo<>(dato);
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }

        public void printList() {
            if (cabeza == null) {
                System.out.println("La lista está vacía.");
                return;
            }
            System.out.print("Lista: ");
            Nodo<E> actual = cabeza;
            while (actual != null) {
                System.out.print(actual.dato + " ");
                actual = actual.siguiente;
            }
            System.out.println();
        }

        public E deleteByKey(E clave) {
            if (cabeza == null) {
                return null;
            }

            if (cabeza.dato.equals(clave)) {
                E valorEliminado = cabeza.dato;
                cabeza = cabeza.siguiente;
                return valorEliminado;
            }

            Nodo<E> anterior = cabeza;
            Nodo<E> actual = cabeza.siguiente;
            while (actual != null && !actual.dato.equals(clave)) {
                anterior = actual;
                actual = actual.siguiente;
            }
            if (actual != null) {

                anterior.siguiente = actual.siguiente;
                return actual.dato;
            } else {
                return null;
            }
        }

        public E deleteAtPosition(int indice) {
            if (cabeza == null || indice < 0) {
                return null;
            }

            if (indice == 0) {
                E valorEliminado = cabeza.dato;
                cabeza = cabeza.siguiente;
                return valorEliminado;
            }

            Nodo<E> anterior = cabeza;
            Nodo<E> actual = cabeza.siguiente;
            int contador = 1;
            while (actual != null && contador < indice) {
                anterior = actual;
                actual = actual.siguiente;
                contador++;
            }
            if (actual != null) {

                anterior.siguiente = actual.siguiente;
                return actual.dato;
            } else {
                return null;
            }
        }

        public E removeFirst() {
            if (cabeza == null) {
                return null;
            }
            E valorEliminado = cabeza.dato;
            cabeza = cabeza.siguiente;
            return valorEliminado;
        }

        public E removeLast() {
            if (cabeza == null) {
                return null;
            }
            if (cabeza.siguiente == null) {
                E valorEliminado = cabeza.dato;
                cabeza = null;
                return valorEliminado;
            }
            Nodo<E> anterior = cabeza;
            Nodo<E> actual = cabeza.siguiente;
            while (actual.siguiente != null) {
                anterior = actual;
                actual = actual.siguiente;
            }
            E valorEliminado = actual.dato;
            anterior.siguiente = null;
            return valorEliminado;
        }

        public int size() {
            int cuenta = 0;
            Nodo<E> actual = cabeza;
            while (actual != null) {
                cuenta++;
                actual = actual.siguiente;
            }
            return cuenta;
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        LinkedList<Integer> lista = new LinkedList<>();

        for (int i = 1; i <= 10; i++) {
            lista.addLast(i);
        }

        boolean salir = false;
        while (!salir) {
            System.out.println();
            System.out.println("=== MENÚ EJERCICIO 5: Lista Enlazada Simple Genérica ===");
            System.out.println("1) Mostrar lista completa");
            System.out.println("2) Insertar al inicio (addFirst)");
            System.out.println("3) Insertar al final (addLast)");
            System.out.println("4) Eliminar por clave (deleteByKey) → devuelve el valor eliminado");
            System.out.println("5) Eliminar por posición (deleteAtPosition) → devuelve el valor eliminado");
            System.out.println("6) Tamaño de la lista (size)");
            System.out.println("7) Remover primer elemento (removeFirst) → devuelve el valor eliminado");
            System.out.println("8) Remover último elemento (removeLast) → devuelve el valor eliminado");
            System.out.println("9) Salir");
            System.out.print("Elige una opción: ");
            int opcion = entrada.nextInt();

            Integer resultado;
            switch (opcion) {
                case 1:
                    lista.printList();
                    break;
                case 2:
                    System.out.print("Ingresa el valor (Integer) a insertar al inicio: ");
                    Integer valorInicio = entrada.nextInt();
                    lista.addFirst(valorInicio);
                    System.out.println("Se insertó " + valorInicio + " al inicio.");
                    break;
                case 3:
                    System.out.print("Ingresa el valor (Integer) a insertar al final: ");
                    Integer valorFinal = entrada.nextInt();
                    lista.addLast(valorFinal);
                    System.out.println("Se insertó " + valorFinal + " al final.");
                    break;
                case 4:
                    System.out.print("Ingresa la clave (Integer) a eliminar: ");
                    Integer clave = entrada.nextInt();
                    resultado = lista.deleteByKey(clave);
                    if (resultado != null) {
                        System.out.println("Se eliminó la clave: " + resultado);
                    } else {
                        System.out.println("No se encontró la clave: " + clave);
                    }
                    break;
                case 5:
                    System.out.print("Ingresa la posición (0‐based) a eliminar: ");
                    int indice = entrada.nextInt();
                    resultado = lista.deleteAtPosition(indice);
                    if (resultado != null) {
                        System.out.println("Se eliminó el elemento en posición " + indice + ": " + resultado);
                    } else {
                        System.out.println("Índice " + indice + " fuera de rango.");
                    }
                    break;
                case 6:
                    int tam = lista.size();
                    System.out.println("Tamaño de la lista: " + tam);
                    break;
                case 7:
                    resultado = lista.removeFirst();
                    if (resultado != null) {
                        System.out.println("Se removió el primer elemento: " + resultado);
                    } else {
                        System.out.println("La lista está vacía. No se pudo remover el primero.");
                    }
                    break;
                case 8:
                    resultado = lista.removeLast();
                    if (resultado != null) {
                        System.out.println("Se removió el último elemento: " + resultado);
                    } else {
                        System.out.println("La lista está vacía. No se pudo remover el último.");
                    }
                    break;
                case 9:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    break;
            }
        }

        entrada.close();
    }
}