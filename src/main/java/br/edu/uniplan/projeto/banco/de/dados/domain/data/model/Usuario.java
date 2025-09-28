package br.edu.uniplan.projeto.banco.de.dados.domain.data.model;

/**
 * @author Erica Irdes de Faria
 * Disciplina: Linguagem de Programação Java
 * Faculdade: Uniplan Águas Claras
 */
public class Usuario {
    
    // Atributos da classe
    private Integer id;
    private String codigo;
    private String nome;
    private String endereco;

    // Métodos get e set    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
