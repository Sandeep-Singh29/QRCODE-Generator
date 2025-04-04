package com.qrocode.repository;

import com.qrocode.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Sandeep Singh
 * Date: 04/04/25
 */

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
}
