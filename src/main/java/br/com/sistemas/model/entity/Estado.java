package br.com.sistemas.model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alessandro on 16/08/16.
 */

@Entity
public class Estado {
    @Id
    @SequenceGenerator(name="seq_estado", initialValue = 1)
    @GeneratedValue(generator = "seq_estado", strategy = GenerationType.AUTO)
    private Long id;

    private String uf;

    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    private List<Cidade> cidades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
}
