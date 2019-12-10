package com.gulrecep.issuemanegement.service.imp;

import com.gulrecep.issuemanegement.dto.UserDto;
import com.gulrecep.issuemanegement.entity.User;
import com.gulrecep.issuemanegement.repository.UserRepository;
import com.gulrecep.issuemanegement.service.UserService;
import com.gulrecep.issuemanegement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto save(UserDto user) {
        if (user.getEmail() == null) {
            throw new IllegalArgumentException("can not be Email");
        }
        User u = modelMapper.map(user, User.class);
        u = userRepository.save(u);


        return modelMapper.map(u, UserDto.class);
    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.getOne(id);
        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> getAll() {
        List<User> data = userRepository.findAll();
        return Arrays.asList(modelMapper.map(data, UserDto[].class));

    }
    @Override
    public TPage<UserDto> getAllPageable(Pageable pageable) {
        // veritabanından entity yardımı ile tüm verileri cektik. ancak frontente modelmapper yardımı ile map edip dtosu üzerinden kendi page miz ile set ettik.
        Page<User> data = userRepository.findAll(pageable);
        TPage<UserDto> response = new TPage<UserDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), UserDto[].class)));
        return response;
    }


    @Override
    public List<UserDto> getByUsername(String username) {
        List<User> users = userRepository.findByUsername(username);
        return Arrays.asList(modelMapper.map(users, UserDto.class));
    }

    @Override
    public List<UserDto> getByNameSurname(String nameSurname) {
        List<User> users = userRepository.findByNameSurname(nameSurname);
        return Arrays.asList(modelMapper.map(users, UserDto.class));
    }


}
