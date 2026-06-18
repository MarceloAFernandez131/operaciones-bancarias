package ar.edu.unahur.obj2.banco.comandos;

import ar.edu.unahur.obj2.banco.Cuenta;

public class RetirarComando implements IComando{
    private final Cuenta cuenta;
    private Double monto;

    
    public RetirarComando(Cuenta cuenta, Double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        cuenta.retirar(monto);
    }

    @Override
    public void deshacer() {
        cuenta.depositar(monto);
    }
    
}
