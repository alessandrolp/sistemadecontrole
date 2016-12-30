package br.com.sistemas.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alessandro on 28/08/16.
 */

@Entity
public class Estado implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_estado", initialValue = 1)
    @GeneratedValue(generator = "seq_estado", strategy = GenerationType.AUTO)
    private Long id;

    private String uf;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estado estado = (Estado) o;

        if (id != null ? !id.equals(estado.id) : estado.id != null) return false;
        if (uf != null ? !uf.equals(estado.uf) : estado.uf != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (uf != null ? uf.hashCode() : 0);
        return result;
    }
}
