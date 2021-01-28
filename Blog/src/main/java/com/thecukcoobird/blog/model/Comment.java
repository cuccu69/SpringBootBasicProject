package com.thecukcoobird.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User commentor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    LocalDateTime createTime;
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
