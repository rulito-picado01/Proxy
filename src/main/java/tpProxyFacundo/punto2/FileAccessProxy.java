package tpProxyFacundo.punto2;

import java.io.IOException;

public class FileAccessProxy implements FileAccessInterface {
    private Usuario usuario;
    private FileAccess archivo;

    public FileAccessProxy(Usuario usuario, String ruta, String nombreArchivo) {
        this.usuario = usuario;
        this.archivo = new FileAccess(ruta, nombreArchivo);
    }

    @Override
    public String readFile() throws IOException {
        String nombre = archivo.getNombreArchivo().toLowerCase();

        if (nombre.startsWith("i") && !usuario.poseePermiso(Permiso.ADMIN)) {
            throw new SecurityException("Acceso denegado: se requiere permiso ADMIN para leer archivos importantes.");
        }

        if (nombre.startsWith("m") && !(usuario.poseePermiso(Permiso.ADMIN) || usuario.poseePermiso(Permiso.INTERMEDIO))) {
            throw new SecurityException("Acceso denegado: se requiere permiso ADMIN o INTERMEDIO para leer archivos medianamente importantes.");
        }

        return archivo.readFile();
    }
}
