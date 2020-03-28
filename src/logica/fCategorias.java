package logica;

import datos.Categorias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fCategorias {
    private Conexion con = new Conexion();
    private String codigoSql = "";
    
    public fCategorias(Conexion con){
        this.con = con;
    }
    
    public ArrayList<String> listaCat(){
        codigoSql = "SELECT nombre_cat FROM categorias";
        ArrayList<String> lista = new ArrayList<String>();
        String tmp;
        
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {                
                tmp = rs.getString("nombre_cat");
                lista.add(tmp);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al traer las categorias\nError: "+ e);
            return null;
        }
    
    }
    
    public String buscarIdCat(String cat){
        codigoSql="SELECT categorias.idcategoria FROM categorias WHERE nombre_cat='"+cat+"'";
        String id = null;
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {                
                id = rs.getString("idcategoria");
            }
            return id;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error con el id de la categoria\n Error: " + e);
            return "";
        }
    }
    
    public DefaultTableModel mostrarCategorias(String buscar){
        DefaultTableModel tabla;
        
        String [] titulo = {"Id", "Nombre", "Descripcion", "Estado"};
        
        String [] registros = new String [4];
        
        tabla = new DefaultTableModel(null, titulo);
        
        codigoSql = "SELECT * FROM categorias WHERE nombre_cat LIKE '%"+buscar+"%' ";
        
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {                
                registros[0] = rs.getString("idcategoria");
                registros[1] = rs.getString("nombre_cat");
                registros[2] = rs.getString("descripcion_cat");
                registros[3] = rs.getString("estado");
                
                tabla.addRow(registros);
            }
            return tabla;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error\n" + "Error: " + e);
            return null;
        }
    
    }
    
    public boolean insertar(Categorias datos){
      con.conectar();
      Connection cn = con.getLink();
        
      codigoSql = "INSERT INTO categorias(nombre_cat,descripcion_cat,estado) "
              + "VALUES (?,?,?)";
      
      
        try {
            
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            //aca obtenemos los valores de la clase Users extendida con la de personas
            pst.setString(1, datos.getNombre_cat());
            pst.setString(2, datos.getDescripcion_cat());
            pst.setString(3, datos.getEstado());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null," No se pudo crear el usuario // " + e);
            return false;
        }
    }
    
    public boolean modificar(Categorias datos){
        
        //con.conectar();
        Connection cn = Conexion.getLink();
    
        codigoSql = "UPDATE categorias set nombre_cat=? , descripcion_cat=?, "
                + "estado=? WHERE idcategoria=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            pst.setString(1, datos.getNombre_cat());
            pst.setString(2, datos.getDescripcion_cat());
            pst.setString(3, datos.getEstado());
            pst.setInt(4, datos.getIdcategoria());
            
            int n = pst.executeUpdate();
            
            if (n!=0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Hubo un error al modificar la Categoria, \n cierre la ventana e intente nuevamente\n" + "Error: " + e);
            return false;
        }
    }
    
}
