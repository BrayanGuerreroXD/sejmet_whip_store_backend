package com.project.sejmet.controllers;

import com.project.sejmet.entities.Role;
import com.project.sejmet.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;


    @GetMapping
    public List<Role> getRoleAll() {
        return roleRepository.findAll();
    }


    @GetMapping("/{id}")
    public Role getRolebyId(@PathVariable int id) {

        Optional<Role> role = roleRepository.findById(id);

        if (role.isPresent()) {
            return role.get();
        }

        return null;
    }


    @PostMapping
    public Role postRole(@RequestBody Role role) {
        roleRepository.save(role);
        return role;
    }


    @PutMapping("/{id}")
    public Role putRolebyId(@PathVariable int id, @RequestBody Role role) {

        Optional<Role> roleCurrent = roleRepository.findById(id);

        if (roleCurrent.isPresent()) {
            Role roleReturn = roleCurrent.get();
            roleReturn.setRoleName(role.getRoleName());
            roleRepository.save(roleReturn);
            return roleReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Role deleteRolebyId(@PathVariable int id) {

        Optional<Role> role = roleRepository.findById(id);

        if (role.isPresent()) {
            Role roleReturn = role.get();
            roleRepository.deleteById(id);
            return roleReturn;
        }

        return null;
    }
}
