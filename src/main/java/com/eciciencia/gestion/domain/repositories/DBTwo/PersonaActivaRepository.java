package com.eciciencia.gestion.domain.repositories.DBTwo;

import com.eciciencia.gestion.domain.entities.DBTwo.PersonaActivaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaActivaRepository extends JpaRepository<PersonaActivaEntity, Integer> {
    PersonaActivaEntity findByNombre(String nombre);
}