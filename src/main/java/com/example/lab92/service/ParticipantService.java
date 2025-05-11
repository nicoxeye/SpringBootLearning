package com.example.lab92.service;

import com.example.lab92.model.Participant;
import com.example.lab92.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public Page<Participant> getParticipants(Long CourseId, Pageable pageable) {
        return participantRepository.findByCourseId(CourseId, pageable);
    }

    public Participant save(Participant participant) {
        participant.setRegistration_date(Date.valueOf(LocalDate.now()));
        return participantRepository.save(participant);
    }
}
