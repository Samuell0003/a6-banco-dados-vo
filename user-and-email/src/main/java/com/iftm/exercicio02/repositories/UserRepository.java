package com.iftm.exercicio02.repositories;

import com.iftm.exercicio02.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     @Query("SELECT u FROM User u WHERE u.firstName LIKE %:name% OR u.lastName LIKE %:name%")
     List<User> findUsersByName(@Param("name") String name);
     
     @Query("SELECT u FROM User u WHERE u.social_network = :name")
     List<User> findUsersBySocialNetWorkList(@Param("name") String name);

     @Query("SELECT u FROM User u JOIN u.groups g WHERE g.name = :groupName")
     List<User> findUsersByGroupName(@Param("groupName") String groupName);


}
