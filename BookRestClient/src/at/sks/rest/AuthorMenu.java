package at.sks.rest;

import at.sks.rest.entities.Author;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alex
 */
public class AuthorMenu {
    private List<Author> authors = new ArrayList<>();
    WebTarget authorTarget = ClientBuilder
            .newClient()
            .register(new RequestFilter("writer", "123"))
            .target("http://localhost:8080/BookService_war_exploded/resources/author");

    public void readAuthors(){
        while(true){
            Author author = new Author();
            author.setFirstName(read("First name"));
            author.setLastName(read("Last name"));
            author.setCountry(read("Country"));
            authors.add(author);
            String yes = read("Create another author? (y/n)");
            if(yes != null && !yes.equals("y")) break;
        }
        sendAuthors();
    }

    private void sendAuthors() {


        for(Author author : authors) {
            Response response = authorTarget
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(author, MediaType.APPLICATION_JSON));
            if(response.getStatus() >= 300){
                System.out.println("Error: " + response.getStatusInfo().getReasonPhrase());
                return;
            }
        }
    }

    private String read(String label){
        Scanner in = new Scanner(System.in);
        System.out.print(label + ": ");
        return in.nextLine();
    }
}
