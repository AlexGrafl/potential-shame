package at.sks.bookservice.services;

import at.sks.bookservice.entities.Publisher;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author Alex
 */
@Stateless
@LocalBean
public class PublisherService extends AbstractEntityService<Publisher> {

    public PublisherService() {
        super(Publisher.class);
    }

    public List<Publisher> getAllPublisher(){
        return entityManager.createNamedQuery("Publisher.selectAll").getResultList();
    }

    @Override
    void merge(Publisher oldEntity, Publisher newEntity) {
        if(!oldEntity.getName().equals(newEntity.getName())) oldEntity.setName(newEntity.getName());
        if(!oldEntity.getCountryCode().equals(newEntity.getCountryCode())) oldEntity.setCountryCode(newEntity.getCountryCode());
        if(!oldEntity.getPostCode().equals(newEntity.getPostCode())) oldEntity.setPostCode(newEntity.getPostCode());
    }
}
