package com.geekbrains.july.market.repositories;

import com.geekbrains.july.market.entities.User;
import com.geekbrains.july.market.entities.dtos.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Optional;


public interface UserRepository  extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    List<UserDto> findAllBy();
    Optional<UserDto> findOneById(Long id);
}
