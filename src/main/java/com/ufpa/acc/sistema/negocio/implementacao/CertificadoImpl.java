package com.ufpa.acc.sistema.negocio.implementacao;

import com.ufpa.acc.sistema.model.Certificado;
import com.ufpa.acc.sistema.negocio.repository.CertificadoRepository;
import com.ufpa.acc.sistema.negocio.service.CertificadoService;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class CertificadoImpl implements CertificadoService {
    private final CertificadoRepository certificadoRepository;

    public CertificadoImpl(CertificadoRepository certificadoRepository) {
        this.certificadoRepository = certificadoRepository;
    }

    @Override
    public Certificado findById(Long id) {

        return certificadoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Certificado create(Certificado certificadoToCreate) {

        return certificadoRepository.save(certificadoToCreate);
    }

    @Override
    public List<Certificado> findByIdPessoa(Long idPessoa) {
        return certificadoRepository.findByIdPessoa(idPessoa);
    }

    @Override
    public List<Certificado> findAll() {
        return certificadoRepository.findAll();
    }


}
