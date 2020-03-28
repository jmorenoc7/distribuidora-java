
package datos;

public class Categorias {
    private int idcategoria;
    private String nombre_cat;
    private String descripcion_cat;
    private String estado;

    public Categorias() {
    }

    
    public Categorias(int idcategoria, String nombre_cat, String descripcion_cat, String estado) {
        this.idcategoria = idcategoria;
        this.nombre_cat = nombre_cat;
        this.descripcion_cat = descripcion_cat;
        this.estado = estado;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre_cat() {
        return nombre_cat;
    }

    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }

    public String getDescripcion_cat() {
        return descripcion_cat;
    }

    public void setDescripcion_cat(String descripcion_cat) {
        this.descripcion_cat = descripcion_cat;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
