package com.ufpa.acc.sistema.negocio.service;

import com.ufpa.acc.sistema.model.Aluno;
import com.ufpa.acc.sistema.model.Pessoa;

public interface PessoaService {
    Pessoa findById(Long id);
	
	Pessoa create(Pessoa pessoaCreate);

    Pessoa buscarLogin(String login);
}
