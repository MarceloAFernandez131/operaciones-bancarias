package ar.edu.unahur.obj2.banco.observadores;

import ar.edu.unahur.obj2.banco.Cuenta;
import ar.edu.unahur.obj2.banco.IOperacion;

public class AuditoriaObserver implements IObservadorCuenta{

    @Override
    public void notificar(Cuenta cuenta, IOperacion operacion, Double monto) {
        System.out.println(
            "[Auditoria] Cuenta"
            + cuenta.getNumero()
            + " - "
            + operacion.descripcion()
            + " $ "
            + monto
        );
    }
    
}
