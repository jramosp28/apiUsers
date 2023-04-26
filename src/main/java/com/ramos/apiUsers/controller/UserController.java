package com.ramos.apiUsers.controller;

import com.ramos.apiUsers.model.User;
import com.ramos.apiUsers.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author javierrampob
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        try {
            User user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/user")
    public void newUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> editUser(@RequestBody User user, @PathVariable Integer id) {
        try {
            User userExist = userService.getUserById(id);
            userExist.setName(user.getName());
            userExist.setLastName(user.getLastName());
            userExist.setLastName2(user.getLastName2());
            userExist.setEmail(user.getEmail());
            userExist.setPhone(user.getPhone());
            userExist.setAddress(user.getAddress());
            userExist.setCity(user.getCity());
            userExist.setDate(user.getDate());
            userExist.setBikeModel(user.getBikeModel());
            userService.saveUser(userExist);
            ResponseEntity<User> userResponseEntity = new ResponseEntity<>(user, HttpStatus.OK);
            return userResponseEntity;
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.removeUser(id);
    }
}
