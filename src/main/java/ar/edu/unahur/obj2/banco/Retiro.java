package ar.edu.unahur.obj2.banco;

public class Retiro implements IOperacion{

    @Override
    public String descripcion() {
        return "Retiro";
    }

    @Override
    public String mensajeCliente(Double monto) {
        return "Se debitaron $ " + monto;
    }

}
