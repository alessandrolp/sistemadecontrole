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
    public Usuario salvar(Usuario usuario) throws DAOException{
        try {
            return entityManager.merge(usuario);
        } catch (Exception causa){
            //captura a excecao do banco
            throw new DAOException("Não foi possivel salvar", causa);
        }
    }

    @Transactional
    public void excluir(Usuario usuario) throws DAOException {
        try {
            Usuario usuarioManaged = entityManager.getReference(Usuario.class, usuario.getId()); // carregando o objeto usuario novamente para o contexto do entity manager, pois estava detached (fora do contexto).
            entityManager.remove(usuarioManaged);
        } catch (Exception e){
            throw new DAOException("Não foi possivel excluir", e);
        }
    }

    public Usuario buscarPorId(Long id){
        return entityManager.find(Usuario.class, id);
    }

    public List<Usuario> buscarTodos(){
        Query consulta = entityManager.createQuery("select u from Usuario u"); //JPQL
        return consulta.getResultList();
    }

    public Usuario buscarEmail(String email){
        try {
            Query consulta = entityManager.createQuery("select u from Usuario u where u.email=:emailParam");
            consulta.setParameter("emailParam", email);
            return (Usuario) consulta.getSingleResult();
        } catch (Exception e){
            return null;
        }
    }

}
