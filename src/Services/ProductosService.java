package Services;

import DB.Data;
import Models.ProductosModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductosService {

    public void agregarProductos(ProductosModel producto){
        Connection conexion = Data.getConnection();
        String sql = "INSERT INTO productos (nombre, descripcion, categoria, precio, stock, estado_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setString(3, producto.getCategoria());
            stmt.setDouble(4, producto.getPrecio());
            stmt.setInt(5, producto.getStock());
            stmt.setInt(6, producto.getEstadoId()); 

            stmt.executeUpdate();
            System.out.println("Producto agregado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al agregar el producto: " + e.getMessage());
        } finally {
            Data.desconectar(conexion);
        }
    }

    public List<ProductosModel> listarProductos() {
        List<ProductosModel> productos = new ArrayList<>();
        Connection conexion = Data.getConnection();
        String sql = "SELECT id, nombre, descripcion, categoria, precio, stock, estado_id FROM productos WHERE estado_id = 1"; 
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                productos.add(new ProductosModel(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("categoria"),
                    rs.getDouble("precio"),
                    rs.getInt("stock"),
                    rs.getInt("estado_id")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de listar productos: " + e.getMessage());
        } finally {
            Data.desconectar(conexion);
        }
        return productos;
    }
    
    public void actualizarProductos(ProductosModel producto){
        Connection conexion = Data.getConnection();
        
        String sql = "UPDATE productos SET nombre=?, descripcion=?, categoria=?, precio=?, stock=?, estado_id=? WHERE id=? ";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)){            
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setString(3, producto.getCategoria());
            stmt.setDouble(4, producto.getPrecio());
            stmt.setInt(5, producto.getStock());
            stmt.setInt(6, producto.getEstadoId());
            stmt.setInt(7, producto.getId());

            stmt.executeUpdate();
            System.out.println("Producto actualizado");

        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
        } finally {
            Data.desconectar(conexion);
        }
    }
    
    public ProductosModel detalleProducto(int id){
        Connection conexion = Data.getConnection();
        String sql = "SELECT id, nombre, descripcion, categoria, precio, stock, estado_id FROM productos WHERE id = ?"; 
        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    return new ProductosModel(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getInt("estado_id")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar detalle del producto: " + e.getMessage());
        } finally {
            Data.desconectar(conexion);
        }
        return null; 
    }

    public void eliminarProducto(int id){
        Connection conexion = Data.getConnection();
        String sql = "UPDATE productos SET estado_id = 2 WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setInt(1, id);
            
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Producto con ID " + id + " cambio a estado Inactivo.");
            } else {
                 System.out.println("No se encontró el producto con ID " + id + " para marcarlo como Inactivo.");
            }

        } catch (SQLException e) {
            System.out.println("Error al realizar la el cambio de estado del producto: " + e.getMessage());
        } finally {
            Data.desconectar(conexion);
        }
    }
}