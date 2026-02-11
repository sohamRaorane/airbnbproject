package com.soham.airbnb.repository;


import com.soham.airbnb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
// for the login purpose &  and to prevent duplicate signup
