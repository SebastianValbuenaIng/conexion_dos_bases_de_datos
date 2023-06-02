package com.eciciencia.gestion.api.controllers;

import com.eciciencia.gestion.domain.entities.DBTwo.PersonaActivaEntity;
import com.eciciencia.gestion.domain.repositories.DBTwo.PersonaActivaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
public class PersonaActivaController {
    @Autowired
    private PersonaActivaRepository personaActivaRepository;

    @GetMapping
    public PersonaActivaEntity get() {
        return personaActivaRepository.findByNombre("YULY ANDREA SANCHEZ LONDOÑO");
    }
}
