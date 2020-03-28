
package datos;


public class DatosLogin {
    private static String nombre;
    private static String usuario;
    private static int nusuario;
    private static String perfil;
    private static Double presupuesto;
    private static String servidor;
    private static String db;

    public DatosLogin() {
    }

    public static String getServidor() {
        return servidor;
    }

    public static void setServidor(String servidor) {
        DatosLogin.servidor = servidor;
    }

    public static String getDb() {
        return db;
    }

    public static void setDb(String db) {
        DatosLogin.db = db;
    }
    

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        DatosLogin.nombre = nombre;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        DatosLogin.usuario = usuario;
    }

    public static int getNusuario() {
        return nusuario;
    }

    public static void setNusuario(int nusuario) {
        DatosLogin.nusuario = nusuario;
    }

    public static String getPerfil() {
        return perfil;
    }

    public static void setPerfil(String perfil) {
        DatosLogin.perfil = perfil;
    }

    public static Double getPresupuesto() {
        return presupuesto;
    }

    public static void setPresupuesto(Double presupuesto) {
        DatosLogin.presupuesto = presupuesto;
    }

    
    
}