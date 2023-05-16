package com.iftm.exercicio02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iftm.exercicio02.models.Group;
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {}
