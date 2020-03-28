
package datos;

public class Saldos {
    private int idSaldoCliente;
    private int idCliente;
    private int idPedido;
    private Double saldo;
    private String estado;
    private String nota;

    public Saldos() {
    }

    
    public Saldos(int idSaldoCliente, int idCliente, int idPedido, Double saldo, String estado, String nota) {
        this.idSaldoCliente = idSaldoCliente;
        this.idCliente = idCliente;
        this.idPedido = idPedido;
        this.saldo = saldo;
        this.estado = estado;
        this.nota = nota;
    }

    public int getIdSaldoCliente() {
        return idSaldoCliente;
    }

    public void setIdSaldoCliente(int idSaldoCliente) {
        this.idSaldoCliente = idSaldoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
  
}
