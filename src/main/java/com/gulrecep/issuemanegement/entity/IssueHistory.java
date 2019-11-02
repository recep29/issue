package com.gulrecep.issuemanegement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity //jpa'den gelen bir database tablosu olduğunu belirtiyoruz.
@Table(name = "issue_history") // burada tablo özelliklerini veriyoruz tabloya bir isim veriyoruz.
// (kullanmak zorunlu değil kullanmadığımız zaman tablonun ismi class ismiyle aynı olur)
@Data // otomatik olarak getter ve setter yaratıyor (lomboktan geliyor)
@NoArgsConstructor // boş bir constructor yaratıyor (lomboktan geliyor)
@AllArgsConstructor // tüm fieldlar kullanılarak yapılmış const. lomboktan geliyor
@ToString // to stringi yaratıyor
@EqualsAndHashCode // equals ve hashcode metodunu overwrite ediyor.
public class IssueHistory extends BaseEntity {

    @Id //bu tabloda id olduğunu gösteriyoruz.
    @GeneratedValue(strategy = GenerationType.AUTO) // burada otomatik olarak artan bir id veriliyor.
    private Long id;

    @Column(name = "description", length = 100)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @Column(name = "details")
    private String details;

    @JoinColumn(name = "issue_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Issue issue;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User assignee;

}