package tn.esprit.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.esprit.bookstore.entities.Role;
import tn.esprit.bookstore.entities.User;
import tn.esprit.bookstore.services.IRoleService;
import tn.esprit.bookstore.services.implementation.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class BookstoreApplication {

    @Autowired
    UserService userService;

    @Autowired
    IRoleService roleService;

    public static void main(String[] args) {

        SpringApplication.run(BookstoreApplication.class, args);
    }

    @PostConstruct
    public void init(){
        if(roleService.findAll().isEmpty()){
            roleService.save(new Role(null, "admin"));
            roleService.save(new Role(null, "order_receiver"));
            roleService.save(new Role(null, "delivery_man"));
            roleService.save(new Role(null, "user"));
        }
        if(userService.findAll().isEmpty()){
            List<Role> rolesAdmin = new ArrayList<>();
            rolesAdmin.add(roleService.findByName("admin"));
            userService.save(new User("admin", "admin", rolesAdmin ));
        }





        }


}
