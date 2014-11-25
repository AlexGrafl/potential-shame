package at.sks.bookservice.rest;

import at.sks.bookservice.entities.Book;
import at.sks.bookservice.entities.Publisher;
import at.sks.bookservice.services.BookService;
import at.sks.bookservice.services.PublisherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

/**
 * Created by Victor on 07.11.2014.
 */

@Path("/publisher")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({MediaType.APPLICATION_JSON})
public class PublisherResource {

    @Inject
    private PublisherService publisherService;

    @Context
    UriInfo ui;

    @GET
    public List<Publisher> getAllPublisher() {
        return publisherService.getAllPublisher();
    }

    @GET
    @Path("/{id}")
    public Publisher readPublisherById(@PathParam("id") long id){
        return publisherService.read(id);
    }

    @POST
    public Response createPublisher(Publisher publisher) {

        publisherService.create(publisher);

        URI newsURI = ui.getAbsolutePathBuilder().path(publisher.getId().toString()).build();
        return Response.created(newsURI).build();
    }


    @PUT
    @Path("/{id}")
    public Response updatePublisher(@PathParam("id") long id, Publisher publisher){
        publisherService.update(id, publisher);

        URI newsURI = ui.getAbsolutePathBuilder().path(publisher.getId().toString()).build();
        return Response.created(newsURI).build();
    }

    @DELETE
    @Path("/{id}")
    public void deletePublisher(@PathParam("id") long id) {
        publisherService.delete(id);
    }
}
