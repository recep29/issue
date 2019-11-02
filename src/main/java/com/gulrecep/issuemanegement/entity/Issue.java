package com.gulrecep.issuemanegement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity //jpa'den gelen bir database tablosu olduğunu belirtiyoruz.
@Table(name = "issue") // burada tablo özelliklerini veriyoruz tabloya bir isim veriyoruz.
// (kullanmak zorunlu değil kullanmadığımız zaman tablonun ismi class ismiyle aynı olur)
@Data // otomatik olarak getter ve setter yaratıyor (lomboktan geliyor)
@NoArgsConstructor // boş bir constructor yaratıyor (lomboktan geliyor)
@AllArgsConstructor // tüm fieldlar kullanılarak yapılmış const. lomboktan geliyor
@ToString // to stringi yaratıyor
@EqualsAndHashCode // equals ve hashcode metodunu overwrite ediyor.
public class Issue extends BaseEntity {

    @Id //bu tabloda id olduğunu gösteriyoruz.
    @GeneratedValue(strategy = GenerationType.AUTO) // burada otomatik olarak artan bir id veriliyor.
    private Long id;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    private Date date;

    @Column(name = "issueStatus")
    @Enumerated(EnumType.STRING)
    //enum olan verileri böyle tanımlıyoruz
    // (STRING diyerek enum verilerinin strinlerini tutuyoruz fakat böylelikle daha fazla yer kaplıyor,
    //eğer ORDINAL yaparsak indisleri tutuyor böylelikle daha az yer kaplıyor
    // fakat araya başka bir veri girerse indisler kayacağından sorunlar ortaya çıkabilir)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id") // bir tablodan başka bir tabloya relation tanımı yapıyorsanız kullanıyoruz
    @ManyToOne(optional = true, fetch = FetchType.LAZY) // bir çok issue classı bir tane user'a ilişkilendirilebilir
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Project project;


}

//bu classın entity olmasını sağlayan mın gereksinimm: Id ve Entity anatotaion u olması