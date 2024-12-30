package com.xproce.dao.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id @GeneratedValue
    private Long id;
    private String email;
    @Column(name = "pwd")
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
