package logica;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class imprimir {
    
    private Conexion con;

    public imprimir(Conexion con) {
        this.con = con;
    }
    
    public void imprimirReporte(String idpedido){
        Map p = new HashMap();
        String urlImagen = new File("").getAbsolutePath() + "/src/archivos/logo.png";
        p.put("idpedido", idpedido);
        p.put("rutaImagen", urlImagen);
        JasperReport report;
        JasperPrint print;
        
        try {

                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                            + "/src/reportes/reportComprobante.jrxml");
                print = JasperFillManager.fillReport(report, p, con.getLink());
                
                
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Comprobante");
                view.setVisible(true);
                //JasperPrintManager.printReport(print, true);
             

        } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error: " + e);
        }
    }
    
    public void imprimirReportesDia(String fecha){
        Map p = new HashMap();
        String urlImagen = new File("").getAbsolutePath() + "/src/archivos/logo.png";
        p.put("fecha", fecha);
        p.put("rutaImagen", urlImagen);
        JasperReport report;
        JasperPrint print;
      
        try {

                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                            + "/src/reportes/reportePorDia.jrxml");
                print = JasperFillManager.fillReport(report, p, con.getLink());
                
                
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Comprobante");
                view.setVisible(true);
                //JasperPrintManager.printReport(print, true);
             

        } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error: " + e);
        }
    }
    
}
