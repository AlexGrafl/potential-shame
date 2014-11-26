package at.sks.bookservice.services;

import at.sks.bookservice.entities.Author;
import at.sks.bookservice.entities.Publisher;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Alex
 */
@Stateless
@LocalBean
public class AuthorService extends AbstractEntityService<Author> {

    public AuthorService() {
        super(Author.class);
    }

    public List<Author> getAllAuthors(){
        return entityManager.createNamedQuery("Author.selectAll").getResultList();
    }
}
