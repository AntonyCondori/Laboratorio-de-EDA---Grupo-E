package PRACTICA09.EJERCICIOS_RESUELTOS.HashAbierto;

public class TestHashOpened {
    public static void main(String[] args) {
        // Crear tabla hash con tamaño 8
        HashOpened<String> tabla = new HashOpened<>(8);

        // Insertar elementos
        tabla.insert(new Register<>(5, "Pepe"));
        tabla.insert(new Register<>(21, "Jesús"));
        tabla.insert(new Register<>(19, "Juan"));
        tabla.insert(new Register<>(16, "María"));
        tabla.insert(new Register<>(21, "DUPLICADO")); // Debe rechazar duplicado

        // Mostrar estado de la tabla
        tabla.showTable();

        // Buscar elementos por clave
        System.out.println("\n--- Búsquedas ---");
        Register<String> encontrado1 = tabla.search(5);
        System.out.println("Buscar clave 5: " + (encontrado1 != null ? encontrado1 : "No encontrado"));

        Register<String> encontrado2 = tabla.search(21);
        System.out.println("Buscar clave 21: " + (encontrado2 != null ? encontrado2 : "No encontrado"));

        // Eliminar elementos
        System.out.println("\n--- Eliminaciones ---");
        tabla.delete(21);  // Eliminación lógica
        tabla.delete(100); // Clave inexistente

        // Mostrar estado final de la tabla
        tabla.showTable();
    }
}