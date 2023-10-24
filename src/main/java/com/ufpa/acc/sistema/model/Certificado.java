package com.ufpa.acc.sistema.model;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Data
@Entity
@DynamicUpdate
@Table(name = "certificado")
public class Certificado {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator( schema = "public", sequenceName = "hibernate_sequence",name = "hibernate_sequence",allocationSize = 1)
    @Column(name = "id")
    private Long id;

    private String titulo;
    private String decricao;
    private Date dataEnvio;
    private String observacao;
    private Integer chCumprida;
    private Integer pontuacao;
    private Long idPessoa;
}
