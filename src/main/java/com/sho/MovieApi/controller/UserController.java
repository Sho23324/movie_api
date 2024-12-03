package com.sho.MovieApi.controller;

import java.net.URI;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sho.MovieApi.model.User;
import com.sho.MovieApi.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getUsers() {
        Iterable<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        URI new_user_location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{resourceId}")
        .buildAndExpand(createdUser.getId())
        .toUri();
        return ResponseEntity.created(new_user_location).build();
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<Void> updateUesr(@PathVariable Long userId, @RequestBody User user) {
        try {
            userService.updateUser(userId, user);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/users/{userId}") 
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
