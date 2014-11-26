package at.sks.bookservice.rest;

import at.sks.bookservice.entities.Author;
import at.sks.bookservice.services.AuthorService;

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

@Path("/author")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({MediaType.APPLICATION_JSON})
public class AuthorResource {

    @Inject
    private AuthorService authorService;

    @Context
    UriInfo ui;

    @GET
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GET
    @Path("/{id}")
    public Author readAuthorById(@PathParam("id") long id){
        return authorService.read(id);
    }

    @POST
    public Response createAuthor(Author author) {

        authorService.create(author);

        URI newsURI = ui.getAbsolutePathBuilder().path(author.getId().toString()).build();
        return Response.created(newsURI).build();
    }


    @PUT
    @Path("/{id}")
    public Response updateAuthor(@PathParam("id") long id, Author author){
        authorService.update(id, author);

        URI newsURI = ui.getAbsolutePathBuilder().path(author.getId().toString()).build();
        return Response.created(newsURI).build();
    }

    @DELETE
    @Path("/{id}")
    public void deleteAuthor(@PathParam("id") long id) {
        authorService.delete(id);
    }
}
