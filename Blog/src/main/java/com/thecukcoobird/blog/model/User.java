package com.thecukcoobird.blog.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String fullName;

    @Column(nullable = false, unique = true)
    @NaturalId
    private String email;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birthDay;
}
