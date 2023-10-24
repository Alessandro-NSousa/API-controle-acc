package com.ufpa.acc.sistema.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "pessoa")
@DiscriminatorColumn(name="perfil")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pessoa {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator( schema = "public", sequenceName = "hibernate_sequence",name = "hibernate_sequence",allocationSize = 1)
    private Long id;

    @Column(insertable = false , updatable = false)
    private String perfil;

    private String nome;
    

    @Column(unique = true)
    private String login;

    @Column(name = "senha")
    private String senha;

    @CreationTimestamp
    private Date dataCadastro;

    @CreationTimestamp
    private Date ultimoAcesso;


}
