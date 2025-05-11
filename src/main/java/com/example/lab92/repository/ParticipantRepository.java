package com.example.lab92.repository;

import com.example.lab92.model.Course;
import com.example.lab92.model.Participant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Page<Participant> findByCourseId(Long courseId, Pageable pageable);
}
