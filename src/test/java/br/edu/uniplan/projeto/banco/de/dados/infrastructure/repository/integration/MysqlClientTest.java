package br.edu.uniplan.projeto.banco.de.dados.infrastructure.repository.integration;

import br.edu.uniplan.projeto.banco.de.dados.domain.data.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

class MysqlClientTest {

    public static void main(String[] args) throws SQLException {
        try {
            final Connection connection = MysqlClient.getConnection();
            if (connection != null) {
                System.out.println("Conectado com sucesso!");

                Usuario usuario = new Usuario();
                usuario.setCodigo("844");
                usuario.setNome("Erica Irdes");
                usuario.setEndereco("Taguatinga");

                MysqlClient.insert(usuario);
            } else {
                System.out.println("Falha na conexão!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}