package unrn.persistencia.proxy;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Persona {
    @Id
    private long id;
    private String nombre;
    private String apellido;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pesona")
    private List<Telefono> telefonos;

    public Persona(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefonos = new ArrayList<>();
    }

    public void imprimirClase()  {
        System.out.println("Clase real de la colección: " + this.telefonos.getClass().getName());
    }

    protected Persona() {}


    public List<String> telefonos() {
        return this.telefonos.stream().map(t -> t.numero()).collect(Collectors.toList());
    }

    public void agregarTelefono(String numero) {
        this.telefonos.add(new Telefono(numero));
    }

    public String nombre() {
        return this.nombre;
    }

    public String apellido() {
        return this.apellido;
    }

    private String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String getApellido() {
        return apellido;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }

    private List<Telefono> getTelefonos() {
        return telefonos;
    }

    private void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    private long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }
}
