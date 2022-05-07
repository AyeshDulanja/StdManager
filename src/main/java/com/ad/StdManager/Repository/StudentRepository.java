package com.ad.StdManager.Repository;

import com.ad.StdManager.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Long> {

}
