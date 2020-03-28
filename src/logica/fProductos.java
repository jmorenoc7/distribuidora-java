package logica;

import datos.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fProductos {
    
    private Conexion con;
    private String codigoSql = "";
    
    public fProductos(Conexion con){
        this.con = con;
    }
    
    public String[] buscarIdProducto(String IdProducto){
        
        codigoSql="SELECT productos.*,categorias.* FROM productos INNER JOIN categorias ON "
                + "productos.idcategoria = categorias.idcategoria WHERE idproducto="+IdProducto+"";
        
        
        String [] registros = new String[18];
        
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {   
                
                registros[0] = rs.getString("idproducto");
                registros[1] = rs.getString("idcategoria");
                registros[2] = rs.getString("nombre_cat");  
                registros[3] = rs.getString("codBarra");
                registros[4] = rs.getString("nombre");
                registros[5] = rs.getString("descripcion");
                registros[6] = rs.getString("stock");
                registros[7] = rs.getString("precioCompra1");
                registros[8] = rs.getString("precioCompra2");
                registros[9] = rs.getString("precioCompra3");
                registros[10] = rs.getString("precio1");
                registros[11] = rs.getString("precio2");
                registros[12] = rs.getString("precio3");
                registros[13] = rs.getString("margen1");
                registros[14] = rs.getString("margen2");
                registros[15] = rs.getString("margen3");
                registros[16] = rs.getString("cantidadMin");
                registros[17] = rs.getString("estado");
                
            }
            
            return registros;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error\n" + "Error: " + e);
        }
        return null;
    }
    
    public DefaultTableModel mostrarProductosPedido(String buscar, String filtro){
        DefaultTableModel tabla;
        
        String [] titulo = {"Id","Categoria","Cod Barra","Nombre","Descripcion",
                            "Stock","P Venta1","P Venta2","P Venta3"};
        
        String [] registros = new String [9];
        
        tabla =  new DefaultTableModel(null, titulo);
        
        codigoSql = "SELECT productos.*,categorias.nombre_cat FROM productos "
                + "INNER JOIN categorias ON productos.idcategoria=categorias.idcategoria"
                + " WHERE "+filtro+" LIKE '%"+buscar+"%' AND productos.estado='Activo' ORDER BY idproducto DESC";
        
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {          
                
                registros[0] = rs.getString("idproducto");
                registros[1] = rs.getString("nombre_cat");
                registros[2] = rs.getString("codBarra");
                registros[3] = rs.getString("nombre");
                registros[4] = rs.getString("descripcion");
                registros[5] = rs.getString("stock");
                registros[6] = rs.getString("precio1");
                registros[7] = rs.getString("precio2");
                registros[8] = rs.getString("precio3");
                
                tabla.addRow(registros);
            }
            return tabla;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar los productos\nError: "+ e);
            return null;
        }
    }
    
    public DefaultTableModel mostrarProductos(String buscar, String filtro){
        DefaultTableModel tabla;
        
        String [] titulo = {"Id","Categoria","Cod Barra","Nombre","Descripcion",
                            "Stock","P Compra1","P Compra2","P Compra3","Margen1",
                            "Margen2","Margen3","P Venta1","P Venta2","P Venta3",
                            "Cant Min","Estado"};
        
        String [] registros = new String [17];
        
        tabla =  new DefaultTableModel(null, titulo);
        
        codigoSql = "SELECT productos.*,categorias.nombre_cat FROM productos "
                + "INNER JOIN categorias ON productos.idcategoria=categorias.idcategoria"
                + " WHERE "+filtro+" LIKE '%"+buscar+"%' ORDER BY idproducto DESC";
        
        try {
            ResultSet rs = con.getConsulta().executeQuery(codigoSql);
            
            while (rs.next()) {                
                registros[0] = rs.getString("idproducto");
                registros[1] = rs.getString("nombre_cat");
                registros[2] = rs.getString("codBarra");
                registros[3] = rs.getString("nombre");
                registros[4] = rs.getString("descripcion");
                registros[5] = rs.getString("stock");
                registros[6] = rs.getString("precioCompra1");
                registros[7] = rs.getString("precioCompra2");
                registros[8] = rs.getString("precioCompra3");
                registros[9] = rs.getString("margen1");
                registros[10] = rs.getString("margen2");
                registros[11] = rs.getString("margen3");
                registros[12] = rs.getString("precio1");
                registros[13] = rs.getString("precio2");
                registros[14] = rs.getString("precio3");
                registros[15] = rs.getString("cantidadMin");
                registros[16] = rs.getString("estado");
                
                tabla.addRow(registros);
            }
            return tabla;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar los productos\nError: "+ e);
            return null;
        }
    }
    
    public boolean eliminar(Productos datos){
        
        //con.conectar();
        Connection cn = Conexion.getLink();
    
        codigoSql = "UPDATE productos set estado=? WHERE idproducto=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            pst.setString(1, "Inactivo");
            pst.setInt(2, datos.getIdproducto());
            
            int n = pst.executeUpdate();
            
            if (n!=0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Hubo un error al eliminar Producto, cierre la ventana e intente nuevamente\n" + "Error: " + e);
            return false;
        }
    }
    
    public boolean insertar(Productos datos){
      con.conectar();
      Connection cn = con.getLink();
        
      codigoSql = "INSERT INTO productos(idcategoria,codBarra,nombre,descripcion,"
              + "stock,precioCompra1,precioCompra2,precioCompra3,precio1,precio2,precio3,"
              + "margen1,margen2,margen3,cantidadMin,estado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
      
        try {
            
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            //aca obtenemos los valores de la clase Users extendida con la de personas
            pst.setInt(1, datos.getIdcategoria());
            pst.setString(2, datos.getCodBarra());
            pst.setString(3, datos.getNombre());
            pst.setString(4, datos.getDescripcion());
            pst.setInt(5, datos.getStock());
            pst.setDouble(6, datos.getPrecioC1());
            pst.setDouble(7, datos.getPrecioC2());
            pst.setDouble(8, datos.getPrecioC3());
            pst.setDouble(9, datos.getPrecioV1());
            pst.setDouble(10, datos.getPrecioV2());
            pst.setDouble(11, datos.getPrecioV3());
            pst.setDouble(12, datos.getMargen1());
            pst.setDouble(13, datos.getMargen2());
            pst.setDouble(14, datos.getMargen3());
            pst.setInt(15, datos.getCatMin());
            pst.setString(16, datos.getEstado());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null," No se pudo crear el Producto // " + e);
            return false;
        }
    }
    
    public boolean modificar(Productos datos){
        
        //con.conectar();
        Connection cn = Conexion.getLink();
    
        codigoSql = "UPDATE productos set idcategoria=?,codBarra=?,nombre=?,descripcion=?,"
              + "stock=?,precioCompra1=?,precioCompra2=?,precioCompra3=?,precio1=?,precio2=?,precio3=?,"
              + "margen1=?,margen2=?,margen3=?,cantidadMin=?,estado=? WHERE idproducto=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(codigoSql);
            
            pst.setInt(1, datos.getIdcategoria());
            pst.setString(2, datos.getCodBarra());
            pst.setString(3, datos.getNombre());
            pst.setString(4, datos.getDescripcion());
            pst.setInt(5, datos.getStock());
            pst.setDouble(6, datos.getPrecioC1());
            pst.setDouble(7, datos.getPrecioC2());
            pst.setDouble(8, datos.getPrecioC3());
            pst.setDouble(9, datos.getPrecioV1());
            pst.setDouble(10, datos.getPrecioV2());
            pst.setDouble(11, datos.getPrecioV3());
            pst.setDouble(12, datos.getMargen1());
            pst.setDouble(13, datos.getMargen2());
            pst.setDouble(14, datos.getMargen3());
            pst.setInt(15, datos.getCatMin());
            pst.setString(16, datos.getEstado());
            pst.setInt(17, datos.getIdproducto());
            
            int n = pst.executeUpdate();
            
            if (n!=0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Hubo un error al modificar el Producto, \n cierre la ventana e intente nuevamente\n" + "Error: " + e);
            return false;
        }
    }
    
}
