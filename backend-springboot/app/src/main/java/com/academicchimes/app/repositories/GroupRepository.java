package com.academicchimes.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academicchimes.app.models.Group;

public interface GroupRepository extends JpaRepository<Group,Long> {

    
}
