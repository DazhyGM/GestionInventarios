package Views;
import Controllers.ProductosController;
import javax.swing.JOptionPane;
import java.util.List;     
import Models.ProductosModel; 

public class JFactualizarProductos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFactualizarProductos.class.getName());
    private ProductosController modificarProductos;
    private int idProducto;
    private Runnable onProductoActualizado;

   public JFactualizarProductos(int id, Runnable onProductoActualizado) {
    initComponents();
    this.idProducto = id;
    this.modificarProductos = new ProductosController();
    this.onProductoActualizado = onProductoActualizado;
    System.out.println("Abriendo JFactualizarProductos con id = " + idProducto);
    cargarDatosProducto();
}


private void cargarDatosProducto() {
    List<ProductosModel> todosProductos = modificarProductos.listarProductos();
    ProductosModel productoEncontrado = null;

    for (ProductosModel p : todosProductos) {
        if (p.getId() == idProducto) {
            productoEncontrado = p;
            break;
        }
    }

    if (productoEncontrado != null) {
 
        textID.setText(String.valueOf(productoEncontrado.getId()));
        textID.setEditable(false);
        textNombre.setText(productoEncontrado.getNombre());
        textDescripcion.setText(productoEncontrado.getDescripcion());
        textPrecio.setText(String.valueOf(productoEncontrado.getPrecio()));
        textStock.setText(String.valueOf(productoEncontrado.getStock()));
        comboCategorias.setSelectedItem(productoEncontrado.getCategoria());
    } else {
        JOptionPane.showMessageDialog(this, "Producto no encontrado");
        this.dispose();

    }

   
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        comboCategorias = new javax.swing.JComboBox<>();
        textID = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        textDescripcion = new javax.swing.JTextField();
        textPrecio = new javax.swing.JTextField();
        textStock = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modificar Producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        comboCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Tablets", "Portatil", "Celulares", "Computador escritorio" }));
        comboCategorias.setBorder(javax.swing.BorderFactory.createTitledBorder("Categorias"));

        textID.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12))); // NOI18N
        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
            }
        });

        textNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12))); // NOI18N
        textNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreActionPerformed(evt);
            }
        });

        textDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12))); // NOI18N
        textDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDescripcionActionPerformed(evt);
            }
        });

        textPrecio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12))); // NOI18N
        textPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPrecioActionPerformed(evt);
            }
        });

        textStock.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stock", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12))); // NOI18N
        textStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 105, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(textStock, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/imagenes/Logotipo2.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Modificar Producto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleName("Acyualizar Productos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textStockActionPerformed

    private void textPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPrecioActionPerformed

    private void textDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDescripcionActionPerformed

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombre = textNombre.getText();
        String descripcion = textDescripcion.getText();
        String categoria = (String) comboCategorias.getSelectedItem();
        String precioStr = textPrecio.getText().trim();      
        String stockStr = textStock.getText().trim();
        if (nombre.isEmpty() || descripcion.isEmpty() || categoria.isEmpty() || precioStr.isEmpty() || stockStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            double precio = Double.parseDouble(precioStr);
            int stock = Integer.parseInt(stockStr);

            modificarProductos.modificarProductos(idProducto, nombre, descripcion, categoria,precio, stock);

            JOptionPane.showMessageDialog(this, "Producto actualizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            if (onProductoActualizado != null) {
                onProductoActualizado.run();
            }
            this.dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, ""
                    + "Precio y Stock deben ser números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCategorias;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField textDescripcion;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPrecio;
    private javax.swing.JTextField textStock;
    // End of variables declaration//GEN-END:variables
}
