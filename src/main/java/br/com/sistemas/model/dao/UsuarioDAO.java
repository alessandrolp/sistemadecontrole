package br.com.sistemas.model.dao;

import br.com.sistemas.model.entity.Usuario;
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
public class UsuarioDAO {

    //Injeção de dependencia do entity manager
    @PersistenceContext
    EntityManager entityManager;

    public UsuarioDAO() {
    }

    @Transactional
    public void salvar(Usuario usuario) throws DAOException{
        try {
            entityManager.merge(usuario);
        } catch (Exception causa){
            //captura a excecao do banco
            throw new DAOException("Não foi possivel salvar", causa);
        }
    }

    @Transactional
    public void excluir(Usuario usuario){
        Usuario usuarioExcluir = buscarPorId(usuario.getId());
        entityManager.remove(usuarioExcluir);
    }

    public Usuario buscarPorId(Long id){
        return entityManager.find(Usuario.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> buscarTodos(){
        Query consulta = entityManager.createQuery("select u from Usuario u"); //JPQL
        return consulta.getResultList();
    }

}
