package com.ufpa.acc.sistema.negocio.implementacao;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufpa.acc.sistema.model.Cordenador;
import com.ufpa.acc.sistema.negocio.repository.CordenadorRepository;
import com.ufpa.acc.sistema.negocio.service.CordenadorService;
@Service
public class CordenadorIpl implements CordenadorService {

    @Autowired
    private final CordenadorRepository cordenadorRepository;


    public CordenadorIpl(CordenadorRepository cordenadorRepository) {
        this.cordenadorRepository = cordenadorRepository;
    }

    @Override
    public Cordenador findById(Long id) {
        
        return cordenadorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Cordenador create(Cordenador cordenadorCreate) {
        if(cordenadorRepository.existsByLogin(cordenadorCreate.getLogin())) {
			throw new IllegalArgumentException("Este login Já existe");
		}

        return cordenadorRepository.save(cordenadorCreate);
    }
    
}
