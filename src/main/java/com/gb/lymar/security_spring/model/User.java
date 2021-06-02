package com.gb.lymar.security_spring.model;

import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    @OneToOne(mappedBy = "user")
    private Scope scope;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<Roles> rolesList;
}
