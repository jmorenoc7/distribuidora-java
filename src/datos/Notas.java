package datos;

public class Notas {
    private int idnota;
    private int idpersona;
    private String nota;

    public Notas() {
    }

    public Notas(int idnota, int idpersona, String nota) {
        this.idnota = idnota;
        this.idpersona = idpersona;
        this.nota = nota;
    }

    public int getIdnota() {
        return idnota;
    }

    public void setIdnota(int idnota) {
        this.idnota = idnota;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
}
