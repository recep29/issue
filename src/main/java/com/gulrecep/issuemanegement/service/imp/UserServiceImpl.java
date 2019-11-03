package com.gulrecep.issuemanegement.service.imp;

import com.gulrecep.issuemanegement.entity.User;
import com.gulrecep.issuemanegement.repository.UserRepository;
import com.gulrecep.issuemanegement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user.getEmail()==null){
            throw new IllegalArgumentException("can not be Email");
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> getByUsername(String username) {
        return  userRepository.findByUsername(username);
    }

    @Override
    public List<User> getByNameSurname(String nameSurname) {
        return userRepository.findByNameSurname(nameSurname);
    }
}
