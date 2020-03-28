package datos;

import java.sql.Date;

public class Personas {
    private int idpersona;
    private String nombre;
    private String apellido;
    private String dni;
    private String domicilio1;
    private String ciudad1;
    private String domicilio2;
    private String ciudad2;
    private String telefono1;
    private String telefono2;
    private String email1;
    private String email2;
    private Date fecha;

    public Personas() {
    }

    public Personas(int idpersona, String nombre, String apellido, String dni, String domicilio1, String ciudad1, String domicilio2, String ciudad2, String telefono1, String telefono2, String email1, String email2, Date fecha) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio1 = domicilio1;
        this.ciudad1 = ciudad1;
        this.domicilio2 = domicilio2;
        this.ciudad2 = ciudad2;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.email1 = email1;
        this.email2 = email2;
        this.fecha = fecha;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio1() {
        return domicilio1;
    }

    public void setDomicilio1(String domicilio1) {
        this.domicilio1 = domicilio1;
    }

    public String getCiudad1() {
        return ciudad1;
    }

    public void setCiudad1(String ciudad1) {
        this.ciudad1 = ciudad1;
    }

    public String getDomicilio2() {
        return domicilio2;
    }

    public void setDomicilio2(String domicilio2) {
        this.domicilio2 = domicilio2;
    }

    public String getCiudad2() {
        return ciudad2;
    }

    public void setCiudad2(String ciudad2) {
        this.ciudad2 = ciudad2;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
