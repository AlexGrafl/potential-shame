package at.sks.bookservice.services;

import at.sks.bookservice.entities.Book;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Alex
 */
@Stateless
@LocalBean
public class BookService {
    @PersistenceContext
    private EntityManager em;

    public List<Book> getAllBooks(){
        return em.createNamedQuery("Book.selectAll", Book.class).getResultList();
    }
}
