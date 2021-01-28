package com.thecukcoobird.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 64)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "post_id")
    private List<Comment> listComment = new ArrayList<>();
    public void addComment(Comment comment){
        listComment.add(comment);
        comment.setPost(this);
    }
    public void removeComment(Comment comment){
        listComment.remove(comment);
        comment.setPost(null);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private User Author;

    private LocalDateTime createTime;
    @PrePersist
    public void prePersist(){
        createTime = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        modified = true;
    }

    private boolean modified = false;
}
