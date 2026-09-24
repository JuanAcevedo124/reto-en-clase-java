import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class GestorProductos {

    /**
     * Filtra los productos por una categoria especifica usando lambda en filter.
     *
     * @param productos lista original
     * @param categoria categoria a filtrar (ignora mayusculas/minusculas)
     * @return lista solo con productos de esa categoria
     */
    public List<Producto> filtrarPorCategoria(List<Producto> productos, String categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    /**
     * Ordena los productos en orden descendente por precio usando lambda en sorted/sort.
     *
     * @param productos lista a ordenar (no se modifica la original)
     * @return nueva lista ordenada de mayor a menor precio
     */
    public List<Producto> ordenarPorPrecioDesc(List<Producto> productos) {
        return productos.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrecio(), p1.getPrecio()))
                .collect(Collectors.toList());
    }

    /**
     * Filtra por categoria y ordena por precio descendente en un solo pipeline.
     *
     * @param productos lista original
     * @param categoria categoria a filtrar
     * @return lista filtrada y ordenada
     */
    public List<Producto> filtrarYOrdenar(List<Producto> productos, String categoria) {
        return productos.stream()
                // 1. Lambda de filtrado
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                // 2. Lambda de ordenacion descendente (tambien vale Comparator.comparingDouble(...).reversed())
                .sorted((p1, p2) -> Double.compare(p2.getPrecio(), p1.getPrecio()))
                .collect(Collectors.toList());
    }

    /**
     * Variante que ordena in-place una lista mutable usando Comparator lambda.
     */
    public void ordenarInPlaceDesc(List<Producto> productos) {
        Comparator<Producto> porPrecioDesc = (p1, p2) -> Double.compare(p2.getPrecio(), p1.getPrecio());
        productos.sort(porPrecioDesc);
    }
}
