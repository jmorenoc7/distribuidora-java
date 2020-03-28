
package datos;

import java.sql.Date;


public class Usuarios extends Personas{
    private int idusuario;
    private String usuario;
    private String pass;
    private String puesto;
    private Double presupuesto;
    private String estado;

    public Usuarios() {
    }

    public Usuarios(int idusuario, String usuario, String pass, String puesto, Double presupuesto, String estado) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.pass = pass;
        this.puesto = puesto;
        this.presupuesto = presupuesto;
        this.estado = estado;
    }

    public Usuarios(int idusuario, String usuario, String pass, String puesto, Double presupuesto, String estado, int idpersona, String nombre, String apellido, String dni, String domicilio1, String ciudad1, String domicilio2, String ciudad2, String telefono1, String telefono2, String email1, String email2, Date fecha) {
        super(idpersona, nombre, apellido, dni, domicilio1, ciudad1, domicilio2, ciudad2, telefono1, telefono2, email1, email2, fecha);
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.pass = pass;
        this.puesto = puesto;
        this.presupuesto = presupuesto;
        this.estado = estado;
    }

    

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
