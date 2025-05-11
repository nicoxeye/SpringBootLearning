package com.example.lab92.controller;

import com.example.lab92.model.Participant;
import com.example.lab92.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participants")
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;

    @GetMapping("/course/{id}")
    public Page<Participant> getParticipants(@PathVariable Long id, @RequestParam int page, @RequestParam int size) {
        return participantService.getParticipants(id, PageRequest.of(page, size));
    }

    @PostMapping
    public Participant add(@RequestBody Participant participant) {
        return participantService.save(participant);
    }
}
