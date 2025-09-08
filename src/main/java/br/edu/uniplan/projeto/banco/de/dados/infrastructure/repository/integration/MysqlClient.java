package br.edu.uniplan.projeto.banco.de.dados.infrastructure.repository.integration;

import br.edu.uniplan.projeto.banco.de.dados.domain.data.model.Usuario;

import java.sql.*;

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

    public static Usuario find(final Usuario usuario) {
        try {
            String sql = "select * from usuario where codigo=?";

            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getCodigo());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Integer id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");

                Usuario user = new Usuario();
                user.setId(id);
                user.setCodigo(codigo);
                user.setNome(nome);
                user.setEndereco(endereco);

                return user;
            }
            return new Usuario();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void insert(final Usuario usuario) {
        try {
            String sql = "insert into usuario (codigo, nome, endereco) values (?, ?, ?)";

            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getCodigo());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getEndereco());

            int executed = ps.executeUpdate();

            if (executed > 0) {
                System.out.println("Usuário: " + usuario.getNome() + " inserido com sucesso!");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void update(final Usuario usuario) {
        try {
            Usuario userBase = find(usuario);
            String sql = "update usuario set codigo=?, nome=?, endereco=? where id=?";

            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getCodigo());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getEndereco());
            ps.setInt(4, userBase.getId());

            int executed = ps.executeUpdate();

            if (executed > 0) {
                System.out.println("Usuário: " + usuario.getNome() + " alterado com sucesso!");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void delete(final Usuario usuario) {
        try {
            String sql = "delete from usuario where id = ?";

            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            Usuario userByDelete = find(usuario);

            ps.setInt(1, userByDelete.getId());

            int executed = ps.executeUpdate();

            if (executed > 0) {
                System.out.println("Usuário: " + usuario.getNome() + " deletado com sucesso!");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
