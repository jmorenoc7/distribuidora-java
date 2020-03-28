
package logica;

import datos.Clientes;
import datos.DatosLogin;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class fClientes {
    DatosLogin dlogin = new DatosLogin();
    private Conexion con = new Conexion();
    private String codigoSql = "";
    private String codigoSql2 = "";

    public fClientes(Conexion con) {
        this.con = con;
        /*JOptionPane.showMessageDialog(null, "1 - " + con.getDb() + "reoooooooo\n"
                                          + "2 - " + con.getServidor() + "\n"
                                          + "3 - " + con.getUrl() + "\n"
                                          + "4 - " + con.getPass() + "\n"
                                          + "5 - " + con.getUser()+ "\n"
                                          + "6 - " + con.getConsulta()+ "\n"
                                          + "7 - " + con.getLink()+ "\n");*/
        //JOptionPane.showMessageDialog(null, dlogin.getDb() + "\n" + dlogin.getServidor());
    }
    
    public String[] buscarIdCliente(String IdCliente){
        codigoSql="SELECT personas.*, clientes.* FROM personas INNER JOIN clientes ON "
                + "personas.idpersona = clientes.idcliente WHERE idpersona="+IdCliente+"";
        
        
        String [] registros = new String[16];
        
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {                
                registros[0] = rs.getString("idpersona");
                registros[1] = rs.getString("apellido");
                registros[2] = rs.getString("nombre");  
                registros[3] = rs.getString("dni");
                registros[4] = rs.getString("domicilio1");
                registros[5] = rs.getString("ciudad1");
                registros[6] = rs.getString("domicilio2");
                registros[7] = rs.getString("ciudad2");
                registros[8] = rs.getString("telefono1");
                registros[9] = rs.getString("telefono2");
                registros[10] = rs.getString("email1");
                registros[11] = rs.getString("email2");
                registros[12] = rs.getString("fechaIngreso");
                registros[13] = rs.getString("usuario");
                registros[14] = rs.getString("tipoUsuario");
                registros[15] = rs.getString("estado");
                
            }
            
            return registros;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error\n" + "Error: " + e);
        }
        return null;
    }
    
    public DefaultTableModel mostrarClientesPedido(String buscar, String filtro){
        //con.conectar();
        DefaultTableModel tabla;
        
        String [] titulo = {"ID","Nombre","Dni","Domicilio 1"," Telefono 1",
            "Email 1","Tipo"};
        
        String [] registros = new String [7];
        
        tabla = new DefaultTableModel(null, titulo);
        
        codigoSql = "SELECT personas.*,clientes.* FROM clientes INNER JOIN personas ON"
                + " clientes.idcliente=personas.idpersona WHERE "+ filtro +" LIKE '%" + buscar + "%'"
                + " AND estado='Activo' ORDER BY idpersona DESC";
        
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {  
                
                registros[0] = rs.getString("idpersona");
                registros[1] = rs.getString("apellido") + " " + rs.getString("nombre") ;
                registros[2] = rs.getString("dni");
                registros[3] = rs.getString("domicilio1") + ", " + rs.getString("ciudad1");
                registros[4] = rs.getString("telefono1");
                registros[5] = rs.getString("email1");
                registros[6] = rs.getString("tipoUsuario");
                
                tabla.addRow(registros);
            }
            return tabla;
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar tabla\n" + "Error: " + e);
            return null;
        }
    }
    
    public DefaultTableModel mostrarClientes(String buscar, String filtro, String filtro2){
        //con.conectar();
        DefaultTableModel tabla;
        
        String [] titulo = {"ID","Nombre","Dni","Domicilio 1","Domicilio 2"," Telefono 1"," Telefono 2",
            "Email 1","Email 2","Fecha","Usuario","Tipo","Estado"};
        
        String [] registros = new String [13];
        
        tabla = new DefaultTableModel(null, titulo);
        
        codigoSql = "SELECT personas.*,clientes.* FROM clientes INNER JOIN personas ON"
                + " clientes.idcliente=personas.idpersona WHERE "+ filtro +" LIKE '%" + buscar + "%'"
                + " AND estado='"+ filtro2 +"'ORDER BY idpersona DESC";
        
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {  
                registros[0] = rs.getString("idpersona");
                registros[1] = rs.getString("apellido") + " " + rs.getString("nombre") ;
                registros[2] = rs.getString("dni");
                registros[3] = rs.getString("domicilio1") + ", " + rs.getString("ciudad1");
                registros[4] = rs.getString("domicilio2") + ", " + rs.getString("ciudad2");
                registros[5] = rs.getString("telefono1");
                registros[6] = rs.getString("telefono2");
                registros[7] = rs.getString("email1");
                registros[8] = rs.getString("email2");
                registros[9] = rs.getString("fechaIngreso");
                registros[10] = rs.getString("usuario");
                registros[11] = rs.getString("tipoUsuario");
                registros[12] = rs.getString("estado");
                
                tabla.addRow(registros);
            }
            return tabla;
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar tabla\n" + "Error: " + e);
            return null;
        }
    }
    
    public boolean verificarUsuario(String usuario){
       
       codigoSql = "SELECT usuario FROM clientes WHERE usuario='"+usuario+"'";
       String [] registros = new String[1];
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            while (rs.next()) {                
                registros[0] = rs.getString("usuario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema, cierre la ventana y vuelva a iniciar\n" + e);
            return true;
        }
        if (registros[0]!=null) {
            return true;
        }else{
            return false;
        }
    }
    
    public boolean insertar(Clientes datos){
      con.conectar();
      Connection cn = con.getLink();
        
      codigoSql = "insert into personas(nombre,apellido,dni,domicilio1,ciudad1,"
              + "domicilio2, ciudad2, telefono1,telefono2,email1, email2,fechaIngreso) "
              + "values (?,?,?,?,?,?,?,?,?,?,?,NOW())";
      
      codigoSql2 = "insert into clientes(idcliente,usuario,pass,tipoUsuario,estado) "
              + "values((select idpersona from personas order by idpersona desc limit 1),?,?,?,?)";
      
        try {
            
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            PreparedStatement pst2 = cn.prepareStatement(codigoSql2);
            
            //aca obtenemos los valores de la clase Users extendida con la de personas
            pst.setString(1, datos.getNombre());
            pst.setString(2, datos.getApellido());
            pst.setString(3, datos.getDni());
            pst.setString(4, datos.getDomicilio1());
            pst.setString(5, datos.getCiudad1());
            pst.setString(6, datos.getDomicilio2());
            pst.setString(7, datos.getCiudad2());
            pst.setString(8, datos.getTelefono1());
            pst.setString(9, datos.getTelefono2());
            pst.setString(10, datos.getEmail1());
            pst.setString(11, datos.getEmail2());
            
            pst2.setString(1, datos.getUsuario());
            pst2.setString(2, datos.getPass());
            pst2.setString(3, datos.getTipoUsuario());
            pst2.setString(4, datos.getEstado());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                
                if (n2 != 0) {
                    return true;
                    
                }else{
                    return false;
                }
            }else{
              return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null," No se pudo crear el usuario // " + e);
            return false;
        }
    }
    
    public boolean eliminar(Clientes datos){
        
        //con.conectar();
        Connection cn = Conexion.getLink();
    
        codigoSql = "UPDATE clientes set estado=? WHERE idcliente=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            pst.setString(1, "Inactivo");
            pst.setInt(2, datos.getIdcliente());
            
            int n = pst.executeUpdate();
            
            if (n!=0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Hubo un error al eliminar cliente, cierre la ventana e intente nuevamente\n" + "Error: " + e);
            return false;
        }
    }
    
    public boolean modificar(Clientes datos){
        
        codigoSql = "UPDATE personas set nombre=?, apellido=?, dni=?, domicilio1=?"
                + ", ciudad1=?, domicilio2=?, ciudad2=?, telefono1=?, telefono2=?,"
                + " email1=?, email2=?, fechaIngreso=NOW() WHERE idpersona=?";
        
        codigoSql2 = "UPDATE clientes set usuario=?, tipoUsuario=?, estado=? WHERE idcliente=?";
        
        try {
            PreparedStatement pst = con.getLink().prepareStatement(codigoSql);
            PreparedStatement pst2 = con.getLink().prepareStatement(codigoSql2);
            
            pst.setString(1, datos.getNombre());
            pst.setString(2, datos.getApellido());
            pst.setString(3, datos.getDni());
            pst.setString(4, datos.getDomicilio1());
            pst.setString(5, datos.getCiudad1());
            pst.setString(6, datos.getDomicilio2());
            pst.setString(7, datos.getCiudad2());
            pst.setString(8, datos.getTelefono1());
            pst.setString(9, datos.getTelefono2());
            pst.setString(10, datos.getEmail1());
            pst.setString(11, datos.getEmail2());
            pst.setInt(12, datos.getIdpersona());
            
            pst2.setString(1, datos.getUsuario());
            pst2.setString(2, datos.getTipoUsuario());
            pst2.setString(3, datos.getEstado());
            pst2.setInt(4, datos.getIdpersona());
            
            int n = pst.executeUpdate();
            
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error\n" + "Error: " + e);
            return false;
        }
    }
    
}
