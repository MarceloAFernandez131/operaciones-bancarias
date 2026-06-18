package ar.edu.unahur.obj2.banco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.banco.comandos.DepositarComando;
import ar.edu.unahur.obj2.banco.comandos.IComando;
import ar.edu.unahur.obj2.banco.comandos.Invoker;
import ar.edu.unahur.obj2.banco.comandos.RetirarComando;

public class CuentaTest {
    @Test
    @DisplayName("Dada una cuenta con 10 mil, depositar 5 Mil, su saldo debe ser 15 mil")
    void test1() {
        Cuenta cuenta = new Cuenta(1234, 10000.0);
        IComando deposito = new DepositarComando(cuenta, 5000.0);

        deposito.ejecutar();
        assertEquals(15000.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Dada una cuenta con 1000, depositar 2000, extraer 1000, depositar 3000 y luego retirar 2000. Su saldo debe ser 3000")
    void test2() {
        Cuenta cuenta2 = new Cuenta(1235, 1000.0);
        IComando deposito1 = new DepositarComando(cuenta2, 2000.0);
        IComando extraccion1 = new RetirarComando(cuenta2, 1000.0);
        IComando deposito2 = new DepositarComando(cuenta2, 3000.0);
        IComando extraccion2 = new RetirarComando(cuenta2, 2000.0);

        Invoker lote = new Invoker();

        lote.agregarComandos(deposito1);
        lote.agregarComandos(extraccion1);
        lote.agregarComandos(deposito2);
        lote.agregarComandos(extraccion2);

        lote.ejecutarLote();

        assertEquals(3000, cuenta2.getSaldo());
    }

    @Test
    @DisplayName("Dada una cuenta con 1000, depositar 2000, extraer 1000, depositar 3000 y luego retirar 2000. Luego revertir la ejecucion y su saldo debe ser 1000")
    void test3() {
        Cuenta cuenta2 = new Cuenta(1235, 1000.0);
        IComando deposito1 = new DepositarComando(cuenta2, 2000.0);
        IComando extraccion1 = new RetirarComando(cuenta2, 1000.0);
        IComando deposito2 = new DepositarComando(cuenta2, 3000.0);
        IComando extraccion2 = new RetirarComando(cuenta2, 2000.0);

        Invoker lote = new Invoker();

        lote.agregarComandos(deposito1);
        lote.agregarComandos(extraccion1);
        lote.agregarComandos(deposito2);
        lote.agregarComandos(extraccion2);

        lote.revertirUltimaEjecucion();

        assertEquals(1000, cuenta2.getSaldo());
    }
}
