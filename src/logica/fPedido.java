package logica;

import datos.Items;
import datos.Pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fPedido {
    private Conexion con;
    private String codigoSql = "";
    
    public fPedido(Conexion con){
        this.con=con;
    }
    
    public String buscarId(){
        codigoSql="SELECT idpedido FROM pedidos ORDER BY idpedido DESC LIMIT 1";
        
        
        String idpedido = "";
        
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {                
                idpedido = rs.getString("idpedido");
                
            }
            
            return idpedido;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error\n" + "Error: " + e);
        }
        return null;
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
    
    public DefaultTableModel mostrarPedidos(String buscar, String filtro){
        DefaultTableModel tabla;
        
        String [] titulo = {"Id","IdCliente","Cliente","IdUsuario","Usuario",
                            "CodPedido","Fecha","Total","Desc","Neto",
                            "Estado"};
        
        String [] registros = new String [11];
        
        tabla =  new DefaultTableModel(null, titulo);
        
        codigoSql = "SELECT pedidos.*, personas.*, usuarios.* FROM pedidos INNER JOIN personas ON"
                + " pedidos.idcliente=personas.idpersona INNER JOIN usuarios ON pedidos.idusuario=usuarios.idusuario"
                + " WHERE "+filtro+" LIKE '%"+buscar+"%' ORDER BY idpedido DESC";
        
        try {
            
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {          
                
                registros[0] = rs.getString("idpedido");
                registros[1] = rs.getString("idcliente");
                registros[2] = rs.getString("nombre") + " " + rs.getString("apellido");
                registros[3] = rs.getString("idusuario");
                registros[4] = rs.getString("usuario");
                registros[5] = rs.getString("codPedido");
                registros[6] = rs.getString("fecha");
                registros[7] = rs.getString("total");
                registros[8] = rs.getString("descuento");
                registros[9] = rs.getString("neto");
                registros[10] = rs.getString("estado");
                
                tabla.addRow(registros);
            }
            return tabla;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar los pedidos\nError: "+ e);
            return null;
        }
    }
    
    public DefaultTableModel mostrarPedidosDia(String fecha){
        DefaultTableModel tabla;
        
        String [] titulo = {"Id","IdCliente","Cliente","IdUsuario","Usuario",
                            "CodPedido","Fecha","Total","Desc","Neto",
                            "Estado"};
        
        String [] registros = new String [11];
        
        tabla =  new DefaultTableModel(null, titulo);
        
        codigoSql = "SELECT pedidos.*, personas.*, usuarios.* FROM pedidos INNER JOIN personas ON"
                + " pedidos.idcliente=personas.idpersona INNER JOIN usuarios ON pedidos.idusuario=usuarios.idusuario"
                + " WHERE DATE(pedidos.fecha)='"+fecha+"' ORDER BY idpedido DESC";
        
        try {
            
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {          
                
                registros[0] = rs.getString("idpedido");
                registros[1] = rs.getString("idcliente");
                registros[2] = rs.getString("nombre") + " " + rs.getString("apellido");
                registros[3] = rs.getString("idusuario");
                registros[4] = rs.getString("usuario");
                registros[5] = rs.getString("codPedido");
                registros[6] = rs.getString("fecha");
                registros[7] = rs.getString("total");
                registros[8] = rs.getString("descuento");
                registros[9] = rs.getString("neto");
                registros[10] = rs.getString("estado");
                
                tabla.addRow(registros);
            }
            return tabla;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar los pedidos\nError: "+ e);
            return null;
        }
    }
    
    
    
    public boolean insertar(Pedidos datos){
      con.conectar();
      Connection cn = con.getLink();
        
      codigoSql = "INSERT INTO pedidos(idcliente,idusuario,codPedido,fecha,"
              + "total,descuento,neto,estado) VALUES(?,?,?,NOW(),?,?,?,?)";
      
      
        try {
            
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            //aca obtenemos los valores de la clase Users extendida con la de personas
            pst.setInt(1, datos.getIdcliente());
            pst.setInt(2, datos.getIdusuario());
            pst.setString(3, datos.getCodPedido());
            pst.setDouble(4, datos.getTotal());
            pst.setDouble(5, datos.getDescuento());
            pst.setDouble(6, datos.getNeto());
            pst.setString(7, datos.getEstado());
            
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
    
    public boolean modificar(Pedidos datos){
      con.conectar();
      Connection cn = con.getLink();
      
      codigoSql = "UPDATE pedidos set idcliente=?, idusuario=?, codPedido=?, "
              + "fecha=NOW(), total=?, descuento=?, neto=?, estado=? WHERE idpedido=?";
      
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            pst.setInt(1, datos.getIdcliente());
            pst.setInt(2, datos.getIdusuario());
            pst.setString(3, datos.getCodPedido());
            pst.setDouble(4, datos.getTotal());
            pst.setDouble(5, datos.getDescuento());
            pst.setDouble(6, datos.getNeto());
            pst.setString(7, datos.getEstado());
            pst.setInt(8, datos.getIdpedido());
            
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
    
    public boolean eliminarPedido(Pedidos datos){
        con.conectar();
        Connection cn = con.getLink();
        codigoSql = "DELETE FROM pedidos WHERE idpedido=?";
        String codigoSql2 = "DELETE FROM itemspedido WHERE idpedido=?";
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql2);
            PreparedStatement pst2 = cn.prepareStatement(codigoSql);
            
            
            
            //aca obtenemos los valores de la clase Users extendida con la de personas
            pst.setInt(1,datos.getIdpedido());
            pst2.setInt(1,datos.getIdpedido());
            
                        
            int n = pst.executeUpdate();
            
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                }else{
                    return false;
                }
                
            }else{
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                }else{
                    return false;
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null,"No se pudo eliminar items\n Error: " + e);
            return false;
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
    
    public boolean insertarItem(Items datos){
      con.conectar();
      Connection cn = con.getLink();
        
      codigoSql = "INSERT INTO itemspedido(idpedido,idproducto,cantidad,precioUni,"
              + "descuento,total) VALUES(?,?,?,?,?,?)";
      
      
        try {
            
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            //aca obtenemos los valores de la clase Users extendida con la de personas
            pst.setInt(1, datos.getIdpedido());
            pst.setInt(2, datos.getIdproducto());
            pst.setInt(3, datos.getCantidad());
            pst.setDouble(4, datos.getPrecioUni());
            pst.setDouble(5, datos.getDesc());
            pst.setDouble(6, datos.getTotal());
            
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
