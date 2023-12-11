package br.edu.iftm.tspi.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.edu.iftm.tspi.cadastro.dao.CadastroDAO;
import br.edu.iftm.tspi.cadastro.domain.Cadastro;

public class CadastroService {
    @Autowired
    private CadastroDAO cadastroDAO;

    @Transactional
    public void salvar(Cadastro cadastro) {
        cadastroDAO.inserirCadastro(cadastro);
    }    
}