package br.com.sistemas.model.dao;

import br.com.sistemas.model.entity.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by alessandro on 27/12/16.
 */

@Repository
public class ClienteDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar (Cliente cliente) throws DAOException {
        try {
            entityManager.merge(cliente);
        } catch (Exception causa){
            throw new DAOException("Não foi possivel salvar", causa);
        }
    }

    public Cliente buscarPorId (Long id){
        return entityManager.find(Cliente.class, id);
    }

    @Transactional
    public void excluir(Cliente cliente){
        Cliente clienteExcluir = buscarPorId(cliente.getId());
        entityManager.remove(clienteExcluir);
    }

    public List<Cliente> buscarTodos(){
        Query consulta = entityManager.createQuery("select c from Cliente c", Cliente.class);
        return consulta.getResultList();
    }

}
