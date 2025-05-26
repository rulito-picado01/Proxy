package unrn.persistencia.proxy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String numero;

    public Telefono(String numero) {
        this.numero = numero;
    }

    public String numero() {
        return this.numero;
    }

    protected Telefono() {}

    private long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    private String getNumero() {
        return numero;
    }

    private void setNumero(String numero) {
        this.numero = numero;
    }
}
