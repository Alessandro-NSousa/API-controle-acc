package com.ufpa.acc.sistema.negocio.service;

import com.ufpa.acc.sistema.model.Cordenador;

public interface CordenadorService {
    Cordenador findById(Long id);
	
	Cordenador create(Cordenador cordenadorCreate);
}
