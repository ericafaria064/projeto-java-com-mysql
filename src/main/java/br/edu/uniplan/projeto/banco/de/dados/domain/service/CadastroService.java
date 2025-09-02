package br.edu.uniplan.projeto.banco.de.dados.domain.service;

import br.edu.uniplan.projeto.banco.de.dados.domain.data.model.Usuario;
import br.edu.uniplan.projeto.banco.de.dados.infrastructure.repository.integration.MysqlClient;

public class CadastroService {

    public void cadastrarUsuario(Usuario usuario) {
        System.out.println("Cadastrando usuário: " + usuario.getNome());

        MysqlClient.insert(usuario);

        System.out.println("Cadastro realizado com sucesso!");
    }
}
