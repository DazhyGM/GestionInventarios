
package Controllers;
import Models.UsuarioModel;
import Services.UsuarioService;

public class UsuarioController {
    public UsuarioService usuarioService;
    public UsuarioController(){
        this.usuarioService = new UsuarioService();
        
    } 
    public boolean CrearUsuario(){
        boolean response = usuarioService.RegistrarUsuario();
        return response;
    }
    
     public UsuarioModel BuscarUsuario(){
        UsuarioModel response = usuarioService.VerUsuario();
        return response;
    }
    
    
    public boolean ValidarUsuario(String correo, String contraseña){
        UsuarioModel usuarioDb = usuarioService.VerUsuario();
        if(usuarioDb.correo.equals(correo)&& usuarioDb.contraseña.equals(contraseña)){
            return true;
            
        } else {
            return false;
        }
    }

    
}
