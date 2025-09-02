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
 *
 * @author Usuario
 */
public class Application {

    public static void main(String[] args) {

        CadastroService cadastroService = new CadastroService();

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 200);
        jFrame.setLayout(null);

        JLabel jLabelNome = new JLabel("Nome:");
        jLabelNome.setBounds(20, 20, 80, 25);
        jFrame.add(jLabelNome);

        JTextField jTextFieldNome = new JTextField();
        jTextFieldNome.setBounds(80, 20, 150, 25);
        jFrame.add(jTextFieldNome);

        JButton jButton = new JButton("Cadastrar");
        jButton.setBounds(80, 60, 100, 30);
        jFrame.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = jTextFieldNome.getText().trim();

                Usuario usuario = new Usuario();
                usuario.setCodigo(null);
                usuario.setNome(nome);
                usuario.setEndereco(null);

                cadastroService.cadastrarUsuario(usuario);
            }
        });

        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
