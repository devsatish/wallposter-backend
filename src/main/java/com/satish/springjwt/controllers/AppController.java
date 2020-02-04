package com.satish.springjwt.controllers;

import com.satish.springjwt.models.Post;
import com.satish.springjwt.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/app")
public class AppController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }


    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }



    @GetMapping("/friends")
        public ResponseEntity<Iterable<Post>> myfriends() {
      return new ResponseEntity<Iterable<Post>>(postRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping("/posts")
    public ResponseEntity<Iterable<Post>> allPosts() {



        return new ResponseEntity<Iterable<Post>>(postRepository.findAll(), HttpStatus.OK);
    }




    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
