
package datos;

import java.sql.Date;


public class PedidosProv {
    private int idpedidoProv;
    private int idprov;
    private int idusuario;
    private String codigo;
    private Date fecha;
    private Double total;
    private String estado;

    public PedidosProv() {
    }

    public PedidosProv(int idpedidoProv, int idprov, int idusuario, String codigo, Date fecha, Double total, String estado) {
        this.idpedidoProv = idpedidoProv;
        this.idprov = idprov;
        this.idusuario = idusuario;
        this.codigo = codigo;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }

    public int getIdpedidoProv() {
        return idpedidoProv;
    }

    public void setIdpedidoProv(int idpedidoProv) {
        this.idpedidoProv = idpedidoProv;
    }

    public int getIdprov() {
        return idprov;
    }

    public void setIdprov(int idprov) {
        this.idprov = idprov;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
