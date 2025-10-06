package Controllers;

import Models.UsuarioModel;
import Services.UsuarioService;
import java.util.List;

public class UsuarioController {
    
    private UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    public String crearUsuario(String numeroDocumento, String nombre, String apellido, String correo, String contrasena, String telefono) {
        UsuarioModel usuario = new UsuarioModel(numeroDocumento, nombre, apellido, correo, contrasena, telefono);
        return usuarioService.agregarUsuario(usuario);
    }

    public boolean login(String correo, String contrasena) {
        return usuarioService.verificarUsuario(correo, contrasena);
    }

    public List<UsuarioModel> obtenerUsuarios() {
        return usuarioService.listarUsuarios();
}
}