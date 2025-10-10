
package Views;

import Controllers.UsuarioController;
import Models.SesionUsuario;
import Models.UsuarioModel;
import javax.swing.JOptionPane;

public class JFCambiarContrasena extends javax.swing.JFrame {
    
    private JFPaginaPrincipal parentWindow;

    


    public JFCambiarContrasena() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
        public JFCambiarContrasena(JFPaginaPrincipal parent) {
        this();
        this.parentWindow = parent;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelActual = new javax.swing.JLabel();
        txtActual = new javax.swing.JPasswordField();
        jLabelNueva = new javax.swing.JLabel();
        txtNueva = new javax.swing.JPasswordField();
        jLabelConfirmar = new javax.swing.JLabel();
        txtConfirmar = new javax.swing.JPasswordField();
        jLabelVadake = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelActual.setText("Contraseña actual");

        txtActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActualActionPerformed(evt);
            }
        });

        jLabelNueva.setText("Contraseña nueva");

        jLabelConfirmar.setText("Confirmar contraseña");

        jLabelVadake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/imagenes/Logotipo2.png"))); // NOI18N

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar))
                            .addComponent(jLabelVadake, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNueva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtActual)
                            .addComponent(txtNueva)
                            .addComponent(txtConfirmar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabelConfirmar)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabelVadake, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelNueva)
                .addGap(26, 26, 26)
                .addComponent(txtNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelConfirmar)
                .addGap(12, 12, 12)
                .addComponent(txtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void txtActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActualActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String actual = new String(txtActual.getPassword());
        String nueva = new String(txtNueva.getPassword());
        String confirmar = new String(txtConfirmar.getPassword());

        UsuarioModel usuario = SesionUsuario.getUsuarioActual();

        if (usuario == null) {
            JOptionPane.showMessageDialog(this, "No hay usuario en sesión.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (actual.isEmpty() || nueva.isEmpty() || confirmar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!actual.equals(usuario.getContrasena())) {
            JOptionPane.showMessageDialog(this, "La contraseña actual es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!nueva.equals(confirmar)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas nuevas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UsuarioController controller = new UsuarioController();
        boolean actualizado = controller.actualizarContrasena(usuario.getNumeroDocumento(), nueva);

        if (actualizado) {
            usuario.setContrasena(nueva);
            JOptionPane.showMessageDialog(this, "Contraseña actualizada correctamente.");
            
            JFPaginaPrincipal principal = new JFPaginaPrincipal();
            principal.setVisible(true);
            principal.setLocationRelativeTo(null);


            this.dispose();
            
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
            this.dispose();
            if (parentWindow != null) {
            parentWindow.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new JFCambiarContrasena().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabelActual;
    private javax.swing.JLabel jLabelConfirmar;
    private javax.swing.JLabel jLabelNueva;
    private javax.swing.JLabel jLabelVadake;
    private javax.swing.JPasswordField txtActual;
    private javax.swing.JPasswordField txtConfirmar;
    private javax.swing.JPasswordField txtNueva;
    // End of variables declaration//GEN-END:variables
}
