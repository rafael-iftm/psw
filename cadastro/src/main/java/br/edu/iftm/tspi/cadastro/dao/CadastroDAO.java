package br.edu.iftm.tspi.cadastro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import br.edu.iftm.tspi.cadastro.domain.Cadastro;

@Component
public class CadastroDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Consulta todos os cadastros
    public List<Cadastro> listarCadastros() {
        String sql = "SELECT email, nome FROM tb_contato";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cadastro.class));
    }

    // Busca cadastros pelo nome
    public List<Cadastro> buscarCadastrosPorNome(String nome) {
        String sql = "SELECT email, nome FROM tb_contato WHERE LOWER(nome) LIKE ?";
        return jdbcTemplate.query(sql, new Object[] {"%" + nome.toLowerCase() + "%"}, new BeanPropertyRowMapper<>(Cadastro.class));
    }

    // Insere um novo cadastro
    public void inserirCadastro(Cadastro cadastro) throws DataAccessException {
        String sql = "INSERT INTO tb_contato (email, nome) VALUES (?, ?)";
        jdbcTemplate.update(sql, cadastro.getEmail(), cadastro.getNome());
    }

    // Atualiza um cadastro existente
    public void atualizarCadastro(Cadastro cadastro) throws DataAccessException {
        String sql = "UPDATE tb_contato SET nome = ? WHERE email = ?";
        jdbcTemplate.update(sql, cadastro.getNome(), cadastro.getEmail());
    }

    // Exclui um cadastro pelo email
    public void excluirCadastro(String email) throws DataAccessException {
        String sql = "DELETE FROM tb_contato WHERE email = ?";
        jdbcTemplate.update(sql, email);
    }

    // Busca um cadastro pelo email
    public Cadastro buscarCadastroPorEmail(String email) {
        String sql = "SELECT email, nome FROM tb_contato WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {email}, new BeanPropertyRowMapper<>(Cadastro.class));
    }
}
