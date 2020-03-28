
package datos;

public class Items {
    private int iditempedido;
    private int idpedido;
    private int idproducto;
    private int cantidad;
    private Double precioUni;
    private Double desc;
    private Double total;

    public Items() {
    }

    public Items(int iditempedido, int idpedido, int idproducto, int cantidad, Double precioUni, Double desc, Double total) {
        this.iditempedido = iditempedido;
        this.idpedido = idpedido;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.precioUni = precioUni;
        this.desc = desc;
        this.total = total;
    }

    public int getIditempedido() {
        return iditempedido;
    }

    public void setIditempedido(int iditempedido) {
        this.iditempedido = iditempedido;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(Double precioUni) {
        this.precioUni = precioUni;
    }

    public Double getDesc() {
        return desc;
    }

    public void setDesc(Double desc) {
        this.desc = desc;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
}
