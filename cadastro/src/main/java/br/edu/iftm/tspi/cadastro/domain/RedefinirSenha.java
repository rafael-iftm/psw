package br.edu.iftm.tspi.cadastro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedefinirSenha {
    private String usuario;
    private String novaSenha;
    private String confirmeNovaSenha;
}
