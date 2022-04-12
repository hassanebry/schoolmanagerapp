package com.silvercode.schoolmanagerapp.repository;

import com.silvercode.schoolmanagerapp.model.IdCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IdCardRepository extends JpaRepository<IdCard, Long> {

    @Query("select ic from IdCard ic where ic.student.studentId=?1")
    IdCard findByStudentId(Long studentId);
}
