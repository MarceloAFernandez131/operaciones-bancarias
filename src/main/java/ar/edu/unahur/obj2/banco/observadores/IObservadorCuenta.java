package ar.edu.unahur.obj2.banco.observadores;

import ar.edu.unahur.obj2.banco.Cuenta;
import ar.edu.unahur.obj2.banco.IOperacion;

public interface IObservadorCuenta {
    void notificar(Cuenta cuenta, IOperacion operacion, Double monto);
}
