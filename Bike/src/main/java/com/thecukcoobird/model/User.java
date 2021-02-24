package com.thecukcoobird.model;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(unique = true)
    private String email;

    @Column(length = 10)
    private String phone;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'USER'")
    private String role;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    private String avatar;

    @Transient
    private String fullname;
}
