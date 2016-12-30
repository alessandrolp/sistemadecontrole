package br.com.sistemas.model.dao;

import br.com.sistemas.model.entity.Perfil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by alessandro on 29/12/16.
 */

@Repository
public class PerfilDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Perfil salvar(Perfil perfil) throws DAOException {
        try {
            return entityManager.merge(perfil);
        } catch (Exception e){
            throw new DAOException("Não foi possivel salvar", e);
        }
    }

    @Transactional
    public void excluir(Perfil perfil) throws DAOException {
        try {
            Perfil perfilManager = entityManager.getReference(Perfil.class, perfil.getId());
            entityManager.remove(perfilManager);
        } catch (Exception e){
            throw new DAOException("Não foi possivel excluir", e);
        }
    }

    public Perfil buscarPorId(Long id){
        return entityManager.find(Perfil.class, id);
    }

    public List<Perfil> buscarTodos(){
        Query consulta = entityManager.createQuery("select p from Perfil p");
        return consulta.getResultList();
    }


}
