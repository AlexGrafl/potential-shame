package at.sks.bookservice.beans;

import at.sks.bookservice.entities.Publisher;
import at.sks.bookservice.services.PublisherService;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * @author Alex
 */
@ApplicationScoped
@Named("appPublisher")
public class PublisherManaged {
    @Inject
    private PublisherService service;

    public List<Publisher> getAllPublisher(){
        return service.getAllPublisher();
    }

}
