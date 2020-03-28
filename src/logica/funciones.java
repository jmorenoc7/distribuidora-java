
package logica;

import datos.Modificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class funciones {
    private Conexion con;
    private String codigoSql = "";
    
    public funciones(Conexion con){
        this.con = con;
    }
    
    public DefaultTableModel mostrarProductos(String buscar, String filtro){
        DefaultTableModel tabla;
        
        String [] titulo = {"Id","Id Reg Tabla","Tabla","Fecha","Usuario"};
        
        String [] registros = new String [5];
        
        tabla =  new DefaultTableModel(null, titulo);
        
        codigoSql = "SELECT * FROM modificaciones"
                + " WHERE "+filtro+" LIKE '%"+buscar+"%' ORDER BY idmodificacion DESC";
        
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {                
                registros[0] = rs.getString("idmodificacion");
                registros[1] = rs.getString("idregTabla");
                registros[2] = rs.getString("tabla");
                registros[3] = rs.getString("fechaMod");
                registros[4] = rs.getString("usuario");
                
                tabla.addRow(registros);
            }
            return tabla;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar las modificaciones\nError: "+ e);
            return null;
        }
    }
    
    public boolean insertar(Modificaciones datos){
        //con.conectar();
        Connection cn = con.getLink();
        codigoSql = "INSERT INTO modificaciones(idregTabla,tabla,fechaMod,usuario)"
                + " VALUES(?,?,NOW(),?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            pst.setInt(1, datos.getIdregTabla());
            pst.setString(2, datos.getTabla());
            pst.setString(3, datos.getUsuario());
            
            int n = pst.executeUpdate();
            
            if(n!=0) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Hubo un error\n Error:" + e);
            return false;
        }
    }
}
