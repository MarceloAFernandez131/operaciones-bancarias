package ar.edu.unahur.obj2.banco;

public class Cuenta {
    private final Integer numero;
    private Double saldo;
    
    public Cuenta(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }
    public Integer getNumero() {
        return numero;
    }
    public Double getSaldo() {
        return saldo;
    }

    public void retirar(Double monto){
        this.saldo -= monto;
    }

    public void depositar(Double monto){
        this.saldo += monto;
    }
}
