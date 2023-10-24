package com.ufpa.acc.sistema.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ufpa.acc.sistema.model.Aluno;
import com.ufpa.acc.sistema.negocio.service.AlunoService;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Result;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterCertificadoAuth extends OncePerRequestFilter {

//    @Autowired
//    private AlunoRepository alunoRepository;
    @Autowired
    private AlunoService alunoService;
//    private CordenadorRepository cordenadorRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();
        if(servletPath.startsWith("/certificados/")) {  //startWith indica que o prefixo incia com um nome especifico desconsiderando o que vem a seguir

            String authorization = request.getHeader("Authorization");

            String auth_encoded = authorization.substring("Basic".length()).trim();
            byte[] authDecoded = Base64.getDecoder().decode(auth_encoded);
            String authString = new String(authDecoded);

            String[] credentials = authString.split(":");
            String login = credentials[0];
            String senha = credentials[1];

            //valida usuario
            Aluno aluno = this.alunoService.buscarLogin(login);
            if(aluno == null){
                System.out.println("não passou da validação");
                response.sendError(401);
            }else{
                //valida senha
                Result passwordVerify =  BCrypt.verifyer().verify(senha.toCharArray(), aluno.getSenha());
                System.out.println("senha aluno: " +aluno.getSenha());
                System.out.println("senha " + senha);
                if(passwordVerify.verified){
                    request.setAttribute("idUser", aluno.getId());
                    filterChain.doFilter(request, response);
                }else{
                    System.out.println("aqui");
                    response.sendError(401);
                }
            }
        }else{
            filterChain.doFilter(request, response);
        }
        //pagar a autenticação




    }
}
