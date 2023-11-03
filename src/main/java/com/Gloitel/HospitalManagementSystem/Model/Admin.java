package com.Gloitel.HospitalManagementSystem.Model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String adminId;

    String password;
}
