package datos;

public class ItemsPP {
    private int iditemPP;
    private int idpedidoProv;
    private int idproducto;
    private int cantidad;
    private Double precioUni;
    private Double total;

    public ItemsPP() {
    }

    public ItemsPP(int iditemPP, int idpedidoProv, int idproducto, int cantidad, Double precioUni, Double total) {
        this.iditemPP = iditemPP;
        this.idpedidoProv = idpedidoProv;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.precioUni = precioUni;
        this.total = total;
    }

    public int getIditemPP() {
        return iditemPP;
    }

    public void setIditemPP(int iditemPP) {
        this.iditemPP = iditemPP;
    }

    public int getIdpedidoProv() {
        return idpedidoProv;
    }

    public void setIdpedidoProv(int idpedidoProv) {
        this.idpedidoProv = idpedidoProv;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    
    
    
}
