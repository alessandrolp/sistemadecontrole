package br.com.sistemas.model.entity;

import javax.persistence.*;

/**
 * Created by alessandro on 16/08/16.
 */

@Entity
public class Cidade {
    @Id
    @SequenceGenerator(name="seq_cidade", initialValue = 1)
    @GeneratedValue(generator = "seq_cidade", strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @JoinColumn
    @ManyToOne
    private Estado estado;

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
