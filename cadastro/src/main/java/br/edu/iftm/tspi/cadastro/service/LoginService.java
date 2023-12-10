package br.edu.iftm.tspi.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.edu.iftm.tspi.cadastro.dao.LoginDAO;
import br.edu.iftm.tspi.cadastro.domain.Login;

@Service
public class LoginService {

    @Autowired
    private LoginDAO loginDao;

    public boolean verificaSenha(Login loginDigitado) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Login loginBanco = loginDao.buscarLoginPorUsuario(loginDigitado.getUsuario());

        if (loginBanco == null) {
            return false;
        }

        return encoder.matches(loginDigitado.getSenha(), loginBanco.getSenha());
    }
}
