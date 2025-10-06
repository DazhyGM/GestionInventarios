package Services;

import DB.Data;
import Models.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            return "Usuario agregado correctamente.";
            
        } catch (SQLException e) {
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
                System.out.println("Usuario encontrado: " + rs.getString("nombre"));
                return true;
            } else {
                System.out.println("Usuario no encontrado.");
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al verificar usuario: " + e.getMessage());
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
            System.out.println("Error al listar usuarios: " + e.getMessage());
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

}