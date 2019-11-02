package com.gulrecep.issuemanegement.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity //jpa'den gelen bir database tablosu olduğunu belirtiyoruz.
@Table(name = "project") // burada tablo özelliklerini veriyoruz tabloya bir isim veriyoruz.
// (kullanmak zorunlu değil kullanmadığımız zaman tablonun ismi class ismiyle aynı olur)
@Data // otomatik olarak getter ve setter yaratıyor (lomboktan geliyor)
@NoArgsConstructor // boş bir constructor yaratıyor (lomboktan geliyor)
@AllArgsConstructor // tüm fieldlar kullanılarak yapılmış const. lomboktan geliyor
@ToString // to stringi yaratıyor
@EqualsAndHashCode // equals ve hashcode metodunu overwrite ediyor.
public class Project extends BaseEntity {

    @Id //bu tabloda id olduğunu gösteriyoruz.
    @GeneratedValue(strategy = GenerationType.AUTO) // burada otomatik olarak artan bir id veriliyor.
    private Long id;

    @Column(name = "project_code", unique = true)
    private String projectCode;

    @Column(name = "project_name", length = 100)
    private String projectName;

    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User manager;


}
