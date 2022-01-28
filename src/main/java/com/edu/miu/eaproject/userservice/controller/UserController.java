package com.edu.miu.eaproject.userservice.controller;

import com.edu.miu.eaproject.userservice.domain.Comments;
import com.edu.miu.eaproject.userservice.domain.Post;
import com.edu.miu.eaproject.userservice.domain.Users;
import com.edu.miu.eaproject.userservice.proxy.UserServiceProxy;
import com.edu.miu.eaproject.userservice.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private UserServiceProxy userServiceProxy;



    @GetMapping
    public List<Users> findAll() {

        return usersService.getAll();
    }

    @GetMapping("/{id}")
    public Users getById(@PathVariable Long id) {

        return usersService.getById(id);
    }

    @PostMapping
    public Users create(@RequestBody Users user) {

        return usersService.create(user);
    }
   @PutMapping("/{id}")
    public Users update(@RequestBody Users user, @PathVariable long id) {
       if (! usersService.existsById(id)) {
           System.out.println("PUT ERROR : User with ID" + id + " not found");
           throw new IllegalArgumentException();
       }
       user.setId(id);
       return usersService.update(user);
    }
    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Long id){

        usersService.deleteById(id);
    }

    // User posts
    @GetMapping("/{id}/comments")
    public List<Comments> getAllCommentsByUserId(@PathVariable Long id) {

        return userServiceProxy.getCommentsByUserId(id);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getUserPosts(@PathVariable Long userId) {

        return userServiceProxy.getPosts(userId);
    }


}
