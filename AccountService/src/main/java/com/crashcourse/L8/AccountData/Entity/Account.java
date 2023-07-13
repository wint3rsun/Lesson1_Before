package com.crashcourse.L8.AccountData.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String email;

    private String mobNo;

    private String roles;

    @OneToOne(mappedBy = "personId",cascade = CascadeType.ALL)
    private AuthRecord authRecord;
}
