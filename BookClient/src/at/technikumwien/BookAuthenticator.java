package at.technikumwien;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class BookAuthenticator {
    private BookAuthenticator() {}

    public static void setAsDefault(String username, String password) {
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password.toCharArray());
            }
        });
    }
}