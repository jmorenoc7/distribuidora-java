package datos;

import java.sql.Date;

public class Clientes extends Personas{
    private int idcliente;
    private String usuario;
    private String pass;
    private String tipoUsuario;
    private String estado;

    public Clientes() {
    }

    public Clientes(int idcliente, String usuario, String pass, String tipoUsuario, String estado) {
        this.idcliente = idcliente;
        this.usuario = usuario;
        this.pass = pass;
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
    }

    public Clientes(int idcliente, String usuario, String pass, String tipoUsuario, String estado, int idpersona, String nombre, String apellido, String dni, String domicilio1, String ciudad1, String domicilio2, String ciudad2, String telefono1, String telefono2, String email1, String email2, Date fecha) {
        super(idpersona, nombre, apellido, dni, domicilio1, ciudad1, domicilio2, ciudad2, telefono1, telefono2, email1, email2, fecha);
        this.idcliente = idcliente;
        this.usuario = usuario;
        this.pass = pass;
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
