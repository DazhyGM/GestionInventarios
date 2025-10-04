package Views;

import Controllers.ProductosController;
import Models.ProductosModel;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JFTablaProductos extends javax.swing.JFrame {

    private ProductosController controller;
    private DefaultTableModel tableModel;

    public JFTablaProductos() {
        initComponents();
        controller = new ProductosController();

        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nombre", "Descripción", "Categoría", "Precio", "Stock", "Modificar", "Eliminar", "Ver"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 6;
            }
        };
        TablaProductos.setModel(tableModel);

        for (int i = 6; i <= 8; i++) { 
            TablaProductos.getColumnModel().getColumn(i).setCellRenderer(new BotonRenderer());
            TablaProductos.getColumnModel().getColumn(i).setCellEditor(new BotonEditor());
        }

        cargarProductos();
    }

    public void cargarProductos() {
        tableModel.setRowCount(0);
        List<ProductosModel> productos = controller.listarProductos();
        for (ProductosModel p : productos) {
            tableModel.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                p.getDescripcion(),
                p.getCategoria(),
                p.getPrecio(),
                p.getStock(),
                "", "", ""
            });
        }
    }

    class BotonRenderer extends JButton implements TableCellRenderer {

        public BotonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            String texto = "";
            switch (column) {
                case 6:
                    texto = "Modificar";
                    break;
                case 7:
                    texto = "Eliminar";
                    break;
                case 8:
                    texto = "Ver";
                    break;
            }
            setText(texto);
            return this;
        }
    }

    class BotonEditor extends DefaultCellEditor {

        private JButton button;
        private int filaSeleccionada;
        private int columnaSeleccionada;

        public BotonEditor() {
            super(new JCheckBox());
            button = new JButton();
            button.addActionListener(e -> {
                fireEditingStopped();
                if (filaSeleccionada >= 0 && columnaSeleccionada >= 6 && columnaSeleccionada <= 8) {
                    int id = (int) tableModel.getValueAt(filaSeleccionada, 0);
                    switch (columnaSeleccionada) {
                        case 6:
                            int fila = TablaProductos.getSelectedRow();
                            if (fila != -1) {
                                new JFactualizarProductos(id, JFTablaProductos.this::cargarProductos).setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(JFTablaProductos.this, "Seleccione un producto primero");
                            }

                            break;
                        case 7:
                            String nombreProducto = (String) tableModel.getValueAt(filaSeleccionada, 1);       
                            int confirm = JOptionPane.showConfirmDialog(JFTablaProductos.this,
                                    "¿Está seguro de marcar el producto '" + nombreProducto + "' (ID: "+ id +") como INACTIVO?",
                                    "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                            

                            if (confirm == JOptionPane.YES_OPTION) {
                                controller.eliminarProducto(id);

                                JOptionPane.showMessageDialog(JFTablaProductos.this,
                                        "Producto  '" + nombreProducto + "' marcado como INACTIVO.");

                                cargarProductos();
                            }
                            break;
                        case 8:
                            new JFdetalleProducto(id).setVisible(true);
                            break;
                    }
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            filaSeleccionada = row;
            columnaSeleccionada = column;
            String texto = "";
            switch (column) {
                case 6:
                    texto = "Modificar";
                    break;
                case 7:
                    texto = "Eliminar";
                    break;
                case 8:
                    texto = "Ver";
                    break;
            }
            button.setText(texto);
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return "";
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        btnRegistar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/imagenes/Logotipo2.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Productos");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/imagenes/login1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        TablaProductos.setBackground(new java.awt.Color(204, 255, 255));
        TablaProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripción", "Categoria", "Precio", "Stock", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaProductos);

        btnRegistar.setText("Agregar");
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnRegresar)
                        .addGap(542, 542, 542)
                        .addComponent(btnRegistar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegistar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed

    JFRegistrarProductos registrar = new JFRegistrarProductos(this); 
    this.setVisible(false);

        registrar.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                cargarProductos();
            }
        });

        registrar.setVisible(true);
    }//GEN-LAST:event_btnRegistarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
         this.dispose(); 
    
    JFPaginaPrincipal menu = new JFPaginaPrincipal();
    
    menu.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new JFTablaProductos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProductos;
    private javax.swing.JButton btnRegistar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
