package com.sam.chattogether.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.chattogether.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
