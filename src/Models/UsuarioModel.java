/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Lenovo
 */
public class UsuarioModel {
    public int id;
    public String nombre;
    public String apellido;
    public String correo;
    public String contraseña; 
    
    public UsuarioModel(int id, String nombre, String apellido, String correo, String contraseña){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        
    }
            
}
