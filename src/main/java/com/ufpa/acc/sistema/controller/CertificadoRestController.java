package com.ufpa.acc.sistema.controller;

import com.ufpa.acc.sistema.model.Certificado;
import com.ufpa.acc.sistema.negocio.service.CertificadoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificados")
public class CertificadoRestController {

    private final CertificadoService certificadoService;

    public CertificadoRestController(CertificadoService certificadoService){
        this.certificadoService = certificadoService;
    }
    //create
    @PostMapping("/")
    public ResponseEntity created(@RequestBody Certificado certificado, HttpServletRequest request){
        Object idPessoa = request.getAttribute("idUser");
        certificado.setIdPessoa((Long) idPessoa);

        Certificado certificadoCreated = this.certificadoService.create(certificado);
        return ResponseEntity.status(HttpStatus.OK).body(certificadoCreated);

    }
    //ajustar para buscar apenas os certificados da pessoa logada
    @GetMapping("/")
    public List<Certificado> list(HttpServletRequest request){
        Object idPessoa = request.getAttribute("idUser");
        List<Certificado> certificados = this.certificadoService.findByIdPessoa((Long) idPessoa);
        return certificados;

    }

    @GetMapping("/list")
    public List<Certificado> list(){
        
        List<Certificado> certificados = this.certificadoService.findAll();
        return certificados;

    }

}
