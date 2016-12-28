package br.com.sistemas.model.entity;

import javax.persistence.*;

/**
 * Created by alessandro on 27/12/16.
 */

@Entity
public class Cliente {

    @Id
    @SequenceGenerator(name = "seq_cliente", initialValue = 1)
    @GeneratedValue(generator = "seq_cliente", strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String cpf;

    private String rg;

    private String endereco;

    private String numero;

    private String cidade;

    @ManyToOne
    @JoinColumn
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (!cpf.equals(cliente.cpf)) return false;
        if (!id.equals(cliente.id)) return false;
        if (!rg.equals(cliente.rg)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + cpf.hashCode();
        result = 31 * result + rg.hashCode();
        return result;
    }
}
