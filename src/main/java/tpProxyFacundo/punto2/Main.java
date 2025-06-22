package tpProxyFacundo.punto2;

import java.io.IOException;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Usuario admin = new Usuario("Alice", Arrays.asList(Permiso.ADMIN));
        Usuario intermedio = new Usuario("Bob", Arrays.asList(Permiso.INTERMEDIO));
        Usuario basico = new Usuario("Charlie", Arrays.asList(Permiso.BASICO));

        probarAcceso(admin, "i_confidencial.txt");       // debe permitir
        probarAcceso(intermedio, "i_confidencial.txt");  // debe fallar
        probarAcceso(basico, "m_manual.txt");            // debe fallar
        probarAcceso(intermedio, "m_manual.txt");        // debe permitir
        probarAcceso(basico, "novedades.txt");           // debe permitir
    }

    public static void probarAcceso(Usuario usuario, String archivo) {
        FileAccessInterface proxy = new FileAccessProxy(usuario, "archivos", archivo);
        try {
            System.out.println("[" + usuario + "] leyendo " + archivo + ":");
            System.out.println(proxy.readFile());
        } catch (SecurityException | IOException e) {
            System.out.println("[" + usuario + "] ERROR: " + e.getMessage());
        }
        System.out.println();
    }
}
