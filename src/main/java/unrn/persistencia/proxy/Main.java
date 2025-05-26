package unrn.persistencia.proxy;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.function.Consumer;

public class Main {
    private EntityManagerFactory emf;

    public static void main(String[] args) {
        var m = new Main();
        m.inicializar();
        m.traer();

    }

    private void traer() {
        inTx((em) -> {
            var persona = em.find(Persona.class, 1L);
            System.out.println(persona.nombre());
            System.out.println(persona.apellido());
            persona.telefonos().stream().forEach((t)  -> System.out.println(t));
        });
    }

    public void inicializar()  {
        emf = Persistence
                .createEntityManagerFactory("derby-inmemory");
        inTx((em) -> {
            var p = new Persona(1L, "Jose", "Carlos");
            p.agregarTelefono("123-3403");
            p.agregarTelefono("568-8988");
            em.persist(p);
        });
    }


    public void inTx(Consumer<EntityManager> consumer) {
        var em = this.emf.createEntityManager();
        var tx = em.getTransaction();

        try {
            tx.begin();

            consumer.accept(em);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
