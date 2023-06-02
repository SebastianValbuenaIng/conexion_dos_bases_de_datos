package com.eciciencia.gestion.domain.repositories.DBOne;

import com.eciciencia.gestion.domain.entities.DBOne.AdministradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<AdministradorEntity, Integer> {

}