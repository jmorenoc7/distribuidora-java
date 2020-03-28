package datos;

public class Productos {
    private int idproducto;
    private int idcategoria;
    private String codBarra;
    private String nombre;
    private String descripcion;
    private int stock;
    private Double precioC1;
    private Double precioC2;
    private Double precioC3;
    private Double precioV1;
    private Double precioV2;
    private Double precioV3;
    private Double margen1;
    private Double margen2;
    private Double margen3;
    private int catMin;
    private String estado;

    public Productos() {
    }
    
    public Productos(int idproducto, int idcategoria, String codBarra, String nombre, String descripcion, int stock, Double precioC1, Double precioC2, Double precioC3, Double precioV1, Double precioV2, Double precioV3, Double margen1, Double margen2, Double margen3, int catMin, String estado) {
        this.idproducto = idproducto;
        this.idcategoria = idcategoria;
        this.codBarra = codBarra;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precioC1 = precioC1;
        this.precioC2 = precioC2;
        this.precioC3 = precioC3;
        this.precioV1 = precioV1;
        this.precioV2 = precioV2;
        this.precioV3 = precioV3;
        this.margen1 = margen1;
        this.margen2 = margen2;
        this.margen3 = margen3;
        this.catMin = catMin;
        this.estado = estado;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getPrecioC1() {
        return precioC1;
    }

    public void setPrecioC1(Double precioC1) {
        this.precioC1 = precioC1;
    }

    public Double getPrecioC2() {
        return precioC2;
    }

    public void setPrecioC2(Double precioC2) {
        this.precioC2 = precioC2;
    }

    public Double getPrecioC3() {
        return precioC3;
    }

    public void setPrecioC3(Double precioC3) {
        this.precioC3 = precioC3;
    }

    public Double getPrecioV1() {
        return precioV1;
    }

    public void setPrecioV1(Double precioV1) {
        this.precioV1 = precioV1;
    }

    public Double getPrecioV2() {
        return precioV2;
    }

    public void setPrecioV2(Double precioV2) {
        this.precioV2 = precioV2;
    }

    public Double getPrecioV3() {
        return precioV3;
    }

    public void setPrecioV3(Double precioV3) {
        this.precioV3 = precioV3;
    }

    public Double getMargen1() {
        return margen1;
    }

    public void setMargen1(Double margen1) {
        this.margen1 = margen1;
    }

    public Double getMargen2() {
        return margen2;
    }

    public void setMargen2(Double margen2) {
        this.margen2 = margen2;
    }

    public Double getMargen3() {
        return margen3;
    }

    public void setMargen3(Double margen3) {
        this.margen3 = margen3;
    }

    public int getCatMin() {
        return catMin;
    }

    public void setCatMin(int catMin) {
        this.catMin = catMin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
