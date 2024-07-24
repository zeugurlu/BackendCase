package com.innova.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
//import lombok.Getter;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.Setter;

import java.util.List;

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Data
public class Users {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Transactions> transactions;
}
