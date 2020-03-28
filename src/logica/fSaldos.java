package logica;

import datos.Items;
import datos.Pedidos;
import datos.Saldos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fSaldos {
    private Conexion con;
    private String codigoSql = "";
    
    public fSaldos(Conexion con){
        this.con=con;
    }
    
    
    public String[] buscarIdPedido(String IdPedido){
        
        codigoSql="SELECT pedidos.*,personas.* FROM pedidos INNER JOIN personas ON "
                + "pedidos.idcliente = personas.idpersona WHERE idpedido="+IdPedido+"";
        
        
        String [] registros = new String[11];
        
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {   
                
                registros[0] = rs.getString("idpedido");
                registros[1] = rs.getString("idcliente");
                registros[2] = rs.getString("nombre") + " " + rs.getString("apellido"); 
                registros[3] = rs.getString("domicilio1") + " " + rs.getString("ciudad1");
                registros[4] = rs.getString("idusuario");
                registros[5] = rs.getString("codPedido");
                registros[6] = rs.getString("fecha");
                registros[7] = rs.getString("total");
                registros[8] = rs.getString("descuento");
                registros[9] = rs.getString("neto");
                registros[10] = rs.getString("estado");
                
            }
            
            return registros;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error\n" + "Error: " + e);
        }
        return null;
    }
    
    public boolean modificar(Pedidos datos){
      con.conectar();
      Connection cn = con.getLink();
      
      codigoSql = "UPDATE pedidos set neto=?, estado=? WHERE idpedido=?";
      
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            pst.setDouble(1, datos.getNeto());
            pst.setString(2, datos.getEstado());
            pst.setInt(3, datos.getIdpedido());
            
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
    
    public boolean insertar(Saldos datos){
      con.conectar();
      Connection cn = con.getLink();
        
      codigoSql = "INSERT INTO saldosclientes(idcliente,idpedido,saldo,estado,"
              + "notas) VALUES(?,?,?,?,?)";
      
      
        try {
            
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            //aca obtenemos los valores de la clase Users extendida con la de personas
            pst.setInt(1, datos.getIdCliente());
            pst.setInt(2, datos.getIdPedido());
            pst.setDouble(3, datos.getSaldo());
            pst.setString(4, datos.getEstado());
            pst.setString(5, datos.getNota());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null," No se pudo insertar el saldo // " + e);
            return false;
        }
    }
    
    public DefaultTableModel mostrarPedidosSaldo(String id){
        DefaultTableModel tabla;
        
        String [] titulo = {"Id","Usuario","CodPedido","Fecha","Total","Desc","Neto Pedido", "Saldo",
                            "Estado"};
        
        String [] registros = new String [9];
        
        tabla =  new DefaultTableModel(null, titulo);
        
        codigoSql = "SELECT pedidos.*, personas.*, usuarios.*, saldosclientes.* FROM pedidos "
                + "INNER JOIN personas ON pedidos.idcliente=personas.idpersona "
                + "INNER JOIN usuarios ON pedidos.idusuario=usuarios.idusuario "
                + "INNER JOIN saldosclientes ON pedidos.idpedido=saldosclientes.idpedido "
                + " WHERE saldosclientes.idcliente="+id+" ORDER BY saldosclientes.idpedido DESC";
        
        try {
            
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {          
                
                registros[0] = rs.getString("saldosclientes.idpedido");
                registros[1] = rs.getString("usuario");
                registros[2] = rs.getString("codPedido");
                registros[3] = rs.getString("fecha");
                registros[4] = rs.getString("total");
                registros[5] = rs.getString("descuento");
                registros[6] = rs.getString("neto");
                registros[7] = rs.getString("saldo");
                registros[8] = rs.getString("saldosclientes.estado");
                
                tabla.addRow(registros);
            }
            return tabla;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar los pedidos\nError: "+ e);
            return null;
        }
    }
    
    public DefaultTableModel mostrarItems(String IdPed){
        DefaultTableModel tabla;
        
        String [] titulo = {"Id","Cantidad","IdProd","Producto","P Unit","Desc","Total"};
        
        String [] registros = new String [7];
        
        tabla =  new DefaultTableModel(null, titulo);
        
        codigoSql = "SELECT itemspedido.*, productos.* FROM itemspedido INNER JOIN productos ON"
                + " itemspedido.idproducto=productos.idproducto"
                + " WHERE idpedido="+IdPed+" ORDER BY iditemPedido DESC";
        
        try {
            
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {          
                
                registros[0] = rs.getString("iditemPedido");
                registros[1] = rs.getString("cantidad");
                registros[2] = rs.getString("idproducto");
                registros[3] = rs.getString("nombre");
                registros[4] = rs.getString("precioUni");
                registros[5] = rs.getString("descuento");
                registros[6] = rs.getString("total");
                
                tabla.addRow(registros);
            }
            return tabla;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar los Items\nError: "+ e);
            return null;
        }
    }
    
    public boolean eliminarItem(Items datos){
        con.conectar();
        Connection cn = con.getLink();
        codigoSql = "DELETE FROM itemspedido WHERE iditemPedido=?";
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            
            //aca obtenemos los valores de la clase Users extendida con la de personas
            pst.setInt(1,datos.getIditempedido());
            
                        
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
    
     public boolean modificarItems(Items datos){
      con.conectar();
      Connection cn = con.getLink();
      
      codigoSql = "UPDATE itemspedido set cantidad=?, precioUni=?, total=? WHERE iditemPedido=?";
      
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            pst.setInt(1, datos.getCantidad());
            pst.setDouble(2, datos.getPrecioUni());
            pst.setDouble(3, datos.getTotal());
            pst.setInt(4, datos.getIditempedido());
            
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
    
    public boolean restarStock(Items datos){
      con.conectar();
      Connection cn = con.getLink();
      
      codigoSql = "UPDATE productos set stock=stock-? WHERE idproducto=?";
      
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            pst.setInt(1, datos.getCantidad());
            pst.setInt(2, datos.getIdproducto());
            
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
    
    public boolean sumarStock(Items datos){
      con.conectar();
      Connection cn = con.getLink();
      
      codigoSql = "UPDATE productos set stock=stock+? WHERE idproducto=?";
      
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            pst.setInt(1, datos.getCantidad());
            pst.setInt(2, datos.getIdproducto());
            
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
    
}
