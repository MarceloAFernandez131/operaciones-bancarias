package ar.edu.unahur.obj2.banco;

public class Deposito implements IOperacion{


    @Override
    public String descripcion() {
        return "Deposito";
    }

    @Override
    public String mensajeCliente(Double monto) {
        return "Se acreditaron $ " + monto;
    }

}
