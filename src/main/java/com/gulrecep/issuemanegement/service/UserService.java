package com.gulrecep.issuemanegement.service;

import com.gulrecep.issuemanegement.entity.Issue;
import com.gulrecep.issuemanegement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User save(User user);

    User getById(Long id);

    Page<User> getAllPageable(Pageable pageable);

    List<User> getByUsername(String username);

    List<User> getByNameSurname(String nameSurname);

}
