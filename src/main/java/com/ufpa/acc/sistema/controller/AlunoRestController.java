package com.ufpa.acc.sistema.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ufpa.acc.sistema.model.Aluno;
import com.ufpa.acc.sistema.negocio.service.AlunoService;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/aluno")
public class AlunoRestController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody Aluno alunoModel){
        Aluno aluno = this.alunoService.buscarLogin(alunoModel.getLogin());

        if(aluno != null){
            //mensagem de erro
            //status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("usuário já existe");
        }

         String passwordHashred = BCrypt.withDefaults()
        .hashToString(12, alunoModel.getSenha().toCharArray());

        alunoModel.setSenha(passwordHashred);

        Aluno alunoCreated = this.alunoService.create(alunoModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(alunoCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long idAluno){
        var aluno = alunoService.findById(idAluno);
        return ResponseEntity.ok().body(aluno);
    }
    
    
}
