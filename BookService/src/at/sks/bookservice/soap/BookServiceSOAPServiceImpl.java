package at.sks.bookservice.soap;

import at.sks.bookservice.entities.Publisher;
import at.sks.bookservice.services.PublisherService;

import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

/**
 * @author Alex
 */
@WebService(endpointInterface = "at.sks.bookservice.soap.BookServiceSOAPService")
public class BookServiceSOAPServiceImpl implements BookServiceSOAPService {
    @Inject
    private PublisherService service;

    @Override
    public List<Publisher> getAllPublishers() {
        return service.getAllPublisher();
    }
}
