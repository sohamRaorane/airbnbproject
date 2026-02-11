package com.soham.airbnb.repository;

import com.soham.airbnb.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long > {

    Optional<Role> findByName (String name );
    //generate a query that finds from Role where name column matches the given value
}
//Needed during signup &Roles are fetched by the name
