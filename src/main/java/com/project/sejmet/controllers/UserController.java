package com.project.sejmet.controllers;

import com.project.sejmet.entities.User;
import com.project.sejmet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public User getUsersbyEmail(@PathVariable int id) {

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
    public User putUsersbyEmail(@PathVariable int id, @RequestBody User user) {

        Optional<User> userCurrent = userRepository.findById(id);

        if (userCurrent.isPresent()) {

            User userReturn = userCurrent.get();

            userReturn.setAddress(user.getAddress());
            userReturn.setName(user.getName());

            userRepository.save(userReturn);

            return userReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public User deleteUsersbyEmail(@PathVariable int id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {

            User userReturn = user.get();

            userRepository.deleteById(id);

            return userReturn;
        }

        return null;
    }
}
