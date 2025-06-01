package PRACTICA04.EJERCICIOS_PROPUESTOS;

import java.util.Scanner;

public class Ejercicio7 {

    static class CircularLinkedList<E> {

        static class NodoCircular<E> {
            E dato;
            NodoCircular<E> siguiente;

            NodoCircular(E dato) {
                this.dato = dato;
                this.siguiente = null;
            }
        }

        private NodoCircular<E> cabeza;

        public CircularLinkedList() {
            cabeza = null;
        }

        public void addLast(E dato) {
            NodoCircular<E> nuevoNodo = new NodoCircular<>(dato);
            if (cabeza == null) {
                cabeza = nuevoNodo;
                nuevoNodo.siguiente = cabeza;
                return;
            }
            NodoCircular<E> actual = cabeza;
            while (actual.siguiente != cabeza) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
        }

        public void addFirst(E dato) {
            NodoCircular<E> nuevoNodo = new NodoCircular<>(dato);
            if (cabeza == null) {
                cabeza = nuevoNodo;
                nuevoNodo.siguiente = cabeza;
                return;
            }
            NodoCircular<E> ultimo = cabeza;
            while (ultimo.siguiente != cabeza) {
                ultimo = ultimo.siguiente;
            }
            nuevoNodo.siguiente = cabeza;
            ultimo.siguiente = nuevoNodo;
            cabeza = nuevoNodo;
        }

        public void printList() {
            if (cabeza == null) {
                System.out.println("La lista circular está vacía.");
                return;
            }
            System.out.print("Lista Circular: ");
            NodoCircular<E> actual = cabeza;
            do {
                System.out.print(actual.dato + " ");
                actual = actual.siguiente;
            } while (actual != cabeza);
            System.out.println();
        }

        public E deleteByKey(E clave) {
            if (cabeza == null) {
                return null;
            }
            if (cabeza.dato.equals(clave) && cabeza.siguiente == cabeza) {
                E valorEliminado = cabeza.dato;
                cabeza = null;
                return valorEliminado;
            }
            if (cabeza.dato.equals(clave)) {
                NodoCircular<E> ultimo = cabeza;
                while (ultimo.siguiente != cabeza) {
                    ultimo = ultimo.siguiente;
                }
                E valorEliminado = cabeza.dato;
                cabeza = cabeza.siguiente;
                ultimo.siguiente = cabeza;
                return valorEliminado;
            }
            NodoCircular<E> anterior = cabeza;
            NodoCircular<E> actual = cabeza.siguiente;
            while (actual != cabeza && !actual.dato.equals(clave)) {
                anterior = actual;
                actual = actual.siguiente;
            }
            if (actual != cabeza && actual.dato.equals(clave)) {
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
            if (indice == 0 && cabeza.siguiente == cabeza) {
                E valorEliminado = cabeza.dato;
                cabeza = null;
                return valorEliminado;
            }
            if (indice == 0) {
                NodoCircular<E> ultimo = cabeza;
                while (ultimo.siguiente != cabeza) {
                    ultimo = ultimo.siguiente;
                }
                E valorEliminado = cabeza.dato;
                cabeza = cabeza.siguiente;
                ultimo.siguiente = cabeza;
                return valorEliminado;
            }
            NodoCircular<E> anterior = cabeza;
            NodoCircular<E> actual = cabeza.siguiente;
            int contador = 1;
            while (actual != cabeza && contador < indice) {
                anterior = actual;
                actual = actual.siguiente;
                contador++;
            }
            if (actual == cabeza) {
                return null;
            }
            E valorEliminado = actual.dato;
            anterior.siguiente = actual.siguiente;
            return valorEliminado;
        }

        public E removeFirst() {
            if (cabeza == null) {
                return null;
            }
            if (cabeza.siguiente == cabeza) {
                E valorEliminado = cabeza.dato;
                cabeza = null;
                return valorEliminado;
            }
            NodoCircular<E> ultimo = cabeza;
            while (ultimo.siguiente != cabeza) {
                ultimo = ultimo.siguiente;
            }
            E valorEliminado = cabeza.dato;
            cabeza = cabeza.siguiente;
            ultimo.siguiente = cabeza;
            return valorEliminado;
        }

        public E removeLast() {
            if (cabeza == null) {
                return null;
            }
            if (cabeza.siguiente == cabeza) {
                E valorEliminado = cabeza.dato;
                cabeza = null;
                return valorEliminado;
            }
            NodoCircular<E> anterior = cabeza;
            NodoCircular<E> actual = cabeza.siguiente;
            while (actual.siguiente != cabeza) {
                anterior = actual;
                actual = actual.siguiente;
            }
            E valorEliminado = actual.dato;
            anterior.siguiente = cabeza;
            return valorEliminado;
        }

        public int size() {
            if (cabeza == null) {
                return 0;
            }
            int cuenta = 0;
            NodoCircular<E> actual = cabeza;
            do {
                cuenta++;
                actual = actual.siguiente;
            } while (actual != cabeza);
            return cuenta;
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        CircularLinkedList<Integer> lista = new CircularLinkedList<>();

        for (int i = 1; i <= 12; i++) {
            lista.addLast(i);
        }

        boolean salir = false;
        while (!salir) {
            System.out.println();
            System.out.println("=== MENÚ EJERCICIO 7: Lista Circular Simple Genérica ===");
            System.out.println("1) Mostrar lista completa (printList)");
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