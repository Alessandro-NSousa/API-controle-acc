package com.ufpa.acc.sistema.model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DynamicUpdate
public class Aluno extends Pessoa {

    @Column(name = "numero_matricula", nullable = false)
    private Long numeroMatricula;
    
}
