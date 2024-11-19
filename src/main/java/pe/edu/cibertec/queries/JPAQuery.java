package pe.edu.cibertec.queries;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import pe.edu.cibertec.domain.Libro;

import java.util.List;

public class JPAQuery {
    public static void main(String[] args) {
        // referenciar a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();
        // select
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l", Libro.class);
        // SELECT WHERE - comparativos ( > < =)
        //TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l where l.autor = :autor", Libro.class);
        //query.setParameter("autor","Claudia");
        //
        //TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l where l.precio > :precio", Libro.class);
        //query.setParameter("precio",50);
        // SELECT WHERE - between
        //TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l where l.precio between :inicio and :fin", Libro.class);
        //query.setParameter("inicio",30);
        //query.setParameter("fin",50);
        // SELECT WHERE - in
        //TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l where l.autor in ('Cesar', 'Claudia')", Libro.class);
        // SELECT WHERE - escalares
        //TypedQuery<String> query = em.createQuery("SELECT l.autor FROM Libro l where l.autor in ('Cesar', 'Claudia')", String.class);
        //
        // SELECT WHERE - escalares con distinct
        //TypedQuery<String> query = em.createQuery("SELECT distinct l.autor FROM Libro l where l.autor in ('Cesar', 'Claudia')", String.class);
        //
        // SELECT WHERE - escalares con distinct con upper
        //TypedQuery<String> query = em.createQuery("SELECT distinct upper(l.autor) FROM Libro l where l.autor in ('Cesar', 'Claudia')", String.class);
        // SELECT WHERE IS NULL
        //TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l where l.autor is null", Libro.class);
        // SELECT LIKE (empiezan por c)
        //TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l where l.titulo like 'c%'", Libro.class);

        // SELECT ORDER BY
        //TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l order by l.precio", Libro.class);
        // SELECT GROUP BY
        //TypedQuery<Object[]> query = em.createQuery("SELECT l.autor, count(l) FROM Libro l group by l.autor", Object[].class);
        //        List<Object[]> resultado = query.getResultList();
        //        resultado.forEach(elemento -> System.out::println("Autor: " + elemento[0] + " -- " + "Cantidad: " + elemento[1]));

        // obtener resultados
        List<Libro> resultado = query.getResultList();
        resultado.forEach(System.out::println);
        //resultado.forEach(item -> System.out.println(item.getTitulo()));
    }
}
