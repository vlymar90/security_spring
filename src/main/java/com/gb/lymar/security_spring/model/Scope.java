package com.gb.lymar.security_spring.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "user_scope")
public class Scope {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int scope;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
