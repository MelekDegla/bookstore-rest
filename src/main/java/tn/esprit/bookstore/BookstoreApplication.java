package tn.esprit.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import tn.esprit.bookstore.entities.User;

@SpringBootApplication()
public class BookstoreApplication {

    public static void main(String[] args) {

        SpringApplication.run(BookstoreApplication.class, args);
    }

}
