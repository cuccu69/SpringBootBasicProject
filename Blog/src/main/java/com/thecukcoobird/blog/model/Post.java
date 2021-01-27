package com.thecukcoobird.blog.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 64)
    private String title;

    @Column
    private String content;

    @OneToMany
    private List<Comment> listComment;

    @Transient
    private Timestamp createTime;
}
