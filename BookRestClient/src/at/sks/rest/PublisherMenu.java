package at.sks.rest;

import at.sks.rest.entities.Publisher;

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
public class PublisherMenu {
    private List<Publisher> publishers = new ArrayList<>();

    WebTarget publisherTarget = ClientBuilder
            .newClient()
            .register(new RequestFilter("writer", "123"))
            .target("http://localhost:8080/BookService_war_exploded/resources/publisher");

    public void readPublisher(){
        while(true){
            Publisher publisher = new Publisher();
            publisher.setName(read("Name"));
            publisher.setCountryCode(read("Country code"));
            publisher.setPostCode(read("Post code"));
            publishers.add(publisher);
            String yes = read("Create another author? (y/n)");
            if(yes != null && !yes.equals("y")) break;
        }
        sendPublisher();
    }

    private void sendPublisher() {

        for(Publisher publisher : publishers) {
            Response response = publisherTarget
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(publisher, MediaType.APPLICATION_JSON));
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
