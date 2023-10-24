package com.ufpa.acc.sistema.negocio.implementacao;

import org.springframework.stereotype.Component;

import com.ufpa.acc.sistema.model.Pessoa;
import com.ufpa.acc.sistema.negocio.repository.PessoaRepository;
import com.ufpa.acc.sistema.negocio.service.PessoaService;

@Component
public class PessoaImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    
    public PessoaImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Pessoa create(Pessoa pessoaCreate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Pessoa buscarLogin(String login) {
        return pessoaRepository.findByLogin(login);
    }


    
}
