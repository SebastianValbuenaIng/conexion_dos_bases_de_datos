package com.eciciencia.gestion.domain.entities.DBOne;

import jakarta.persistence.*;

@Entity
@Table(name = "administradores")
public class AdministradorEntity {
    @Id
    private Integer id;
}