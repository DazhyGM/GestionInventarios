package Controllers;

import Models.ProductosModel;
import Services.ProductosService;
import java.util.List;
public class RegistrarProductosController {
    private ProductosService productoService;
    
    public RegistrarProductosController() {
        this.productoService = new ProductosService();
    }

    public void agregarProductos(int id, String nombre, int cantidad, String referencia, double precio) {
        ProductosModel producto = new ProductosModel(id, nombre, cantidad, referencia, precio);
        productoService.agregarProductos(producto);
    }
    
    
    public void modificarProductos(int id, String nombre, int cantidad, String referencia, double precio){
    ProductosModel producto = new ProductosModel(id, nombre, cantidad, referencia, precio);
    productoService.actualizarProductos(producto);
    }
    public List<ProductosModel> listarProductos() {
        return productoService.listarProductos();
    }
}

