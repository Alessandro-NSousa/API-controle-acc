package com.ufpa.acc.sistema.negocio.implementacao;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.ufpa.acc.sistema.model.Aluno;
import com.ufpa.acc.sistema.negocio.repository.AlunoRepository;
import com.ufpa.acc.sistema.negocio.service.AlunoService;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class AlunoImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoImpl(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Aluno findById(Long id) {
        
        return alunoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Aluno create(Aluno alunoCreate) {
        
       // String passwordHashred = BCrypt.withDefaults()
       // .hashToString(12, alunoCreate.getSenha().toCharArray());

        //alunoCreate.setSenha(passwordHashred);

        return alunoRepository.save(alunoCreate);
    }

    @Override
    public Aluno buscarLogin(String login) {
        return alunoRepository.findByLogin(login);
    }


    
}
