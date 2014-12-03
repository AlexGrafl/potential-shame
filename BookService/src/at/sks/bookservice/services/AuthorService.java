package at.sks.bookservice.services;

import at.sks.bookservice.entities.Author;
import at.sks.bookservice.entities.Publisher;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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

    @Override
    void merge(Author oldEntity, Author newEntity) {
        if(!oldEntity.getFirstName().equals(newEntity.getFirstName())) oldEntity.setFirstName(newEntity.getFirstName());
        if(!oldEntity.getLastName().equals(newEntity.getLastName())) oldEntity.setLastName(newEntity.getLastName());
        if(oldEntity.getBirthDate() != newEntity.getBirthDate()) oldEntity.setBirthDate(newEntity.getBirthDate());
        if(!oldEntity.getCountry().equals(newEntity.getCountry())) oldEntity.setCountry(newEntity.getCountry());
    }
}
