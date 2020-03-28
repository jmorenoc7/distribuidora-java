
package logica;

import datos.Clientes;
import datos.DatosLogin;
import datos.Notas;
import datos.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class fUsuarios {
    DatosLogin dlogin = new DatosLogin();
    private Conexion mysql;
    private String codigoSql = "";
    private String codigoSql2 = "";

    public fUsuarios(Conexion mysql) {
        this.mysql = mysql;
    }
    
    public String[] buscarIdUsuario(String IdUsuario){
        codigoSql="SELECT personas.*, usuarios.* FROM personas INNER JOIN usuarios ON "
                + "personas.idpersona = usuarios.idusuario WHERE idpersona="+IdUsuario+"";
        
        
        String [] registros = new String[18];
        
        try {
            ResultSet rs = mysql.getConsulta().executeQuery(codigoSql);
            
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
                registros[14] = rs.getString("pass");
                registros[15] = rs.getString("presupuesto");
                registros[16] = rs.getString("puesto");
                registros[17] = rs.getString("estado");
                
            }
            
            return registros;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error\n" + "Error: " + e);
        }
        return null;
    }
    
    public DefaultTableModel mostrarUsuarios(String buscar, String filtro){
        
        DefaultTableModel tabla;
        
        String [] titulo = {"ID","Nombre","Dni","Domicilio 1","Domicilio 2"," Telefono 1"," Telefono 2",
            "Email 1","Email 2","Fecha","Usuario","Puesto","Presupuesto","Estado"};
        
        String [] registros = new String [14];
        
        tabla = new DefaultTableModel(null, titulo);
        
        codigoSql = "SELECT personas.*,usuarios.* FROM usuarios INNER JOIN personas ON"
                + " usuarios.idusuario=personas.idpersona WHERE "+ filtro +" LIKE '%" + buscar + "%'"
                + " ORDER BY idpersona DESC";
        
        try {
            ResultSet rs = mysql.getConsulta().executeQuery(codigoSql);
            
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
                registros[11] = rs.getString("puesto");
                registros[12] = rs.getString("presupuesto");
                registros[13] = rs.getString("estado");
                
                tabla.addRow(registros);
            }
            return tabla;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar tabla\n" + "Error: " + e);
            return null;
        }
    }
    
    public boolean login(String usuario, String pass){
        codigoSql ="SELECT usuarios.*, personas.nombre, personas.apellido FROM usuarios INNER JOIN personas ON "
                + "usuarios.idusuario=personas.idpersona WHERE usuarios.usuario ='"+ usuario +"' AND usuarios.pass ='"+ pass +"'";
        String [] registros = new String[7];
        
        try {
            ResultSet rs = mysql.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {
                registros[0] = rs.getString("idusuario");
                registros[1] = rs.getString("usuario");
                registros[2] = rs.getString("pass");
                registros[3] = rs.getString("puesto");
                registros[4] = rs.getString("presupuesto");
                registros[5] = rs.getString("estado");
                registros[6] = rs.getString("nombre") + " " +rs.getString("apellido");
            }
 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error: " + e );
        }
        if (registros[0] == null) {
            return false;
        }else{
            DatosLogin.setNusuario(Integer.parseInt(registros[0]));
            DatosLogin.setUsuario(registros[1]);
            DatosLogin.setPerfil(registros[3]);
            DatosLogin.setPresupuesto(Double.parseDouble(registros[4]));
            DatosLogin.setNombre(registros[6]);
            return true;
        }
        
        
    }
    
    public boolean verificarUsuario(String usuario){
       codigoSql = "SELECT usuario FROM usuarios WHERE usuario='"+usuario+"'";
       String [] registros = new String[1];
        try {
            ResultSet rs = mysql.getConsulta().executeQuery(codigoSql);
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
    
    public boolean insertar(Usuarios datos){
      mysql.conectar();
      Connection cn = mysql.getLink();
        
      codigoSql = "insert into personas(nombre,apellido,dni,domicilio1,ciudad1,"
              + "domicilio2, ciudad2, telefono1,telefono2,email1, email2,fechaIngreso) "
              + "values (?,?,?,?,?,?,?,?,?,?,?,NOW())";
      
      codigoSql2 = "insert into usuarios(idusuario,usuario,pass,puesto,presupuesto,estado) "
              + "values((select idpersona from personas order by idpersona desc limit 1),?,?,?,?,?)";
      
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
            pst2.setString(3, datos.getPuesto());
            pst2.setDouble(4,datos.getPresupuesto());
            pst2.setString(5, datos.getEstado());
            
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
    
    public boolean eliminar(Usuarios datos){
        
        //con.conectar();
        Connection cn = Conexion.getLink();
    
        codigoSql = "UPDATE usuarios set estado=? WHERE idusuarios=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            pst.setString(1, "Inactivo");
            pst.setInt(2, datos.getIdusuario());
            
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
    
    public boolean modificar(Usuarios datos){
        
        codigoSql = "UPDATE personas set nombre=?, apellido=?, dni=?, domicilio1=?"
                + ", ciudad1=?, domicilio2=?, ciudad2=?, telefono1=?, telefono2=?,"
                + " email1=?, email2=?, fechaIngreso=NOW() WHERE idpersona=?";
        
        codigoSql2 = "UPDATE usuarios set usuario=?, pass=?, puesto=?, "
                + "presupuesto=?, estado=? WHERE idusuario=?";
        
        try {
            PreparedStatement pst = mysql.getLink().prepareStatement(codigoSql);
            PreparedStatement pst2 = mysql.getLink().prepareStatement(codigoSql2);
            
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
            pst2.setString(2, datos.getPass());
            pst2.setString(3, datos.getPuesto());
            pst2.setDouble(4, datos.getPresupuesto());
            pst2.setString(5, datos.getEstado());
            pst2.setInt(6, datos.getIdpersona());
            
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
    
    public boolean insertarNota(Notas datos){
      mysql.conectar();
      Connection cn = mysql.getLink();
        
      codigoSql = "insert into notas(idpersona,nota,fecha) values (?,?,NOW())";
      
        try {
            
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            //aca obtenemos los valores de la clase Users extendida con la de personas
            pst.setInt(1, datos.getIdpersona());
            pst.setString(2, datos.getNota());
            
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
    
    public boolean modificarNota(Notas datos){
        
        codigoSql = "UPDATE notas set nota=?, fecha=NOW() WHERE idpersona=?";
        try {
            PreparedStatement pst = mysql.getLink().prepareStatement(codigoSql);
            
            pst.setString(1, datos.getNota());
            pst.setInt(2, datos.getIdpersona());
            
            int n = pst.executeUpdate();
            
            if (n != 0) {
                return true;
            }else{
                return false;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error\n" + "Error: " + e);
            return false;
        }
    }
    
    public String[] buscarNotaUsuario(String IdUsuario){
        codigoSql="SELECT * FROM notas WHERE idpersona="+IdUsuario+"";
        
        int contador = 0;
        
        String [] registros = new String[4];
        
        try {
            ResultSet rs = mysql.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {                
                registros[0] = rs.getString("idnota");
                registros[1] = rs.getString("idpersona");
                registros[2] = rs.getString("nota");  
                registros[3] = rs.getString("fecha");
                contador++;
                
            }
            if (contador==1) {
                return registros;
            }else{
                registros = null;
                return registros;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error\n" + "Error: " + e);
        }
        return null;
    }
}
