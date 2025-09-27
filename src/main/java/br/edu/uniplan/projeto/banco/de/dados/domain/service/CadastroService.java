package br.edu.uniplan.projeto.banco.de.dados.domain.service;

import br.edu.uniplan.projeto.banco.de.dados.domain.data.model.Usuario;
import br.edu.uniplan.projeto.banco.de.dados.infrastructure.repository.integration.MysqlClient;

/**
 * @author Erica Irdes de Faria
 * Disciplina: Linguagem de Programação Java
 * Faculdade: Uniplan Águas Claras
 */
public class CadastroService {

    public Usuario consultarUsuario(Usuario usuario) {
        System.out.println("consultando usuario com codigo: " + usuario.getCodigo());
        return MysqlClient.consultarUsuario(usuario);
    }

    public void cadastrarUsuario(Usuario usuario) {
        System.out.println("Cadastrando usuário: " + usuario.getNome());

        MysqlClient.cadastrarUsuario(usuario);

        System.out.println("Cadastro realizado com sucesso!");
    }

    public void alterarUsuario(Usuario usuario) {
        System.out.println("Alterando usuário: " + usuario.getNome());

        MysqlClient.alterarUsuario(usuario);

        System.out.println("Alteração realizado com sucesso!");
    }

    public void excluirUsuario(Usuario usuario) {
        System.out.println("Excluindo usuário: " + usuario.getNome());

        MysqlClient.excluirUsuario(usuario);

        System.out.println("Exclusão realizado com sucesso!");
    }
}
