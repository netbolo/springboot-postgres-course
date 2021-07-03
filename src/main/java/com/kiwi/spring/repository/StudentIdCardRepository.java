package com.kiwi.spring.repository;

import com.kiwi.spring.model.StudentIdCard;
import org.springframework.data.repository.CrudRepository;

public interface StudentIdCardRepository
        extends CrudRepository<StudentIdCard, Long> {
}
