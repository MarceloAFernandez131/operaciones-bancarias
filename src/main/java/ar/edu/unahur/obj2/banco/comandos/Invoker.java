package ar.edu.unahur.obj2.banco.comandos;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    //private IComando comando;

    private List<IComando> comandos = new ArrayList<>();
    private List<IComando> ultimosComandos = new ArrayList<>();

    public List<IComando> getComandos() {
        return comandos;
    }

    public void agregarComandos(IComando comandos) {
        this.comandos.add(comandos);
    }

    public void ejecutarLote() {
        comandos.forEach(IComando :: ejecutar);
        comandos.forEach(c -> ultimosComandos.add(c));
        comandos.clear();
    }
    
    public void revertirUltimaEjecucion() {
        ultimosComandos.forEach(IComando :: deshacer);
    }
}
