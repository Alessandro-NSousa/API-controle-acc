package com.ufpa.acc.sistema.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufpa.acc.sistema.model.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByLogin(String login);
}
