package com.sam.chattogether.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.chattogether.entities.GroupMember;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {

}
