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


        JButton jButton = new JButton("Cadastrar");
        jButton.setBounds(120, 140, 120, 30);
        jFrame.add(jButton);

        JLabel status = new JLabel("");
        status.setBounds(20, 190, 350, 25);
        jFrame.add(status);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = jTextFieldCodigo.getText().trim();
                String nome = jTextFieldNome.getText().trim();
                String endereco = jTextFieldEndereco.getText().trim();

                if (codigo.isBlank()) {
                    status.setText("Campo código não poder ser vazio");
                    throw new IllegalArgumentException();
                }

                Usuario usuario = new Usuario();
                usuario.setCodigo(codigo);
                usuario.setNome(nome);
                usuario.setEndereco(endereco);

                cadastroService.cadastrarUsuario(usuario);
            }
        });

        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
