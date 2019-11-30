package com.gulrecep.issuemanegement.util;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class TPage<T> {
    private  int number;
    private  int size;
    private Sort sort;
    private  int totalPage;
    private  Long totalElements; //toplamda kaç kayıt
    private List<T> content; // doneceğim data

    public void setStat(Page page, List<T> list){
        this.number= page.getNumber();
        this.size= page.getSize();
        this.sort=page.getSort();
        this.totalPage=page.getTotalPages();
        this.totalElements=page.getTotalElements();
        this.content=list;
    }
}
