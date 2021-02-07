package tn.esprit.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.esprit.bookstore.entities.User;
import tn.esprit.bookstore.services.implementation.UserService;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
public class BookstoreApplication {

    @Autowired
    UserService userService;

    public static void main(String[] args) {

        SpringApplication.run(BookstoreApplication.class, args);
    }

    @PostConstruct
    public void init(){
        if(userService.findAll().isEmpty())
            userService.save(new User("admin", "admin"));
    }

}
