package Models;

public class ProductosModel {
    private int id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private double precio;
    private int stock;
    private int estadoId;
    
    
    public ProductosModel(){
    }
    
    public ProductosModel(int id, String nombre, String descripcion, String categoria, double precio, int stock, int estadoId){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.estadoId = estadoId;
    }
    

    public ProductosModel(int id, String nombre, String descripcion, String categoria, double precio, int stock){

        this(id, nombre, descripcion, categoria, precio, stock, 1);
    }

    
    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;   
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getCategoria(){
        return categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
            
    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
    this.stock = stock;
    }
    
    public int getEstadoId() {
        return estadoId;
    }
    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }
    
    @Override
    public String toString() {
    return nombre;
}
    
}