package com.gulrecep.issuemanegement.entity;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

//java io nesnenşin networkten taşınabilmesi veya diske yazılması yeteneği kazanması için seriazible kullandık.
@Data //Lombok'tan geliyor, getter ve setter yapmamıza gerek kalmıyor
@MappedSuperclass//JPA'dan gelen bütün tablolarda ortak olmasını sağlıyor.
// (devam)Diğer classlarda extend edilebilir hale geliyor.
public abstract class BaseEntity implements Serializable {

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreateAt;
    @Column(name = "created_by", length = 50)
    private String CreatedBy;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date UpdatedAt;
    @Column(name = "updated_by", length = 50)
    private String UpdatedBy;
    @Column(name = "status")
    private Boolean status;


}
//  1- bu class ın bazı ozelliklerini override etmek isteyebiliriz miras aldığımız classlarda.
// bu yuzden abtract bir class olması gerekyor.
// 2- Column Anotationu JPA dan gelir ve veritabanında ki özellikleri belirtilir.
