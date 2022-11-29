package com.project.sejmet.controllers;

import com.project.sejmet.entities.User;
import com.project.sejmet.repository.UserRepository;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping
    public List<User> getProductoAll() {

        return userRepository.findAll();
    }


    @GetMapping("/{id}")
    public User getUsersbyId(@PathVariable int id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        }

        return null;
    }


    @PostMapping
    public User postUsers(@RequestBody User user) {

        userRepository.save(user);

        return user;
    }


    @PutMapping("/{id}")
    public User putUsersbyId(@PathVariable int id, @RequestBody User user) {

        Optional<User> userCurrent = userRepository.findById(id);

        if (userCurrent.isPresent()) {

            User userReturn = userCurrent.get();

            userReturn.setAddress(user.getAddress());
            userReturn.setUserName(user.getUserName());
            userReturn.setTypeIdentityCard(user.getTypeIdentityCard());
            userReturn.setIdentityCardNumber(user.getIdentityCardNumber());
            userReturn.setEmail(user.getEmail());
            userReturn.setPassword(user.getPassword());
            userReturn.setAddress(user.getAddress());

            userRepository.save(userReturn);

            return userReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public User deleteUsersbyId(@PathVariable int id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {

            User userReturn = user.get();

            userRepository.deleteById(id);

            return userReturn;
        }

        return null;
    }
}
