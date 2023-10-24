package com.ufpa.acc.sistema.negocio.service;

import com.ufpa.acc.sistema.model.Certificado;

import java.util.List;

public interface CertificadoService {
    Certificado findById(Long id);
    Certificado create(Certificado certificadoToCreate);

    List<Certificado> findByIdPessoa(Long idPessoa);

    List<Certificado> findAll();

}
