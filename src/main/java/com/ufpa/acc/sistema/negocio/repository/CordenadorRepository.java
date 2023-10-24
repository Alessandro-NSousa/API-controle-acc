package com.ufpa.acc.sistema.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufpa.acc.sistema.model.Cordenador;

public interface CordenadorRepository extends JpaRepository<Cordenador, Long> {
    boolean existsByLogin(String login);
}
