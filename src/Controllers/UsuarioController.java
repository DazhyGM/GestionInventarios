package Controllers;

import Models.UsuarioModel;
import Services.UsuarioService;
import java.util.List;

public class UsuarioController {
    
    private final UsuarioService usuarioService;

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
    
    public String recuperarContrasena(String correo) {
        UsuarioModel usuario = usuarioService.obtenerUsuarioPorCorreo(correo);
        if (usuario == null) {
            return "No existe un usuario registrado con ese correo.";
        }

        String contrasenaTemporal = usuarioService.generarContrasenaTemporal();
        boolean actualizada = usuarioService.actualizarContrasena(usuario.getNumeroDocumento(), contrasenaTemporal);

        if (actualizada) {
            EnvioCorreoController correoController = new EnvioCorreoController();
            correoController.enviarRecuperacionContrasena(usuario, contrasenaTemporal);
            return "Se ha enviado una nueva contraseña temporal al correo: " + correo;
        } else {
            return "Error al actualizar la contraseña. Inténtelo más tarde.";
        }
    }
    
    public boolean actualizarContrasena(String numeroDocumento, String nuevaContrasena) {
        return usuarioService.actualizarContrasena(numeroDocumento, nuevaContrasena);
    }

}