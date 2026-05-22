package com.lms.library_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.library_system.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
