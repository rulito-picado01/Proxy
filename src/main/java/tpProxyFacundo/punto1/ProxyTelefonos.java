package tpProxyFacundo.punto1;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ProxyTelefonos implements Set<Telefono> {
    private final int idPersona;
    private Set<Telefono> reales;
    private boolean cargado = false;

    public ProxyTelefonos(int idPersona) {
        this.idPersona = idPersona;
    }

    private void cargarSiEsNecesario() {
        if (!cargado) {
            reales = new HashSet<>();
            try (Connection conn = obtenerConexion()) {
                PreparedStatement st = conn.prepareStatement(
                        "SELECT numero FROM telefonos WHERE idPersona = ?");
                st.setInt(1, idPersona);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    reales.add(new Telefono(rs.getString("numero")));
                }
                cargado = true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/personasdb", "root", "");
    }

    @Override
    public int size() {
        cargarSiEsNecesario();
        return reales.size();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        cargarSiEsNecesario();
        return reales.toArray(a);
    }

    @Override
    public Iterator<Telefono> iterator() {
        cargarSiEsNecesario();
        return reales.iterator();
    }

    // Métodos innecesarios para este caso pero requeridos por el compilador
    @Override
    public boolean add(Telefono e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends Telefono> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
