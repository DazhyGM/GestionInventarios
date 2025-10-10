
package Views;

import Controllers.EnvioCorreoController;
import Models.ProductosModel;
import Services.ProductosService;
import java.util.List;
import javax.swing.JOptionPane;


public class JFVentas extends javax.swing.JFrame {

    
    public JFVentas() {
        initComponents();
        cargarProductos();
        this.setLocationRelativeTo(null);
    }
    
    private List<ProductosModel> productos;
    
    private void cargarProductos() {
    Productos.removeAllItems();
    Productos.addItem("Seleccione un producto");

    ProductosService service = new ProductosService();
    productos = service.obtenerProductosActivos();

    for (ProductosModel p : productos) {
        Productos.addItem(p.getNombre());
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Productos = new javax.swing.JComboBox<>();
        jTextCantidad = new javax.swing.JTextField();
        jButtonVenta = new javax.swing.JButton();
        jLabelCantidad = new javax.swing.JLabel();
        JlabelProducto = new javax.swing.JLabel();
        jButtonRegresar = new javax.swing.JButton();
        jLabelVadake = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCantidadActionPerformed(evt);
            }
        });

        jButtonVenta.setText("Vender");
        jButtonVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVentaActionPerformed(evt);
            }
        });

        jLabelCantidad.setText("Cantidad");

        JlabelProducto.setText("Producto");

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.setFocusPainted(false);
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });

        jLabelVadake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/imagenes/Logotipo2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonRegresar)
                        .addGap(91, 91, 91)
                        .addComponent(jButtonVenta))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelVadake, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Productos, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JlabelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabelVadake, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JlabelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Productos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButtonVenta)
                        .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRegresar)
                        .addGap(17, 17, 17))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVentaActionPerformed
                                                                         
        String seleccionado = (String) Productos.getSelectedItem();
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
        int stockRestante = service.descontarStockYObtener(idProducto, cantidad);

        if (stockRestante >= 0) {
            JOptionPane.showMessageDialog(this, "Venta realizada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            jTextCantidad.setText("");
            Productos.setSelectedIndex(0);
            cargarProductos();

            if (stockRestante <= 3) {
                EnvioCorreoController correoController;
                correoController = new EnvioCorreoController();
                correoController.enviarAlertaStock(seleccionado, stockRestante);
            }

        } else {
            JOptionPane.showMessageDialog(this, "No hay suficiente stock.", "Error", JOptionPane.WARNING_MESSAGE);
        }

 
   
    }//GEN-LAST:event_jButtonVentaActionPerformed

    private void jTextCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCantidadActionPerformed
        
    }//GEN-LAST:event_jTextCantidadActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        JFStock stock = new JFStock();
        stock.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new JFVentas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlabelProducto;
    private javax.swing.JComboBox<String> Productos;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JButton jButtonVenta;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelVadake;
    private javax.swing.JTextField jTextCantidad;
    // End of variables declaration//GEN-END:variables

}
