package pe.edu.cibertec.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.domain.Categoria;
import pe.edu.cibertec.domain.Libro;

import java.util.Arrays;
import java.util.Date;

public class JPAOneToMany {
    public static void main(String[] args) {
        // referenciar a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();
        // crear categoria
        Categoria categoria = new Categoria("C6","Terror",null);
        // crear libros
        Libro libro1 = new Libro("A11","Titulo 11","Autor11",new Date(),50.20,categoria);
        Libro libro2 = new Libro("A12","Titulo 12","Autor12",new Date(),50.21,categoria);
        Libro libro3 = new Libro("A13","Titulo 13","Autor13",new Date(),50.22,categoria);
        //referencia libros en categoria
        categoria.setLibros(Arrays.asList(libro1,libro2,libro3));
        // persist
        em.getTransaction().begin();
        em.persist(categoria);
        em.persist(libro1);
        em.persist(libro2);
        em.persist(libro3);
        em.getTransaction().commit();

    }
}
