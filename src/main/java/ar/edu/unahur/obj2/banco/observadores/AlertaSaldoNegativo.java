package ar.edu.unahur.obj2.banco.observadores;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.banco.Cuenta;
import ar.edu.unahur.obj2.banco.IOperacion;

public class AlertaSaldoNegativo implements IObservadorCuenta{
    private List<Cuenta> cuentasEnAlerta = new ArrayList<>();

    @Override
    public void notificar(Cuenta cuenta, IOperacion operacion, Double monto) {
        if (cuenta.getSaldo() > 0) {
            System.out.println(
                "[Alerta saldo negativo] La Cuenta"
                + cuenta.getNumero()
                + "quedó con saldo negativo."
            );
            cuentasEnAlerta.add(cuenta);
        }
    }

    public List<Cuenta> getCuentasEnAlerta() {
        return cuentasEnAlerta;
    }
}
