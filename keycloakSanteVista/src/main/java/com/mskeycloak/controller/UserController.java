package com.mskeycloak.controller;

import com.mskeycloak.model.User;
import com.mskeycloak.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/keycloak/users")
public class UserController {

    private final IUserService userService;


    @GetMapping("/find")
    public ResponseEntity<User> getByUsername(@RequestParam String username) {
        log.debug("REST request to get User : {}", username);
        User user = userService.findByUsername(username);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable String id) {
        log.debug("REST request to get User : {}", id);
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/")
    public List<User> getAll() {
        log.debug("REST request to get all Users");
        return userService.findAll();
    }


    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody @Valid User user) {
        log.info("REST request to save User : {}", user.getRoles());
        User userCreated = userService.create(user);
        return ResponseEntity.status(201).body(userCreated);
    }


    @PostMapping(value = "/toggleUserEnabled/{id}")
    public ResponseEntity<User> toggleUserEnabled(@PathVariable String id) {
        ;
        return ResponseEntity.ok().body(userService.toggleUserEnabled(id));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        log.debug("REST request to delete User : {}", id);
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/update")
    public ResponseEntity<User> update(@RequestBody @Valid User user) {
        log.debug("REST request to update User : {}", user.getUsername());
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

}
