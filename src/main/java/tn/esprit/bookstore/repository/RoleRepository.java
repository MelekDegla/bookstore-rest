package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    public Role findByName(String name);
}
