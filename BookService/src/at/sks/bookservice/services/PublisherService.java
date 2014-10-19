package at.sks.bookservice.services;

import at.sks.bookservice.entities.Book;
import at.sks.bookservice.entities.Publisher;

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
public class PublisherService {
    @PersistenceContext
    private EntityManager em;

    public List<Publisher> getAllPublisher(){
        return em.createNamedQuery("Publisher.selectAll", Publisher.class).getResultList();
    }
}
