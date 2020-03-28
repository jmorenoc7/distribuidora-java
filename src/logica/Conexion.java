
package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Conexion {
    
    private static String db;
    private static String servidor;
    private static String url;
    private static String user = "root";
    private static String pass = "";
    private static Connection link;
    private static Statement consulta;
    
    public Conexion() {
    }
    
    public int conectar(){
        Connection link1 = null;
        try {
            
            Class.forName("org.gjt.mm.mysql.Driver");
            url = "jdbc:mysql://"+ servidor +"/" + db;
            setUrl(url);
            link1 = DriverManager.getConnection(url,user,pass);
            setLink(link1);
            consulta = link1.createStatement();
            setConsulta(consulta);
            //JOptionPane.showMessageDialog(null, "Link: " + link1 + "\n" + "Consulta: " + consulta);
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Driver no encontrado // " + e);
            return 0;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Fallo al recibir la base de datos // " + e);
            return 0;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"No hay resultado // " + e);
            return 0;
        } finally{
            return 1;
        }
        
    }
    
    public void closeCn(Connection conexion) throws SQLException {
        if (conexion != null) {
            JOptionPane.showMessageDialog(null, "Se cerro conexion");
            conexion.close();
        }
    }

    public static String getDb() {
        return db;
    }

    public static void setDb(String db) {
        Conexion.db = db;
    }

    public static String getServidor() {
        return servidor;
    }

    public static void setServidor(String servidor) {
        Conexion.servidor = servidor;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Conexion.url = url;
    }

    public static Connection getLink() {
        return link;
    }

    public static void setLink(Connection link) {
        Conexion.link = link;
    }

    public static Statement getConsulta() {
        return consulta;
    }

    public static void setConsulta(Statement consulta) {
        Conexion.consulta = consulta;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Conexion.user = user;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        Conexion.pass = pass;
    }

    
    
    
    
}
