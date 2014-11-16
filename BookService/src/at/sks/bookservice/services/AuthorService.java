package at.sks.bookservice.services;

import at.sks.bookservice.entities.Author;
import at.sks.bookservice.entities.Publisher;

import javax.ejb.Stateful;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Alex
 */
@Transactional
@Stateful
public class AuthorService extends AbstractEntityService<Author> {

    public AuthorService() {
        super(Author.class);
    }

    public List<Author> getAllAuthors(){
        return entityManager.createNamedQuery("Author.selectAll").getResultList();
    }
}
