package br.edu.iftm.tspi.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iftm.tspi.cadastro.dao.ContatoDAO;
import br.edu.iftm.tspi.cadastro.domain.Contato;

@Controller
@RequestMapping("/contatos")
public class ContatoController {
    @Autowired
    private ContatoDAO contatoDAO;

    @GetMapping
    public String listarContatos(Model model) {
        List<Contato> contatos = contatoDAO.listarContatos();
        model.addAttribute("contatos", contatos);
        return "paginaListagem";
    }

    @PostMapping("/inserir")
    public String inserirContato(@ModelAttribute Contato contato, Model model) {
        contatoDAO.inserirContato(contato);
        List<Contato> contatos = contatoDAO.listarContatos();
        model.addAttribute("contatos", contatos);
        return "paginaListagem";
    }

    @GetMapping("/editar/{email}")
    public String exibirFormularioEdicao(@PathVariable String email, Model model) {
        Contato contatos = contatoDAO.buscarContatoPorEmail(email);
        model.addAttribute("contatos", contatos);
        return "paginaEdicao";
    }

    @PostMapping("/atualizar/{email}")
    public String atualizarContato(@PathVariable String email, @ModelAttribute Contato contato, Model model) {
        contatoDAO.atualizarContato(contato);
        List<Contato> contatos = contatoDAO.listarContatos();
        model.addAttribute("contatos", contatos);
        return "paginaListagem";
    }

    @PostMapping("/excluir/{email}")
    public String excluirContato(@PathVariable String email, Model model) {
        contatoDAO.excluirContato(email);
        List<Contato> contatos = contatoDAO.listarContatos();
        model.addAttribute("contatos", contatos);
        return "paginaListagem";
    }

    @GetMapping("/pesquisar")
    public String pesquisarContatosPorNome(@RequestParam String nome, Model model) {
        List<Contato> contatos = contatoDAO.buscarContatosPorNome(nome);
        model.addAttribute("contatos", contatos);
        return "paginaListagem";
    }
}
