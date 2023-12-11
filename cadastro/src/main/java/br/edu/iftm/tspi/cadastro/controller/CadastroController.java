package br.edu.iftm.tspi.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iftm.tspi.cadastro.dao.CadastroDAO;
import br.edu.iftm.tspi.cadastro.domain.Cadastro;


@Controller
@RequestMapping("/cadastros")
public class CadastroController {
    @Autowired
    private CadastroDAO cadastroDAO;

    @GetMapping
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("cadastro", new Cadastro());
        return "paginaCadastro";
    }

    @PostMapping("/inserir")
    public String inserirCadastro(@ModelAttribute("cadastro") Cadastro cadastro) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        cadastro.setCadastroSenha(encoder.encode(cadastro.getCadastroSenha()));
        cadastroDAO.inserirCadastro(cadastro);
        return "paginaLogin";
    }
}

