package br.edu.iftm.tspi.cadastro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import br.edu.iftm.tspi.cadastro.domain.Contato;

@Component
public class ContatoDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Consulta todos os Contatos
    public List<Contato> listarContatos() {
        String sql = "SELECT email, nome FROM tb_contato";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contato.class));
    }

    // Insere um novo Contato
    public void inserirContato(Contato Contato) throws DataAccessException {
        String sql = "INSERT INTO tb_contato (email, nome) VALUES (?, ?)";
        jdbcTemplate.update(sql, Contato.getEmail(), Contato.getNome());
    }

    // Busca Contatos pelo nome
    public List<Contato> buscarContatosPorNome(String nome) {
        String sql = "SELECT email, nome FROM tb_contato WHERE LOWER(nome) LIKE ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contato.class), "%" + nome.toLowerCase() + "%");
    }


    // Atualiza um Contato existente
    public void atualizarContato(Contato Contato) throws DataAccessException {
        String sql = "UPDATE tb_contato SET nome = ? WHERE email = ?";
        jdbcTemplate.update(sql, Contato.getNome(), Contato.getEmail());
    }

    // Exclui um Contato pelo email
    public void excluirContato(String email) throws DataAccessException {
        String sql = "DELETE FROM tb_contato WHERE email = ?";
        jdbcTemplate.update(sql, email);
    }

    // Busca um Contato pelo email
    public Contato buscarContatoPorEmail(String email) {
        String sql = "SELECT email, nome FROM tb_contato WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Contato.class), email);
    }
    
}
