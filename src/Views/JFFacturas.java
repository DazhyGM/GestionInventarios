
package Views;

import Models.ProductosModel;
import Services.ProductosService;
import java.util.List;
import javax.swing.JOptionPane;


public class JFFacturas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFFacturas.class.getName());

    
    public JFFacturas() {
       initComponents();
        cargarProductos();
        this.setLocationRelativeTo(null);
    }
    
    private List<ProductosModel> productos;
    
    private void cargarProductos() {
    IngresoProductos.removeAllItems();
    IngresoProductos.addItem("Seleccione un producto");

    ProductosService service = new ProductosService();
    productos = service.obtenerProductosActivos();

    for (ProductosModel p : productos) {
        IngresoProductos.addItem(p.getNombre());
    } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IngresoProductos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextCantidad = new javax.swing.JTextField();
        jButtonIngreso = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IngresoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresoProductosActionPerformed(evt);
            }
        });

        jLabel1.setText("Productos");

        jLabel2.setText("Cantidad");

        jTextCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCantidadActionPerformed(evt);
            }
        });

        jButtonIngreso.setText("Ingresar Factura");
        jButtonIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresoActionPerformed(evt);
            }
        });

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.setFocusPainted(false);
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IngresoProductos, 0, 179, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCantidad)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jButtonIngreso)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IngresoProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButtonIngreso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButtonRegresar)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
       JFStock stock = new JFStock();
        stock.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void IngresoProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresoProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresoProductosActionPerformed

    private void jTextCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCantidadActionPerformed

    }//GEN-LAST:event_jTextCantidadActionPerformed

    private void jButtonIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresoActionPerformed
     String seleccionado = (String) IngresoProductos.getSelectedItem();
    if (seleccionado == null || seleccionado.equals("Seleccione un producto")) {
        JOptionPane.showMessageDialog(this, "Seleccione un producto válido.", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int cantidad;
    try {
        cantidad = Integer.parseInt(jTextCantidad.getText());
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Ingrese un número válido en cantidad.", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    int idProducto = -1;
    for (ProductosModel p : productos) {
        if (p.getNombre().equals(seleccionado)) {
            idProducto = p.getId();
            break;
        }
    }

    if (idProducto == -1) {
        JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    ProductosService service = new ProductosService();
    boolean exito = service.ingresarStock(idProducto, cantidad);

    if (exito) {
        JOptionPane.showMessageDialog(this, "Stock ingresado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        jTextCantidad.setText("");   
        IngresoProductos.setSelectedIndex(0);    
        cargarProductos();           
    } else {
        JOptionPane.showMessageDialog(this, "Error al ingresar stock.", "Error", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_jButtonIngresoActionPerformed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new JFFacturas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> IngresoProductos;
    private javax.swing.JButton jButtonIngreso;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextCantidad;
    // End of variables declaration//GEN-END:variables

}
