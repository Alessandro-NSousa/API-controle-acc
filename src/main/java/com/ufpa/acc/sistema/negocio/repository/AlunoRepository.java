package com.ufpa.acc.sistema.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufpa.acc.sistema.model.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findByLogin(String login);
    
}
