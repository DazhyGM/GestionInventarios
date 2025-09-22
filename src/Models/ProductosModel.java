/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


public class ProductosModel {
    private int id;
    private String nombre;
    private int cantidad;
    private String referencia;
    private double precio;
    
    
    public ProductosModel(){
    }
    
    
    public ProductosModel(int id, String nombre, int cantidad, String referencia, double precio){
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.referencia = referencia;
        this.precio = precio;
                   
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
    
    public int getCantidad(){
    return cantidad;
    }
    public void setCantidad(int cantidad){
            this.cantidad = cantidad;
    }
    
    public String getReferencia(){
    return referencia;
    }
    
    public void setReferencia( String referencia){
    this.referencia = referencia; 
    }
    
    public double getPrecio(){
    return precio;
    }
    
    public void setPrecio(int precio){
    this.precio = precio;
    }
}

