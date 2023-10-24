package com.ufpa.acc.sistema.model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;

@Entity
@DynamicUpdate
public class Cordenador extends Pessoa {
    
}
