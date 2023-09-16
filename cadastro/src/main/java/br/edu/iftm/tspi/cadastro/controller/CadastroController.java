package br.edu.iftm.tspi.cadastro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iftm.tspi.cadastro.dto.CadastroDTO;

@Controller
public class CadastroController {

    List<CadastroDTO> cadastros = new ArrayList<>();

    @PostMapping("cadastroResourcePost")
    public String doPost(CadastroDTO dto,Model model) {
        cadastros.add(dto);
        //model.addAttribute("cadastros",cadastros);
        //return "listagem";
        return doGet(model);
    }

    @RequestMapping("cadastroResourceGet")
    public String doGet(Model model) {
        model.addAttribute("cadastros",cadastros);
        return "listagem";
    }

    @RequestMapping("cadastroResourceUpdate")
    public String doUpdate(Model model, String novoNome, String name) {
        for (CadastroDTO cadastro : cadastros) {
            if (cadastro.getInputNome().equals(name)) {
                cadastro.setInputNome(novoNome);
                break;
            }
        }

        model.addAttribute("cadastros", cadastros);
        return "listagem";
    }

    @RequestMapping("cadastroResourceDelete")
    public String doDelete(String name, Model model) {
        for (CadastroDTO cadastro : cadastros) {
            if (cadastro.getInputNome().equals(name)) {
                cadastros.remove(cadastro);
                break;
            }
        }

        model.addAttribute("cadastros", cadastros);
        return "listagem";
    }
}
