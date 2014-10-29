package at.sks.bookservice.services;

import at.sks.bookservice.entities.Publisher;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Alex
 */
@Transactional
@Stateful
public class PublisherService extends AbstractEntityService<Publisher> {

    public PublisherService() {
        super(Publisher.class);
    }

    public List<Publisher> getAllPublisher(){
        return entityManager.createNamedQuery("Publisher.selectAll").getResultList();
    }

    @Override
    protected void checkConstrains(Publisher entity) { }

    @Override
    protected void assignEntityValues(Publisher from, Publisher to) {
        to.setName(from.getName());
        to.setCountryCode(from.getCountryCode());
        to.setPostCode(from.getPostCode());
    }
}
