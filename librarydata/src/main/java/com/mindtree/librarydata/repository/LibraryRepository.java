package com.mindtree.librarydata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.librarydata.entity.Library;
@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer>{

}
