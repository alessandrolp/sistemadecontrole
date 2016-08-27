package br.com.sistemas.model.entity;

import javax.persistence.*;

/**
 * Created by alessandro on 16/07/16.
 */

@Entity
public class Usuario {

    @Id
    @SequenceGenerator(name="seq_usu", initialValue = 1)
    @GeneratedValue(generator = "seq_usu", strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
