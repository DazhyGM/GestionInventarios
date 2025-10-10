
package Views;
import Controllers.ProductosController;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
public class JFInformes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFInformes.class.getName());
    private ProductosController productoController;
    
    public JFInformes() {
        initComponents();
        this.setLocationRelativeTo(null);
        
      productoController = new ProductosController();
      mostrarGrafica();
      VerGraficaTorta();
    }
    
    public void mostrarGrafica(){
    DefaultCategoryDataset dataset = productoController.ilustrarProductos();
    
    JFreeChart graficaBarras  = ChartFactory.createBarChart("Grafica de Cantidad Stock", "Nombre Productos","Stock Productos", 
    dataset
    );
    ChartPanel panelGrafica = new ChartPanel(graficaBarras);
    panelGrafica.setPreferredSize(new Dimension(500, 370));
    
        JpanelBarras.removeAll();
        JpanelBarras.setLayout(new BorderLayout());
        JpanelBarras.add(panelGrafica, BorderLayout.CENTER);
        JpanelBarras.validate();
        

        org.jfree.chart.plot.CategoryPlot plot = graficaBarras.getCategoryPlot();


        org.jfree.chart.axis.CategoryAxis axis = plot.getDomainAxis();


        axis.setMaximumCategoryLabelWidthRatio(1.0f);


        axis.setCategoryLabelPositions(
            org.jfree.chart.axis.CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );


plot.setDomainAxisLocation(org.jfree.chart.axis.AxisLocation.BOTTOM_OR_RIGHT);
graficaBarras.setPadding(new org.jfree.ui.RectangleInsets(10, 10, 50, 10));


    }
    
    public void VerGraficaTorta(){
    DefaultPieDataset dataset = productoController.mostrarEstados();
    
    JFreeChart graficaTorta  = ChartFactory.createPieChart("Inactivos/ Activos", dataset, true, true,false);
    
    ChartPanel panelTorta  = new ChartPanel(graficaTorta);
    panelTorta.setPreferredSize(new Dimension(500, 300));
    
    jpanelTorta.removeAll();
    jpanelTorta.setLayout(new BorderLayout());
    jpanelTorta.add(panelTorta, BorderLayout.CENTER);
    jpanelTorta.validate();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpanelBarras = new javax.swing.JPanel();
        jpanelTorta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Descargar = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JpanelBarras.setBackground(new java.awt.Color(255, 204, 153));

        javax.swing.GroupLayout JpanelBarrasLayout = new javax.swing.GroupLayout(JpanelBarras);
        JpanelBarras.setLayout(JpanelBarrasLayout);
        JpanelBarrasLayout.setHorizontalGroup(
            JpanelBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );
        JpanelBarrasLayout.setVerticalGroup(
            JpanelBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );

        jpanelTorta.setBackground(new java.awt.Color(255, 204, 153));

        javax.swing.GroupLayout jpanelTortaLayout = new javax.swing.GroupLayout(jpanelTorta);
        jpanelTorta.setLayout(jpanelTortaLayout);
        jpanelTortaLayout.setHorizontalGroup(
            jpanelTortaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpanelTortaLayout.setVerticalGroup(
            jpanelTortaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );

        jLabel1.setText("Apartado de informes ");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 18))); // NOI18N

        Descargar.setText("Descargar PDF");
        Descargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescargarActionPerformed(evt);
            }
        });

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.setFocusPainted(false);
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/imagenes/Logotipo2.png"))); // NOI18N

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTitulo.setText("Informes y Estadisticas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JpanelBarras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanelTorta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButtonRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(88, 88, 88)
                .addComponent(Descargar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelTitulo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(Descargar)
                    .addComponent(jButtonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpanelBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jpanelTorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescargarActionPerformed
        productoController.generarPdf();
    }//GEN-LAST:event_DescargarActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        JFPaginaPrincipal menu = new JFPaginaPrincipal();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new JFInformes().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Descargar;
    private javax.swing.JPanel JpanelBarras;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jpanelTorta;
    // End of variables declaration//GEN-END:variables
}
