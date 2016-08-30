package br.com.sistemas.model.dao;

import br.com.sistemas.model.entity.Cidade;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by alessandro on 28/08/16.
 */

@Repository
public class CidadeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(Cidade cidade) throws DAOException {
        try {
            entityManager.merge(cidade);
        } catch (Exception causa){
            throw new DAOException("Nao foi possivel salvar", causa);
        }
    }

    public Cidade buscarPorId(Long id){
        return entityManager.find(Cidade.class, id);
    }

    @Transactional
    public void excluir(Cidade cidade){
        Cidade cidadeExcluir = buscarPorId(cidade.getId());
        entityManager.remove(cidadeExcluir);
    }

    public List<Cidade> buscarTodos(){
        Query consulta = entityManager.createQuery("select c from Cidade c");
        return consulta.getResultList();
    }

}
