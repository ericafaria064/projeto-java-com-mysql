package br.edu.uniplan.projeto.banco.de.dados;

import br.edu.uniplan.projeto.banco.de.dados.domain.data.model.Usuario;
import br.edu.uniplan.projeto.banco.de.dados.domain.service.CadastroService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Erica Irdes de Faria
 * Disciplina: Linguagem de Programação Java
 * Faculdade: Uniplan Águas Claras
 */
public class Application {

    private static CadastroService cadastroService;

    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(450, 400);
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

        JButton jButtonConsultar = new JButton("Consultar");
        jButtonConsultar.setBounds(125, 140, 100, 30);
        jFrame.add(jButtonConsultar);

        JButton jButtonCadastrar = new JButton("Cadastrar");
        jButtonCadastrar.setBounds(235, 140, 100, 30);
        jFrame.add(jButtonCadastrar);

        JButton jButtonAlterar = new JButton("Alterar");
        jButtonAlterar.setBounds(125, 180, 100, 30);
        jFrame.add(jButtonAlterar);

        JButton jButtonExcluir = new JButton("Excluir");
        jButtonExcluir.setBounds(235, 180, 100, 30);
        jFrame.add(jButtonExcluir);

        JLabel status = new JLabel("");
        status.setBounds(20, 230, 350, 25);
        jFrame.add(status);

        // Ação do botão consultar
        jButtonConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = jTextFieldCodigo.getText().trim();
                
                // Validar se código é vazio ou nulo
                if (codigo.isBlank()) {
                    
                    // Adicionar o texto no campo status
                    status.setText("Informe o código para consultar.");
                    return;
                }

                Usuario usuarioConsulta = new Usuario();
                usuarioConsulta.setCodigo(codigo);

                cadastroService = new CadastroService();
                Usuario usuarioEncontrado = cadastroService.consultarUsuario(usuarioConsulta);

                if (usuarioEncontrado.getCodigo() != null && !usuarioEncontrado.getCodigo().isEmpty()) {
                    jTextFieldNome.setText(usuarioEncontrado.getNome());
                    jTextFieldEndereco.setText(usuarioEncontrado.getEndereco());
                    status.setText("Usuário encontrado!");
                    System.out.println("Usuario " + usuarioEncontrado.getNome() + " encontrado!");
                } else {
                    jTextFieldNome.setText("");
                    jTextFieldEndereco.setText("");
                    status.setText("Usuário não encontrado!");
                    System.out.println("usuario não encontrado!");
                }
            }
        });

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

                cadastroService = new CadastroService();
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

                cadastroService = new CadastroService();
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

                cadastroService = new CadastroService();
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
