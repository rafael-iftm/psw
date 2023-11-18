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

import br.edu.iftm.tspi.cadastro.dao.CadastroDAO;
import br.edu.iftm.tspi.cadastro.domain.Cadastro;

@Controller
@RequestMapping("/cadastros")
public class CadastroController {
    @Autowired
    private CadastroDAO dadosCadastrados;

    @GetMapping
    public String listarCadastros(Model model) {
        List<Cadastro> cadastros = dadosCadastrados.listarCadastros();
        model.addAttribute("cadastros", cadastros);
        return "paginaListagem";
    }

    @PostMapping("/inserir")
    public String inserirCadastro(@ModelAttribute Cadastro cadastro, Model model) {
        dadosCadastrados.inserirCadastro(cadastro);
        List<Cadastro> cadastros = dadosCadastrados.listarCadastros();
        model.addAttribute("cadastros", cadastros);
        return "paginaListagem";
    }

    @GetMapping("/editar/{email}")
    public String exibirFormularioEdicao(@PathVariable String email, Model model) {
        Cadastro cadastro = dadosCadastrados.buscarCadastroPorEmail(email);
        model.addAttribute("cadastro", cadastro);
        return "paginaEdicao";
    }

    @PostMapping("/atualizar/{email}")
    public String atualizarCadastro(@PathVariable String email, @ModelAttribute Cadastro cadastro, Model model) {
        dadosCadastrados.atualizarCadastro(cadastro);
        List<Cadastro> cadastros = dadosCadastrados.listarCadastros();
        model.addAttribute("cadastros", cadastros);
        return "paginaListagem";
    }

    @PostMapping("/excluir/{email}")
    public String excluirCadastro(@PathVariable String email, Model model) {
        dadosCadastrados.excluirCadastro(email);
        List<Cadastro> cadastros = dadosCadastrados.listarCadastros();
        model.addAttribute("cadastros", cadastros);
        return "paginaListagem";
    }

    @GetMapping("/pesquisar")
    public String pesquisarCadastrosPorNome(@RequestParam String nome, Model model) {
        List<Cadastro> cadastros = dadosCadastrados.buscarCadastrosPorNome(nome);
        model.addAttribute("cadastros", cadastros);
        return "paginaListagem";
    }
}
