package com.satish.springjwt.models;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "post")
public class Post extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//    @Column(name = "\"user_id\"", nullable = true)
//    private Long userId;

    private String content;

    @Column(name = "\"created_at\"", nullable = false)
    private Timestamp createdAt;


    @Column(name = "\"updated_at\"", nullable = false)
    private Timestamp updatedAt;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("user_id")
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


 }
