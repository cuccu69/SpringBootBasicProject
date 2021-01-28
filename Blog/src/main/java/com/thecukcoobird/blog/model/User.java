package com.thecukcoobird.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 64)
    private String fullName;

    @Column(nullable = false, unique = true)
    @NaturalId
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private List<Post> listPost = new ArrayList<>();
    public void addPost(Post post){
        listPost.add(post);
        post.setAuthor(this);
    }
    public void removePost(Post post){
        listPost.remove(post);
        post.setAuthor(null);
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Comment> listComment = new ArrayList<>();
    public void addComment(Comment comment){
        listComment.add(comment);
        comment.setCommentor(this);
    }
    public void removeComment(Comment comment){
        listComment.remove(comment);
        comment.setCommentor(null);
    }
}
