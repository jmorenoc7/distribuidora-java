
package datos;

import java.sql.Date;


public class Pedidos {
    private int idpedido;
    private int idcliente;
    private int idusuario;
    private String codPedido;
    private Date fecha;
    private Double total;
    private Double descuento;
    private Double neto;
    private String estado;

    public Pedidos() {
    }

    public Pedidos(int idpedido, int idcliente, int idusuario, String codPedido, Date fecha, Double total, Double descuento, Double neto, String estado) {
        this.idpedido = idpedido;
        this.idcliente = idcliente;
        this.idusuario = idusuario;
        this.codPedido = codPedido;
        this.fecha = fecha;
        this.total = total;
        this.descuento = descuento;
        this.neto = neto;
        this.estado = estado;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
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

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getNeto() {
        return neto;
    }

    public void setNeto(Double neto) {
        this.neto = neto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
