package tn.esprit.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.esprit.bookstore.entities.User;

@SpringBootApplication
@EnableScheduling
public class BookstoreApplication {

    public static void main(String[] args) {
        User user = new User();

        SpringApplication.run(BookstoreApplication.class, args);
    }

}
