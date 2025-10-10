package Controllers;

import Models.ProductosModel;
import Services.ProductosService;
import java.util.List;
import javax.swing.JComboBox;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import org.jfree.chart.ChartUtilities;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ProductosController {
    private ProductosService productoService;
    
    public ProductosController() {
        this.productoService = new ProductosService();
    }

    public void agregarProductos(String nombre, String descripcion, String categoria,double precio, int stock) {
        ProductosModel producto = new ProductosModel(0, nombre, descripcion, categoria, precio, stock);
        productoService.agregarProductos(producto);
    }

    public void modificarProductos(int id, String nombre, String descripcion, String categoria,double precio, int stock){

        ProductosModel productoExistente = productoService.detalleProducto(id);
        
        if (productoExistente != null) {
            productoExistente.setNombre(nombre);
            productoExistente.setDescripcion(descripcion);
            productoExistente.setCategoria(categoria);
            productoExistente.setPrecio(precio);
            productoExistente.setStock(stock);
            
            if (stock > 0 && productoExistente.getEstadoId() == 3) {
                 productoExistente.setEstadoId(1); 
            }
            
            productoService.actualizarProductos(productoExistente);
        }
    }
    
    
    public ProductosModel verProducto(int id){
        return productoService.detalleProducto(id);
    }


    public List<ProductosModel> listarProductos() {
        return productoService.listarProductos();
    }
    
    public void eliminarProducto(int id) {
        productoService.eliminarProducto(id);
    }
    
    public DefaultCategoryDataset ilustrarProductos() {
        return productoService.graficarProductos();
    }
    
    public DefaultPieDataset mostrarEstados(){
    return productoService.GraficarEstados();
    }
    
    
    
    public JFreeChart crearPdfBarras(){
    DefaultCategoryDataset dataset = ilustrarProductos();
    JFreeChart pdfB = ChartFactory.createBarChart(
                "Cantidad de Stock por Producto",
                "Productos", "Stock", dataset);
        pdfB.setBackgroundPaint(Color.white);
        pdfB.getTitle().setPaint(new Color(40, 40, 40));
        return pdfB;
    }
    
    
    public JFreeChart crearPdfTorta() {
        DefaultPieDataset dataset = mostrarEstados();
        JFreeChart pdfT = ChartFactory.createPieChart(
                "Estados de los Productos (Activos/Inactivos)",
                dataset, true, true, false);
        pdfT.setBackgroundPaint(Color.white);
        pdfT.getTitle().setPaint(new Color(40, 40, 40));
        return pdfT;
    }
    
    
    public void generarPdf(){
    try {
        String fecha = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        JFreeChart graficaBarras = crearPdfBarras();
        JFreeChart graficaTorta = crearPdfTorta();
        
        String rutaDescargas = System.getProperty("user.home") + "/Downloads/Reporte_Graficas_" + fecha + ".pdf";
        File archivoPDF = new File(rutaDescargas);
        
        Document pdf = new Document();
        PdfWriter.getInstance(pdf, new FileOutputStream(archivoPDF));
        pdf.open();

        pdf.open();

        pdf.add(new Paragraph("Reporte de Gráficas de Productos\n\n",
        new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD)));
        pdf.add(new Paragraph("Fecha de generación: " + fecha + "\n\n"));


        ByteArrayOutputStream imagen1 = new ByteArrayOutputStream();
        ChartUtilities.writeChartAsPNG(imagen1, graficaBarras, 500, 300);
        Image chart1 = Image.getInstance(imagen1.toByteArray());
        
        pdf.add(new Paragraph("Gráfica de Cantidad de Stock por Producto:\n\n"));
        chart1.scaleToFit(400, 300);
        pdf.add(chart1);
        pdf.add(new Paragraph("\n\n"));


        ByteArrayOutputStream imagen2 = new ByteArrayOutputStream();
        ChartUtilities.writeChartAsPNG(imagen2, graficaTorta, 350, 300);
        Image chart2 = Image.getInstance(imagen2.toByteArray());
        
        pdf.add(new Paragraph("Gráfica de Estados de los Productos:\n\n"));
        chart2.scaleToFit(500, 300);
        pdf.add(chart2);
        pdf.close();
              
        System.out.println("PDF generado correctamente.");
                
                if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archivoPDF);
            }

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}