package com.gulrecep.issuemanegement.service;

import com.gulrecep.issuemanegement.dto.UserDto;
import com.gulrecep.issuemanegement.entity.Issue;
import com.gulrecep.issuemanegement.entity.User;
import com.gulrecep.issuemanegement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    List<UserDto> getByUsername(String username);

    List<UserDto> getByNameSurname(String nameSurname);

}
