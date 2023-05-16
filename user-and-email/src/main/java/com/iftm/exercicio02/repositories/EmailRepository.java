package com.iftm.exercicio02.repositories;

import com.iftm.exercicio02.models.Email;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    @Query("SELECT u FROM Email e WHERE e.user_id= :id")
     List<Email> findUsersByGroupName(@Param("id") Long id);
}
