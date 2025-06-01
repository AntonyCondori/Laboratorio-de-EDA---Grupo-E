package PRACTICA04.EJERCICIOS_PROPUESTOS;
import java.util.Scanner;

public class Ejercicio6 {

    static class LinkedListDoble<E> {

        static class NodoDoble<E> {
            E dato;
            NodoDoble<E> anterior;
            NodoDoble<E> siguiente;

            NodoDoble(E dato) {
                this.dato = dato;
                this.anterior = null;
                this.siguiente = null;
            }
        }

        private NodoDoble<E> cabeza;
        private NodoDoble<E> cola;  

        public LinkedListDoble() {
            cabeza = null;
            cola = null;
        }

        public void addLast(E dato) {
            NodoDoble<E> nuevoNodo = new NodoDoble<>(dato);
            if (cabeza == null) {
                cabeza = nuevoNodo;
                cola = nuevoNodo;
                return;
            }
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }

        public void addFirst(E dato) {
            NodoDoble<E> nuevoNodo = new NodoDoble<>(dato);
            if (cabeza == null) {
                cabeza = nuevoNodo;
                cola = nuevoNodo;
                return;
            }
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }

        public void printForward() {
            if (cabeza == null) {
                System.out.println("La lista está vacía.");
                return;
            }
            System.out.print("Lista (adelante): ");
            NodoDoble<E> actual = cabeza;
            while (actual != null) {
                System.out.print(actual.dato + " ");
                actual = actual.siguiente;
            }
            System.out.println();
        }

        public void printBackward() {
            if (cola == null) {
                System.out.println("La lista está vacía.");
                return;
            }
            System.out.print("Lista (atrás): ");
            NodoDoble<E> actual = cola;
            while (actual != null) {
                System.out.print(actual.dato + " ");
                actual = actual.anterior;
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
                if (cabeza != null) {
                    cabeza.anterior = null;
                } else {
                    cola = null;
                }
                return valorEliminado;
            }
            NodoDoble<E> actual = cabeza.siguiente;
            while (actual != null && !actual.dato.equals(clave)) {
                actual = actual.siguiente;
            }
            if (actual != null) {
                if (actual == cola) {
                    E valorEliminado = cola.dato;
                    cola = cola.anterior;
                    if (cola != null) {
                        cola.siguiente = null;
                    } else {
                        cabeza = null;
                    }
                    return valorEliminado;
                } else {
                    E valorEliminado = actual.dato;
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                    return valorEliminado;
                }
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
                if (cabeza != null) {
                    cabeza.anterior = null;
                } else {
                    cola = null;
                }
                return valorEliminado;
            }
            NodoDoble<E> actual = cabeza;
            int contador = 0;
            while (actual != null && contador < indice) {
                actual = actual.siguiente;
                contador++;
            }
            if (actual != null) {
                if (actual == cola) {
                    E valorEliminado = cola.dato;
                    cola = cola.anterior;
                    if (cola != null) {
                        cola.siguiente = null;
                    } else {
                        cabeza = null;
                    }
                    return valorEliminado;
                } else {
                    E valorEliminado = actual.dato;
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                    return valorEliminado;
                }
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
            if (cabeza != null) {
                cabeza.anterior = null;
            } else {
                cola = null;
            }
            return valorEliminado;
        }

        public E removeLast() {
            if (cola == null) {
                return null;
            }
            E valorEliminado = cola.dato;
            cola = cola.anterior;
            if (cola != null) {
                cola.siguiente = null;
            } else {
                cabeza = null;
            }
            return valorEliminado;
        }

        public int size() {
            int cuenta = 0;
            NodoDoble<E> actual = cabeza;
            while (actual != null) {
                cuenta++;
                actual = actual.siguiente;
            }
            return cuenta;
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        LinkedListDoble<Integer> lista = new LinkedListDoble<>();

        for (int i = 1; i <= 10; i++) {
            lista.addLast(i);
        }

        boolean salir = false;
        while (!salir) {
            System.out.println();
            System.out.println("=== MENÚ EJERCICIO 6: Lista Doblemente Enlazada Genérica ===");
            System.out.println("1) Mostrar lista adelante (printForward)");
            System.out.println("2) Mostrar lista atrás (printBackward)");
            System.out.println("3) Insertar al inicio (addFirst)");
            System.out.println("4) Insertar al final (addLast)");
            System.out.println("5) Eliminar por clave (deleteByKey) → devuelve el valor eliminado");
            System.out.println("6) Eliminar por posición (deleteAtPosition) → devuelve el valor eliminado");
            System.out.println("7) Tamaño de la lista (size)");
            System.out.println("8) Remover primer elemento (removeFirst) → devuelve el valor eliminado");
            System.out.println("9) Remover último elemento (removeLast) → devuelve el valor eliminado");
            System.out.println("10) Salir");
            System.out.print("Elige una opción: ");
            int opcion = entrada.nextInt();

            Integer resultado;
            switch (opcion) {
                case 1:
                    lista.printForward();
                    break;
                case 2:
                    lista.printBackward();
                    break;
                case 3:
                    System.out.print("Ingresa el valor (Integer) a insertar al inicio: ");
                    Integer valorInicio = entrada.nextInt();
                    lista.addFirst(valorInicio);
                    System.out.println("Se insertó " + valorInicio + " al inicio.");
                    break;
                case 4:
                    System.out.print("Ingresa el valor (Integer) a insertar al final: ");
                    Integer valorFinal = entrada.nextInt();
                    lista.addLast(valorFinal);
                    System.out.println("Se insertó " + valorFinal + " al final.");
                    break;
                case 5:
                    System.out.print("Ingresa la clave (Integer) a eliminar: ");
                    Integer clave = entrada.nextInt();
                    resultado = lista.deleteByKey(clave);
                    if (resultado != null) {
                        System.out.println("Se eliminó la clave: " + resultado);
                    } else {
                        System.out.println("No se encontró la clave: " + clave);
                    }
                    break;
                case 6:
                    System.out.print("Ingresa la posición (0‐based) a eliminar: ");
                    int indice = entrada.nextInt();
                    resultado = lista.deleteAtPosition(indice);
                    if (resultado != null) {
                        System.out.println("Se eliminó el elemento en posición " + indice + ": " + resultado);
                    } else {
                        System.out.println("Índice " + indice + " fuera de rango.");
                    }
                    break;
                case 7:
                    int tam = lista.size();
                    System.out.println("Tamaño de la lista: " + tam);
                    break;
                case 8:
                    resultado = lista.removeFirst();
                    if (resultado != null) {
                        System.out.println("Se removió el primer elemento: " + resultado);
                    } else {
                        System.out.println("La lista está vacía. No se pudo remover el primero.");
                    }
                    break;
                case 9:
                    resultado = lista.removeLast();
                    if (resultado != null) {
                        System.out.println("Se removió el último elemento: " + resultado);
                    } else {
                        System.out.println("La lista está vacía. No se pudo remover el último.");
                    }
                    break;
                case 10:
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