package tn.esprit.bookstore.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tn.esprit.bookstore.entities.User;


import java.util.List;

public interface IUserService {
    public User save(User user);
    public User findById(Long id);
    public List<User> findAll();
    public void deleteById(Long id);

   public User getAuthenticatedCustomer();
}
