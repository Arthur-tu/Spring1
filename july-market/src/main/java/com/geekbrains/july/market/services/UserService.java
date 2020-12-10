package com.geekbrains.july.market.services;

import com.geekbrains.july.market.entities.User;
import com.geekbrains.july.market.entities.dtos.UserDto;
import com.geekbrains.july.market.exceptions.UserNotFoundException;
import com.geekbrains.july.market.repositories.RolesRepository;
import com.geekbrains.july.market.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    private UserRepository userRepository;
    private RolesRepository rolesRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) { this.userRepository = userRepository;}

    @Autowired
    public void setRolesRepository(RolesRepository rolesRepository) { this.rolesRepository = rolesRepository;}

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found, id: " + id));
    }

    public List<User> findAll() { return userRepository.findAll();}

    public boolean existsById(Long id) {return userRepository.existsById(id); }

    public List<UserDto> getDtoData() {return userRepository.findAllBy();}

    public UserDto getDtoDataById(Long id){
        return userRepository.findOneById(id).orElseThrow(() -> new UserNotFoundException("User not found, id: " + id));
    }
}
