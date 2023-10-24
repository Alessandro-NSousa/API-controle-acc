package com.ufpa.acc.sistema.negocio.service;

import com.ufpa.acc.sistema.model.Aluno;

public interface AlunoService {
    Aluno findById(Long id);
	
	Aluno create(Aluno alunoCreate);

    Aluno buscarLogin(String login);
}
