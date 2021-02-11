package tn.esprit.bookstore.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.entities.User;
import tn.esprit.bookstore.entities.utils.MyUserDetails;
import tn.esprit.bookstore.repository.UserRepository;
import tn.esprit.bookstore.services.IUserService;

import java.util.List;

@Service
public class UserService implements IUserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if(user.getPassword() != null)
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if(user == null)
            throw new UsernameNotFoundException("");
        return new MyUserDetails(user);
    }

    @Override
    public User getAuthenticatedCustomer() {
        {
            // TODO Auto-generated method stub

            return userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        }
    }




}
