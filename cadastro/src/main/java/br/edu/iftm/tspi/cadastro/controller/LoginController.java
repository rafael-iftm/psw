package br.edu.iftm.tspi.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iftm.tspi.cadastro.domain.Login;
import br.edu.iftm.tspi.cadastro.service.LoginService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private ContatoController contatoController;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("mensagem", "");
        return "paginaLogin";
    }

    @PostMapping("/entrar")
    public String login(HttpSession session, Login login, Model model) {
        if (loginService.verificaSenha(login)) {
            List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ADMIN");
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    login.getUsuario(), login.getSenha(), authorities);

            SecurityContextHolder.getContext().setAuthentication(authentication);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());

            return contatoController.listarContatos(model);
        } else {
            model.addAttribute("mensagem", "Usuario ou senha inválidos");
            return "paginaLogin";
        }
    }
}
