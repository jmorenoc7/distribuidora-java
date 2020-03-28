package logica;

import datos.Items;
import datos.ItemsPP;
import datos.Pedidos;
import datos.PedidosProv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fPedidoProv {
    private Conexion con;
    private String codigoSql = "";
    
    public fPedidoProv(Conexion con){
        this.con=con;
    }
    
    public String buscarId(){
        codigoSql="SELECT idpedidosProv FROM pedidosprov ORDER BY idpedidosProv DESC LIMIT 1";
        
        
        String idpedido = "";
        
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {                
                idpedido = rs.getString("idpedidosProv");
                
            }
            
            return idpedido;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error\n" + "Error: " + e);
        }
        return null;
    }
    
    public String[] buscarIdPedido(String IdPedido){
        
        codigoSql="SELECT pedidosprov.*,personas.* FROM pedidosprov INNER JOIN personas ON "
                + "pedidosprov.idpersonaProv = personas.idpersona WHERE idpedidosProv="+IdPedido+"";
        
        
        String [] registros = new String[9];
        
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {   
                
                registros[0] = rs.getString("idpedidosProv");
                registros[1] = rs.getString("idpersonaProv");
                registros[2] = rs.getString("nombre") + " " + rs.getString("apellido"); 
                registros[3] = rs.getString("domicilio1") + " " + rs.getString("ciudad1");
                registros[4] = rs.getString("idpersonaUsuario");
                registros[5] = rs.getString("codigo");
                registros[6] = rs.getString("fecha");
                registros[7] = rs.getString("total");
                registros[8] = rs.getString("estado");
                
            }
            
            return registros;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error\n" + "Error: " + e);
        }
        return null;
    }
    
    public DefaultTableModel mostrarPedidos(String buscar, String filtro){
        DefaultTableModel tabla;
        
        String [] titulo = {"Id","IdProv","Proveedor","IdUsuario","Usuario",
                            "Codigo","Fecha","Total","Estado"};
        
        String [] registros = new String [9];
        
        tabla =  new DefaultTableModel(null, titulo);
        
        codigoSql = "SELECT pedidosprov.*, personas.*, usuarios.* FROM pedidosprov INNER JOIN personas ON"
                + " pedidosprov.idpersonaProv=personas.idpersona INNER JOIN usuarios ON pedidosprov.idpersonaUsuario=usuarios.idusuario"
                + " WHERE "+filtro+" LIKE '%"+buscar+"%' ORDER BY idpedidosProv DESC";
        
        try {
            
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {          
                
                registros[0] = rs.getString("idpedidosProv");
                registros[1] = rs.getString("idpersonaProv");
                registros[2] = rs.getString("nombre") + " " + rs.getString("apellido");
                registros[3] = rs.getString("idpersonaUsuario");
                registros[4] = rs.getString("usuario");
                registros[5] = rs.getString("codigo");
                registros[6] = rs.getString("fecha");
                registros[7] = rs.getString("total");
                registros[8] = rs.getString("estado");
                
                tabla.addRow(registros);
            }
            return tabla;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar los pedidos\nError: "+ e);
            return null;
        }
    }
    
    public DefaultTableModel mostrarPedidosMes(String buscar){
        DefaultTableModel tabla;
        
        String [] titulo = {"Id","IdProv","Proveedor","IdUsuario","Usuario",
                            "Codigo","Fecha","Total","Estado"};
        
        String [] registros = new String [9];
        
        tabla =  new DefaultTableModel(null, titulo);
        
        codigoSql = "SELECT pedidosprov.*, personas.*, usuarios.* FROM pedidosprov INNER JOIN personas ON"
                + " pedidosprov.idpersonaProv=personas.idpersona INNER JOIN usuarios ON pedidosprov.idpersonaUsuario=usuarios.idusuario"
                + " WHERE MONTH(pedidosprov.fecha)= "+buscar+" ORDER BY idpedidosProv DESC";
        
        try {
            
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {          
                
                registros[0] = rs.getString("idpedidosProv");
                registros[1] = rs.getString("idpersonaProv");
                registros[2] = rs.getString("nombre") + " " + rs.getString("apellido");
                registros[3] = rs.getString("idpersonaUsuario");
                registros[4] = rs.getString("usuario");
                registros[5] = rs.getString("codigo");
                registros[6] = rs.getString("fecha");
                registros[7] = rs.getString("total");
                registros[8] = rs.getString("estado");
                
                tabla.addRow(registros);
            }
            return tabla;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar los pedidos\nError: "+ e);
            return null;
        }
    }
    
    public boolean insertar(PedidosProv datos){
      con.conectar();
      Connection cn = con.getLink();
        
      codigoSql = "INSERT INTO pedidosprov(idpersonaProv,idpersonaUsuario,codigo,fecha,"
              + "total,estado) VALUES(?,?,?,NOW(),?,?)";
      
      
        try {
            
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            //aca obtenemos los valores de la clase Users extendida con la de personas
            pst.setInt(1, datos.getIdprov());
            pst.setInt(2, datos.getIdusuario());
            pst.setString(3, datos.getCodigo());
            pst.setDouble(4, datos.getTotal());
            pst.setString(5, datos.getEstado());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null," No se pudo crear el Pedido // " + e);
            return false;
        }
    }
    
    public boolean modificar(PedidosProv datos){
      con.conectar();
      Connection cn = con.getLink();
      
      codigoSql = "UPDATE pedidosprov set idpersonaProv=?, idpersonaUsuario=?, codigo=?, "
              + "fecha=NOW(), total=?, estado=? WHERE idpedidosProv=?";
      
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            pst.setInt(1, datos.getIdprov());
            pst.setInt(2, datos.getIdusuario());
            pst.setString(3, datos.getCodigo());
            pst.setDouble(4, datos.getTotal());
            pst.setString(5, datos.getEstado());
            pst.setInt(6, datos.getIdpedidoProv());
            
            int n = pst.executeUpdate();
            
            if (n != 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Hubo un error\n Error: "+ e);
            return false;
        }
    }
    
    public boolean eliminarPedido(PedidosProv datos){
        con.conectar();
        Connection cn = con.getLink();
        codigoSql = "DELETE FROM pedidosprov WHERE idpedidosProv=?";
        String codigoSql2 = "DELETE FROM itemspedidoprov WHERE idPedidoProv=?";
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql2);
            PreparedStatement pst2 = cn.prepareStatement(codigoSql);
            
            
            
            //aca obtenemos los valores de la clase Users extendida con la de personas
            pst.setInt(1,datos.getIdprov());
            pst2.setInt(1,datos.getIdprov());
            
                        
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
            JOptionPane.showMessageDialog(null,"No se pudo eliminar items\n Error: " + e);
            return false;
        }
    }
    
    public DefaultTableModel mostrarItems(String IdPed){
        DefaultTableModel tabla;
        
        String [] titulo = {"Id","Cantidad","Producto","P Unit","Total"};
        
        String [] registros = new String [5];
        
        tabla =  new DefaultTableModel(null, titulo);
        
        codigoSql = "SELECT itemspedidoprov.*, productos.* FROM itemspedidoprov INNER JOIN productos ON"
                + " itemspedidoprov.idproducto=productos.idproducto"
                + " WHERE idPedidoProv="+IdPed+" ORDER BY iditemPP DESC";
        
        try {
            
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {          
                
                registros[0] = rs.getString("iditemPP");
                registros[1] = rs.getString("cantidad");
                registros[2] = rs.getString("nombre");
                registros[3] = rs.getString("precioUni");
                registros[4] = rs.getString("total");
                
                tabla.addRow(registros);
            }
            return tabla;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar los Items\nError: "+ e);
            return null;
        }
    }
    
    public boolean insertarItem(ItemsPP datos){
      con.conectar();
      Connection cn = con.getLink();
        
      codigoSql = "INSERT INTO itemspedidoprov(idPedidoProv,idProducto,cantidad,precioUni,"
              + " total) VALUES(?,?,?,?,?)";
      
      
        try {
            
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            //aca obtenemos los valores de la clase Users extendida con la de personas
            pst.setInt(1, datos.getIdpedidoProv());
            pst.setInt(2, datos.getIdproducto());
            pst.setInt(3, datos.getCantidad());
            pst.setDouble(4, datos.getPrecioUni());
            pst.setDouble(5, datos.getTotal());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null," No se pudo insertar el items // " + e);
            return false;
        }
    }
    
    public boolean eliminarItem(ItemsPP datos){
        con.conectar();
        Connection cn = con.getLink();
        codigoSql = "DELETE FROM itemspedidoprov WHERE iditemPP=?";
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            
            //aca obtenemos los valores de la clase Users extendida con la de personas
            pst.setInt(1,datos.getIditemPP());
            
                        
            int n = pst.executeUpdate();
            
            if (n != 0) {
                return true;
            }else{
              return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"No se pudo eliminar items\n Error: " + e);
            return false;
        }
    }
    
    
}
