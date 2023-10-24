package com.ufpa.acc.sistema.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ufpa.acc.sistema.model.Cordenador;
import com.ufpa.acc.sistema.negocio.service.CordenadorService;

@RestController
@RequestMapping("/cordenador")
public class CordenadorRestController {

    @Autowired
    private CordenadorService cordenadorService;

    @PostMapping("/")
    public ResponseEntity<Cordenador> create(@RequestBody Cordenador cordenador){
        var cordenadorCreate = cordenadorService.create(cordenador);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(cordenadorCreate.getId())
		.toUri();
		return ResponseEntity.created(location).body(cordenadorCreate);
    }

    @GetMapping("/")
    public ResponseEntity<Cordenador> buscarPorId(@PathVariable Long idCordenador){
        var cordenador = cordenadorService.findById(idCordenador);
        return ResponseEntity.ok().body(cordenador);
    }
    
}
