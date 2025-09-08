/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.edu.uniplan;

import br.edu.uniplan.projeto.banco.de.dados.domain.data.model.Usuario;
import br.edu.uniplan.projeto.banco.de.dados.domain.service.CadastroService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Usuario
 */
public class Application {

    public static void main(String[] args) {

        CadastroService cadastroService = new CadastroService();

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(400, 300);
        jFrame.setLayout(null);

        JLabel jLabelCodigo = new JLabel("Código:");
        jLabelCodigo.setBounds(20, 20, 80, 25);
        jFrame.add(jLabelCodigo);

        JTextField jTextFieldCodigo = new JTextField();
        jTextFieldCodigo.setBounds(120, 20, 200, 25);
        jFrame.add(jTextFieldCodigo);

        JLabel jLabelNome = new JLabel("Nome:");
        jLabelNome.setBounds(20, 60, 200, 25);
        jFrame.add(jLabelNome);

        JTextField jTextFieldNome = new JTextField();
        jTextFieldNome.setBounds(120, 60, 200, 25);
        jFrame.add(jTextFieldNome);

        JLabel jLabelEndereco = new JLabel("Endereço:");
        jLabelEndereco.setBounds(20, 100, 80, 25);
        jFrame.add(jLabelEndereco);

        JTextField jTextFieldEndereco = new JTextField();
        jTextFieldEndereco.setBounds(120, 100, 200, 25);
        jFrame.add(jTextFieldEndereco);


        JButton jButtonCadastrar = new JButton("Cadastrar");
        jButtonCadastrar.setBounds(20, 140, 100, 30);
        jFrame.add(jButtonCadastrar);

        JButton jButtonAlterar = new JButton("Alterar");
        jButtonAlterar.setBounds(140, 140, 100, 30);
        jFrame.add(jButtonAlterar);

        JButton jButtonExcluir = new JButton("Excluir");
        jButtonExcluir.setBounds(260, 140, 100, 30);
        jFrame.add(jButtonExcluir);

        JLabel status = new JLabel("");
        status.setBounds(20, 190, 350, 25);
        jFrame.add(status);

        jButtonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = jTextFieldCodigo.getText().trim();
                String nome = jTextFieldNome.getText().trim();
                String endereco = jTextFieldEndereco.getText().trim();

                if (codigo.isBlank()) {
                    status.setText("Campo código deve ser informado.");
                    return;
                }
                if (nome.isEmpty()) {
                    status.setText("Campo nome deve ser informado.");
                    return;
                }
                if (endereco.isBlank()) {
                    status.setText("Campo endereço deve ser informado.");
                    return;
                }

                Usuario usuario = new Usuario();
                usuario.setCodigo(codigo);
                usuario.setNome(nome);
                usuario.setEndereco(endereco);

                cadastroService.cadastrarUsuario(usuario);
                status.setText("Cadastro realizado!");
            }
        });

        jButtonAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = jTextFieldCodigo.getText().trim();
                String nome = jTextFieldNome.getText().trim();
                String endereco = jTextFieldEndereco.getText().trim();

                if (codigo.isBlank() || nome.isBlank() || endereco.isBlank()) {
                    status.setText("Preencha todos os campos para alterar.");
                    return;
                }

                Usuario usuario = new Usuario();
                usuario.setCodigo(codigo);
                usuario.setNome(nome);
                usuario.setEndereco(endereco);

                cadastroService.alterarUsuario(usuario);
                status.setText("Usuário alterado com sucesso!");
            }
        });

        jButtonExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = jTextFieldCodigo.getText().trim();
                String nome = jTextFieldNome.getText().trim();

                if (codigo.isBlank()) {
                    status.setText("Informe o código para excluir.");
                    return;
                }

                Usuario usuario = new Usuario();
                usuario.setCodigo(codigo);
                usuario.setNome(nome);

                cadastroService.excluirUsuario(usuario);
                status.setText("Usuário excluído com sucesso!");

                jTextFieldCodigo.setText("");
                jTextFieldNome.setText("");
                jTextFieldEndereco.setText("");
            }
        });


        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
