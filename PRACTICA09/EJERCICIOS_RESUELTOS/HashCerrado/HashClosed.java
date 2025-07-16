package PRACTICA09.EJERCICIOS_RESUELTOS.HashCerrado;

public class HashClosed<E> {
    private Register<E>[] table;
    private int size;
    private int capacity;
    private final Register<E> DELETED = new Register<>(-1, null); // Marca de borrado

    @SuppressWarnings("unchecked")
    public HashClosed(int capacity) {
        this.capacity = capacity;
        this.table = (Register<E>[]) new Register[capacity];
        this.size = 0;
    }

    // Función hash simple
    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    // Insertar elemento (sondeo lineal)
    public boolean insert(int key, E value) {
        if (size == capacity) return false; // Tabla llena
        int idx = hash(key);
        for (int i = 0; i < capacity; i++) {
            int pos = (idx + i) % capacity;
            if (table[pos] == null || table[pos] == DELETED) {
                table[pos] = new Register<>(key, value);
                size++;
                return true;
            }
            // Si la clave ya existe, actualiza el valor
            if (table[pos].getKey() == key) {
                table[pos].setValue(value);
                return true;
            }
        }
        return false;
    }

    // Buscar elemento
    public E search(int key) {
        int idx = hash(key);
        for (int i = 0; i < capacity; i++) {
            int pos = (idx + i) % capacity;
            if (table[pos] == null) return null;
            if (table[pos] != DELETED && table[pos].getKey() == key) {
                return table[pos].getValue();
            }
        }
        return null;
    }

    // Eliminar elemento (marcado como DELETED)
    public boolean delete(int key) {
        int idx = hash(key);
        for (int i = 0; i < capacity; i++) {
            int pos = (idx + i) % capacity;
            if (table[pos] == null) return false;
            if (table[pos] != DELETED && table[pos].getKey() == key) {
                table[pos] = DELETED;
                size--;
                return true;
            }
        }
        return false;
    }

    // Mostrar tabla completa
    public void printTable() {
        System.out.println("Tabla Hash:");
        for (int i = 0; i < capacity; i++) {
            System.out.print(i + ": ");
            if (table[i] == null) {
                System.out.println("VACÍO");
            } else if (table[i] == DELETED) {
                System.out.println("ELIMINADO");
            } else {
                System.out.println(table[i]);
            }
        }
    }
}
