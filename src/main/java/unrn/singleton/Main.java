package unrn.singleton;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(
                () -> EstacionServicioSystem.getInstance()
        );
        Thread t2 = new Thread(
                () -> EstacionServicioSystem.getInstance()
        );
        t1.start();
        t2.start();
    }
}
