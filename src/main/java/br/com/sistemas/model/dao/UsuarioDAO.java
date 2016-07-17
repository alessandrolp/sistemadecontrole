package br.com.sistemas.model.dao;

import br.com.sistemas.model.entity.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by alessandro on 16/07/16.
 */

@Repository
public class UsuarioDAO {

    //injeção de dependencia do Entity Manager
    @PersistenceContext
    EntityManager entityManager;

    public UsuarioDAO(){

    }

    @Transactional
    public void salvar(Usuario usuario){
        try {
            entityManager.merge(usuario);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void excluir(Usuario usuario){
        entityManager.remove(usuario);
    }

    public List<Usuario> buscartodos(){
        Query consulta = entityManager.createQuery("select u from Usuario u");
        return consulta.getResultList();
    }

    public Usuario buscarPorId(Long id){
        return entityManager.find(Usuario.class, id);
    }

}
