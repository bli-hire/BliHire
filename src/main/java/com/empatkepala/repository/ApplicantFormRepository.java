package com.empatkepala.repository;


import com.empatkepala.entity.ApplicantForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantFormRepository extends JpaRepository<ApplicantForm, Long> {
}
