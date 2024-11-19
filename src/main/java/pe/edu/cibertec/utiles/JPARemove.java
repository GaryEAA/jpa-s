package pe.edu.cibertec.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.domain.Categoria;
import pe.edu.cibertec.domain.Libro;

public class JPARemove {
    public static void main(String[] args) {
        // referenciar a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();
        // referenciar un libro
        Libro libro = em.find(Libro.class, "A20");
        //Categoria categoria = em.find(Categoria.class, "C6");
        // eliminar libro
        em.getTransaction().begin();
        em.remove(libro);
        //em.remove(categoria);
        em.getTransaction().commit();
    }
}
