package Controllers;

import Models.ProductosModel;
import Services.ProductosService;
import java.util.List;

public class ProductosController {
    private ProductosService productoService;
    
    public ProductosController() {
        this.productoService = new ProductosService();
    }

    public void agregarProductos(String nombre, String descripcion, String categoria,double precio, int stock) {
        ProductosModel producto = new ProductosModel(0, nombre, descripcion, categoria, precio, stock);
        productoService.agregarProductos(producto);
    }

    public void modificarProductos(int id, String nombre, String descripcion, String categoria,double precio, int stock){

        ProductosModel productoExistente = productoService.detalleProducto(id);
        
        if (productoExistente != null) {
            productoExistente.setNombre(nombre);
            productoExistente.setDescripcion(descripcion);
            productoExistente.setCategoria(categoria);
            productoExistente.setPrecio(precio);
            productoExistente.setStock(stock);
            
            if (stock > 0 && productoExistente.getEstadoId() == 3) {
                 productoExistente.setEstadoId(1); 
            }
            
            productoService.actualizarProductos(productoExistente);
        }
    }
    
    
    public ProductosModel verProducto(int id){
        return productoService.detalleProducto(id);
    }


    public List<ProductosModel> listarProductos() {
        return productoService.listarProductos();
    }
    
    public void eliminarProducto(int id) {
        productoService.eliminarProducto(id);
    }
}