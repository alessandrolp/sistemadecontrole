package br.com.sistemas.args;

import br.com.sistemas.model.entity.Cidade;

import javax.persistence.ManyToOne;

/**
 * Created by alessandro on 28/08/16.
 */
public class Pessoa {

    private String nome;

    private String logradouro;

    private String telefone;

    private String email;

    @ManyToOne
    private Cidade cidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
