package Services;

import DB.Data;
import Models.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsuarioService {
    
    public String agregarUsuario(UsuarioModel usuario) {
        
        if (!CorreoValido(usuario.getCorreo())) {
            return "Correo electrónico inválido. No se puede registrar el usuario.";
        }
        if (!DocumentoValido(usuario.getNumeroDocumento())) {
            
            return "Número de documento inválido. Debe contener solo números.";
        }
        Connection conexion = Data.getConnection();

        String sql = "INSERT INTO usuario (numero_documento, nombre, apellido, correo, contrasena, telefono) VALUES (?, ?, ?, ?, ?, ?)";
        

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            

            stmt.setString(1, usuario.getNumeroDocumento());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellido());
            stmt.setString(4, usuario.getCorreo());
            stmt.setString(5, usuario.getContrasena());
            stmt.setString(6, usuario.getTelefono());
            
            stmt.executeUpdate();
            return "OK";
            
        } catch (SQLException e) {
            
            if (e.getMessage().contains("Duplicate entry")) {
            if (e.getMessage().contains("numero_documento")) {
                return "Ya existe un usuario registrado con ese número de documento.";
            } else if (e.getMessage().contains("correo")) {
                return "Ya existe un usuario registrado con ese correo electrónico.";
            } else {
                return "El usuario ya existe en el sistema.";
            }
        }
            
            return "Error al agregar usuario: " + e.getMessage();
        } finally {
            Data.desconectar(conexion);
        }
    }
    

    public boolean verificarUsuario(String correo, String contrasena) {
        Connection conexion = Data.getConnection();
        String sql = "SELECT * FROM usuario WHERE correo = ? AND contrasena = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                
                UsuarioModel usuario = new UsuarioModel(
                rs.getString("numero_documento"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("correo"),
                rs.getString("contrasena"),
                rs.getString("telefono")
            );

            Models.SesionUsuario.setUsuarioActual(usuario);
                
                System.out.println("Usuario autenticado: " + usuario.getNombre());
                return true;
            } else {
                System.err.println("Usuario no encontrado.");
                return false;
            }
            
        } catch (SQLException e) {
            System.err.println("Error al verificar usuario: " + e.getMessage());
            return false;
        } finally {
            Data.desconectar(conexion);
        }
    }
    
    
    public List<UsuarioModel> listarUsuarios() {
        List<UsuarioModel> lista = new ArrayList<>();
        Connection conexion = Data.getConnection();
        String sql = "SELECT * FROM usuario";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                UsuarioModel usuario = new UsuarioModel(
                    rs.getString("numero_documento"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getString("contrasena"),
                    rs.getString("telefono")
                );
                lista.add(usuario);
            }
            
            System.out.println("Usuarios listados correctamente. Total: " + lista.size());
            
        } catch (SQLException e) {
            System.err.println("Error al listar usuarios: " + e.getMessage());
        } finally {
            Data.desconectar(conexion);
        }
        return lista;
    }
    
    private boolean CorreoValido(String correo) {
        if (correo == null) return false;
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return correo.matches(regex);
    }
    
    private boolean DocumentoValido(String numeroDocumento) {
        if (numeroDocumento == null) return false;
        return numeroDocumento.matches("\\d+");
    }
    
    public UsuarioModel obtenerUsuarioPorCorreo(String correo) {
        Connection conexion = Data.getConnection();
        UsuarioModel usuario = null;

        try {
            String sql = "SELECT * FROM usuario WHERE correo = ?";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new UsuarioModel(
                    rs.getString("numero_documento"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getString("contrasena"),
                    rs.getString("telefono")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener usuario por correo: " + e.getMessage());
        } finally {
            Data.desconectar(conexion);
        }

        return usuario;
    }
    
    public String generarContrasenaTemporal() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return sb.toString();
    }
    
    public boolean actualizarContrasena(String numeroDocumento, String nuevaContrasena) {
        Connection conexion = Data.getConnection();

        try {
            String sql = "UPDATE usuario SET contrasena = ? WHERE numero_documento = ?";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, nuevaContrasena);
            stmt.setString(2, numeroDocumento);
            int filas = stmt.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar contraseña: " + e.getMessage());
            return false;
        } finally {
            Data.desconectar(conexion);
        }
    }

}