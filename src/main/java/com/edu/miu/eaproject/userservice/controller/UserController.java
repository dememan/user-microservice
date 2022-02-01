package com.edu.miu.eaproject.userservice.controller;

import com.edu.miu.eaproject.userservice.aspect.Auditable;
import com.edu.miu.eaproject.userservice.domain.Users;
import com.edu.miu.eaproject.userservice.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersService usersService;


    @GetMapping
    public List<Users> findAll() {

        return usersService.getAll();
    }

    @GetMapping("/{id}")
    public Users getById(@PathVariable Long id) {
        return usersService.getById(id);
    }

    @GetMapping(value = "/username/{username}")
    public Users getById(@PathVariable String username) {
        return usersService.getByUserName(username);
    }

    @Auditable
    @PostMapping
    public Users create(@RequestBody Users user) {

        return usersService.create(user);
    }
    @Auditable
    @PutMapping("/{id}")
    public Users update(@RequestBody Users user, @PathVariable long id) {
        if (!usersService.existsById(id)) {
            System.out.println("PUT ERROR : User with ID" + id + " not found");
            throw new IllegalArgumentException();
        }
        user.setId(id);
        return usersService.update(user);
    }
    @Auditable
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        usersService.deleteById(id);
    }

}
