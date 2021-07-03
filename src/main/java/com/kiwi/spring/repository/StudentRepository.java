package com.kiwi.spring.repository;

import com.kiwi.spring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
