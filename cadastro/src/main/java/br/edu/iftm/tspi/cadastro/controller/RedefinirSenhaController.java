package br.edu.iftm.tspi.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iftm.tspi.cadastro.dao.LoginDAO;
import br.edu.iftm.tspi.cadastro.dao.RedefinirSenhaDAO;
import br.edu.iftm.tspi.cadastro.domain.Login;
import br.edu.iftm.tspi.cadastro.domain.RedefinirSenha;

@Controller
@RequestMapping("/redefinirSenha")
public class RedefinirSenhaController {

    @Autowired
    private RedefinirSenhaDAO redefinirSenhaDAO;

    @Autowired
    private LoginDAO loginDAO;

    @GetMapping
    public String exibirFormularioRedefinirSenha(Model model) {
        model.addAttribute("redefinirSenha", new RedefinirSenha());
        return "paginaRedefinirSenha";
    }

    @PostMapping("/redefinir")
    public String redefinirSenha(@ModelAttribute("redefinirSenha") RedefinirSenha redefinirSenha, Model model) {
        Login login = loginDAO.buscarLoginPorUsuario(redefinirSenha.getUsuario());

        if (login == null) {
            model.addAttribute("erro", "Usuário não encontrado");
            return "paginaRedefinirSenha";
        }

        if (!redefinirSenha.getNovaSenha().equals(redefinirSenha.getConfirmeNovaSenha())) {
            model.addAttribute("erro", "As senhas não coincidem");
            return "paginaRedefinirSenha";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaCriptografada = encoder.encode(redefinirSenha.getNovaSenha());
        redefinirSenha.setNovaSenha(senhaCriptografada);
        
        redefinirSenhaDAO.atualizarSenha(redefinirSenha);
        return "paginaLogin";
    }
}
