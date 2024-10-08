package com.social.media.controller;


import com.social.media.entity.SocialUser;
import com.social.media.service.SocialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/social")
public class SocialController {
    @Autowired
    private SocialServiceImpl socialServiceimpl;

    @GetMapping("/users")
    public ResponseEntity<List<SocialUser>> getUsers() {
        return new ResponseEntity<List<SocialUser>>(socialServiceimpl.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser) {

        return new ResponseEntity<SocialUser>(socialServiceimpl.saveUser(socialUser), HttpStatus.CREATED);

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> getUsers(@PathVariable Long id) {
        socialServiceimpl.deleteUser(id);
        return new ResponseEntity<>("RESOURCE HAS BEEN DELETE SUCCESSFULLY!!", HttpStatus.ACCEPTED);

    }
}
