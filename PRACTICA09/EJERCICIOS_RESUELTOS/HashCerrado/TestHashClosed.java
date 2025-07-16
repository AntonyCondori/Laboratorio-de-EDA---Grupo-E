package PRACTICA09.EJERCICIOS_RESUELTOS.HashCerrado;

public class TestHashClosed {
    public static void main(String[] args){
        HashClosed<String> tabla = new HashClosed<>(11);

        // INSERCIÓN DE ELEMENTOS
        int[] claves = {100, 5, 14, 15, 22, 16, 17, 32, 13, 32, 100};
        String[] valores = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};

        System.out.println("Insertando elementos");
        for (int i = 0; i < claves.length; i++) {
            boolean ok = tabla.insert(claves[i], valores[i]);
            if (!ok) {
                System.out.println("No se pudo insertar clave " + claves[i] + " (duplicada o tabla llena).");
            }
        }
        
        // MOSTRAR TABLA HASH RESULTANTE
        System.out.println("\n>>> Tabla después de inserciones:");
        tabla.printTable();

        // BUSCAR LOS VALORES 32 Y 200
        System.out.println("\n>>> Buscando claves:");
        int[] busquedas = {32, 200};
        for (int clave : busquedas) {
            String valor = tabla.search(clave);
            if (valor != null) {
                System.out.println("Clave " + clave + " encontrada, valor: " + valor);
            } else {
                System.out.println("Clave " + clave + " NO encontrada.");
            }
        }

        // ELIMINAR LOS ELEMENTOS 17 Y 100
        System.out.println("\n>>> Eliminando claves 17 y 100:");
        int[] eliminaciones = {17, 100};
        for (int clave : eliminaciones) {
            boolean eliminado = tabla.delete(clave);
            if (eliminado) {
                System.out.println("Clave " + clave + " eliminada.");
            } else {
                System.out.println("Clave " + clave + " NO encontrada para eliminar.");
            }
        }

        // MOSTRAR LA TABLA HASH RESULTANTE
        System.out.println("\n>>> Tabla después de eliminaciones:");
        tabla.printTable();
    }
}
