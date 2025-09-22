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

        String sql = "INSERT INTO producto (id, nombre, cantidad, referencia, precio) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setInt(1, producto.getId());
            stmt.setString(2, producto.getNombre());
            stmt.setInt(3, producto.getCantidad());
            stmt.setString(4, producto.getReferencia());
            stmt.setDouble(5, producto.getPrecio());

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
        String sql = "SELECT * FROM producto";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                productos.add(new ProductosModel(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("cantidad"),
                    rs.getString("referencia"),
                    rs.getDouble("precio")

                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        } finally {
            Data.desconectar(conexion);
        }
        return productos;
    }
    
    public void actualizarProductos(ProductosModel producto){
    Connection conexion = Data.getConnection();
    String sql = "UPDATE producto SET nombre=?, cantidad=?, referencia=?, precio=? WHERE id=? ";
     try (PreparedStatement stmt = conexion.prepareStatement(sql)){           
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getCantidad());
            stmt.setString(3, producto.getReferencia());
            stmt.setDouble(4, producto.getPrecio());
            stmt.setInt(5, producto.getId());

            stmt.executeUpdate();
            System.out.println("Producto actualizado");

        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
        } finally {
            Data.desconectar(conexion);
        }
    }
}



