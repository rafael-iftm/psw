package br.edu.iftm.tspi.cadastro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.iftm.tspi.cadastro.domain.Cadastro;

@Component
public class CadastroDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insere um novo cadastro
    public void inserirCadastro(Cadastro cadastro) throws DataAccessException {
        String sql = "INSERT INTO tb_login (email, nome) VALUES (?, ?)";
        jdbcTemplate.update(sql, cadastro.getUsuario(), cadastro.getSenha());
    }
}
