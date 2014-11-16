package at.sks.rest;

import at.sks.rest.entities.Author;
import at.sks.rest.entities.Publisher;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        int menu;
        do {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("1 - Create Author(s)\n2 - Create Publisher(s)\n3 - Quit");
            try {
                menu = Integer.parseInt(br.readLine());
            }catch (NumberFormatException ignore){
                menu = 5;
            }
            switch (menu) {
                case 1:
                    AuthorMenu authorMenu = new AuthorMenu();
                    authorMenu.readAuthors();
                    break;
                case 2:
                    PublisherMenu publisherMenu = new PublisherMenu();
                    publisherMenu.readPublisher();
                    break;
                case 3: return;
                default: System.out.println("Invalid choice!");
            }
        }while(true);
    }
}
