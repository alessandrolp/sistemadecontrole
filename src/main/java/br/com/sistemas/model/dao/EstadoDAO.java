package br.com.sistemas.model.dao;

import br.com.sistemas.model.entity.Estado;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by alessandro on 27/08/16.
 */
@Repository
public class EstadoDAO {
    @PersistenceContext
    EntityManager entityManager;

    public EstadoDAO(){

    }

    @Transactional
    public void salvar(Estado estado){
        entityManager.merge(estado);
    }

    public Estado buscarPorId(Long id){
        return entityManager.find(Estado.class, id);
    }

    @Transactional
    public void excluir(Estado estado){
        Estado estadoExcluir = buscarPorId(estado.getId());
        entityManager.remove(estadoExcluir);
    }

    public List<Estado> buscarTodos(){
        Query consulta = entityManager.createQuery("select e from Estado e");
        return consulta.getResultList();
    }

}
