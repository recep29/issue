package com.gulrecep.issuemanegement.repository;

import com.gulrecep.issuemanegement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByUsername(String username);
    List<User> findByNameSurname(String nameSurname);
    Page<User> findAll(Pageable pageable);

    List<User> findAll(Sort sort);

}
