import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Archivo principal de ejecucion.
 * Demuestra filtrar por categoria y ordenar por precio descendente usando lambdas.
 */
public class Main {
    public static void main(String[] args) {
        List<Producto> productos = Arrays.asList(
                new Producto("Laptop", "Electronica", 3500.00),
                new Producto("Mouse", "Electronica", 80.50),
                new Producto("Teclado", "Electronica", 150.75),
                new Producto("Monitor", "Electronica", 1200.00),
                new Producto("Camisa", "Ropa", 120.00),
                new Producto("Pantalon", "Ropa", 200.00),
                new Producto("Zapatos", "Ropa", 350.00),
                new Producto("Manzana", "Alimentos", 5.00),
                new Producto("Pan", "Alimentos", 3.50)
        );

        GestorProductos gestor = new GestorProductos();

        String categoria;
        if (args.length > 0) {
            categoria = args[0];
        } else {
            System.out.println("=== LISTA COMPLETA ===");
            productos.forEach(p -> System.out.println(p));

            System.out.println();
            System.out.print("Ingrese la categoria a filtrar (ej: Electronica, Ropa, Alimentos): ");
            try (Scanner sc = new Scanner(System.in)) {
                categoria = sc.nextLine().trim();
            }
            if (categoria.isEmpty()) {
                categoria = "Electronica";
                System.out.println("Sin entrada, usando categoria por defecto: " + categoria);
            }
        }

        // 1 + 2: filtrar y ordenar usando lambdas (ver GestorProductos)
        List<Producto> resultado = gestor.filtrarYOrdenar(productos, categoria);

        System.out.println();
        System.out.println("=== PRODUCTOS FILTRADOS POR '" + categoria + "' ORDENADOS POR PRECIO DESC ===");
        if (resultado.isEmpty()) {
            System.out.println("No se encontraron productos en esa categoria.");
        } else {
            resultado.forEach(p -> System.out.println(p));
        }
    }
}
