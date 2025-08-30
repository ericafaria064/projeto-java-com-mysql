package br.edu.uniplan.projeto.banco.de.dados.infrastructure.repository.integration;

import br.edu.uniplan.projeto.banco.de.dados.domain.data.model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlClient {

    private static final String url = "jdbc:mysql://localhost:3306/cadastrousuario";
    private static final String user = "root";
    private static final String password = "";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar com o banco de dados" + ex.getMessage());
            throw ex;
        }
    }

    public static void insert(final Usuario usuario) {
        try {
            String sql = "insert into usuario (nome) values (?)";

            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getNome());

            int executed = ps.executeUpdate();

            if (executed > 0) {
                System.out.println("Usuário: " + usuario.getNome() + " inserido com sucesso!");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
