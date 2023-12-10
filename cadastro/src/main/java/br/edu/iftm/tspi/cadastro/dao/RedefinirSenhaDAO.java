package br.edu.iftm.tspi.cadastro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import br.edu.iftm.tspi.cadastro.domain.RedefinirSenha;

@Component
public class RedefinirSenhaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Atualiza a senha do usuário
    public void atualizarSenha(RedefinirSenha redefinirSenha) throws DataAccessException {
        String sql = "UPDATE tb_login SET senha = ? WHERE usuario = ?";
        jdbcTemplate.update(sql, redefinirSenha.getNovaSenha(), redefinirSenha.getUsuario());
    }
}
