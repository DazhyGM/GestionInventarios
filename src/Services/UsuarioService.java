
package Services;

import Models.UsuarioModel;

public class UsuarioService {
    
    public boolean RegistrarUsuario(){
        System.out.println("El usuario se registro exitosamente");
        return true;
        
    }
    
      public UsuarioModel VerUsuario(){
         UsuarioModel usuario = new UsuarioModel(1, "julian", "medina", "pepito@gmail.com", "1234");
          return usuario; 
          
        
    }
      
      
        public boolean ActualizarUsuario(){
        System.out.println("El usuario se registro exitosamente");
        return true;
        
    }
        
        
          public boolean EliminaUsuario(){
        System.out.println("El usuario se registro exitosamente");
        return true;
        
    }
}
