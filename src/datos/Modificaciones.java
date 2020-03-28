
package datos;


public class Modificaciones {
    private int idmodificaciones;
    private int idregTabla;
    private String tabla;
    private String usuario;

    public Modificaciones() {
    }

    public Modificaciones(int idmodificaciones, int idregTabla, String tabla, String usuario) {
        this.idmodificaciones = idmodificaciones;
        this.idregTabla = idregTabla;
        this.tabla = tabla;
        this.usuario = usuario;
    }

    public int getIdmodificaciones() {
        return idmodificaciones;
    }

    public void setIdmodificaciones(int idmodificaciones) {
        this.idmodificaciones = idmodificaciones;
    }

    public int getIdregTabla() {
        return idregTabla;
    }

    public void setIdregTabla(int idregTabla) {
        this.idregTabla = idregTabla;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
