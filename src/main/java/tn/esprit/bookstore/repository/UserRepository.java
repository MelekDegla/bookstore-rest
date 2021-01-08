package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
