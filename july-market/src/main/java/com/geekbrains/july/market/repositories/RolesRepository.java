package com.geekbrains.july.market.repositories;

import com.geekbrains.july.market.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Role, Long>{
    Role findOneByName(String name);
}
