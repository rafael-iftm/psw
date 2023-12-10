package br.edu.iftm.tspi.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.edu.iftm.tspi.cadastro.dao.CadastroDAO;
import br.edu.iftm.tspi.cadastro.domain.Cadastro;

public class CadastroService {
    @Autowired
    private CadastroDAO cadastroDAO;

    public void salvar(Cadastro cadastro) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        cadastro.setSenha(encoder.encode(cadastro.getSenha()));
        cadastroDAO.inserirCadastro(cadastro);
    }
}
