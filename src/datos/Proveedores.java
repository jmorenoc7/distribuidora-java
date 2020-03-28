
package datos;

import java.sql.Date;

public class Proveedores extends Personas{
    private int idproveedor;

    public Proveedores() {
    }

    public Proveedores(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Proveedores(int idproveedor, int idpersona, String nombre, String apellido, String dni, String domicilio1, String ciudad1, String domicilio2, String ciudad2, String telefono1, String telefono2, String email1, String email2, Date fecha) {
        super(idpersona, nombre, apellido, dni, domicilio1, ciudad1, domicilio2, ciudad2, telefono1, telefono2, email1, email2, fecha);
        this.idproveedor = idproveedor;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }
    
    
}
