package tpProxyFacundo.punto1;

import java.sql.*;
import java.util.Set;

public class PersonaDao {

    private Connection obtenerConexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/personasdb";
        String usuario = "root";
        String clave = "";
        return DriverManager.getConnection(url, usuario, clave);
    }

    public Persona personaPorId(int id) {
        String sql = "SELECT nombre FROM personas WHERE id = ?";
        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String nombre = result.getString("nombre");
                Set<Telefono> telefonos = new ProxyTelefonos(id); // Lazy
                return new Persona(id, nombre, telefonos);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
