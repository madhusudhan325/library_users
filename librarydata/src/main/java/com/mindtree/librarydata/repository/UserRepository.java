package com.mindtree.librarydata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.librarydata.entity.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

}
