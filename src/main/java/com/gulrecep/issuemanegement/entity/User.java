package com.gulrecep.issuemanegement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity //jpa'den gelen bir database tablosu olduğunu belirtiyoruz.
@Table(name = "users") // burada tablo özelliklerini veriyoruz tabloya bir isim veriyoruz.
// (kullanmak zorunlu değil kullanmadığımız zaman tablonun ismi class ismiyle aynı olur)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uname",length = 100, unique = true)
    private String username;

    @Column(name = "pwd",length = 200)
    private String password;

    @Column(name = "name_surname", length = 100)
    private String nameSurname;

    @Column(name = "email", length = 100)
    private String email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issues;

}
