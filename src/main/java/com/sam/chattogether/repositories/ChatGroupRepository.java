package com.sam.chattogether.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.chattogether.entities.ChatGroup;

@Repository
public interface ChatGroupRepository extends JpaRepository<ChatGroup, Long> {

}
