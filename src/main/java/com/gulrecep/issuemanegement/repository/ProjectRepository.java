package com.gulrecep.issuemanegement.repository;

import com.gulrecep.issuemanegement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    /*
    SOLİD prensipleri . bi klas her şeyi yapmasın her class kendi işini yüklensin
       get yada find ile başlar metodlar. repositorylerde. kendimiz yazacaksak !!

       2- sadece CRUD işlemi yapılacaksa JPS repository yerine Crud REpository de eklenebilirdi.
    */

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);
}
