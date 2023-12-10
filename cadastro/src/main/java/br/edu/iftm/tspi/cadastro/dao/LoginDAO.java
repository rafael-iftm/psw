package br.edu.iftm.tspi.cadastro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.iftm.tspi.cadastro.domain.Login;

import java.util.List;

@Component
public class LoginDAO {
    @Autowired
    JdbcTemplate db;

    // Obtém um objeto Login com base no nome de usuário.
    public Login buscarLoginPorUsuario(String usuario) {
        String sql = "SELECT usuario, senha FROM tb_login WHERE usuario = ?";
        List<Login> logins = db.query(
                sql,
                (res, rowNum) -> new Login(res.getString("usuario"), res.getString("senha")),
                new Object[]{usuario}
        );

        return logins.isEmpty() ? null : logins.get(0);
    }
}
