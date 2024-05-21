package unrn.singleton;

public class EstacionServicioSystem {

    private static EstacionServicioSystem instance;

    public EstacionServicioSystem() {

    }

    //Demo en Eclipse...
    public static EstacionServicioSystem getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new EstacionServicioSystem();
        return instance;
    }

    public void nuevaVenta() {

    }
}
