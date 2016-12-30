package br.com.sistemas.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alessandro on 27/12/16.
 */

@Entity
public class Cliente implements Serializable {

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

        if (cpf != null ? !cpf.equals(cliente.cpf) : cliente.cpf != null) return false;
        if (id != null ? !id.equals(cliente.id) : cliente.id != null) return false;
        if (nome != null ? !nome.equals(cliente.nome) : cliente.nome != null) return false;
        if (rg != null ? !rg.equals(cliente.rg) : cliente.rg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (rg != null ? rg.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado=" + estado +
                '}';
    }
}
