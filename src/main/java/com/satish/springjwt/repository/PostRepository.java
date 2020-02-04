package com.satish.springjwt.repository;

import com.satish.springjwt.models.Post;
import com.satish.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

        List<Post> findAll();

        List<Post> findAllByUserId(Long userId);
}
