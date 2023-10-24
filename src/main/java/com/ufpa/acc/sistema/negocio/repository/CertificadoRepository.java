package com.ufpa.acc.sistema.negocio.repository;

import com.ufpa.acc.sistema.model.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificadoRepository extends JpaRepository<Certificado, Long> {
    List<Certificado> findByIdPessoa(Long idPessoa);
}
