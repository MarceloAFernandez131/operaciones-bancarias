package ar.edu.unahur.obj2.banco;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.banco.observadores.IObservadorCuenta;

public class Cuenta {
    private final Integer numero;
    private Double saldo;
    private List<IObservadorCuenta> observadores = new ArrayList<>();
    
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
        notificar(new Retiro(),monto);

    }

    public void depositar(Double monto){
        this.saldo += monto;
        notificar(new Deposito(),monto);
    }

    private void notificar(IOperacion operacion, Double monto) {
        observadores.forEach(o -> o.notificar(this, operacion, monto));
    }
    public void agregarObservador(IObservadorCuenta observador) {
        observadores.add(observador);
    }
    
    public void quitarObservador(IObservadorCuenta observador) {
        observadores.remove(observador);
    }

    
}
