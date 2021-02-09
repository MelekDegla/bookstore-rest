package tn.esprit.bookstore.services;

import tn.esprit.bookstore.entities.Role;

import java.util.List;

public interface IRoleService {

    public Role save(Role role);
    public List<Role> findAll();
    public Role findRoleById(Long id);

    public Role findByName(String name);

}
