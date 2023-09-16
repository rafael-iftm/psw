package br.edu.iftm.tspi.cadastro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String doUpdate(
        Model model,
        String oldName,
        String newName,
        String oldEmail,
        String newEmail,
        String oldTel,
        String newTel
    ) {
        for (CadastroDTO cadastro : cadastros) {
            if (cadastro.getInputNome().equals(oldName)) {
                cadastro.setInputNome(newName); // Atualiza o nome com o novo valor
                cadastro.setInputEmail(newEmail); // Atualiza o email com o novo valor
                cadastro.setInputTel(newTel); // Atualiza o telefone com o novo valor
                break; // Sai do loop assim que o registro é encontrado e atualizado
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
