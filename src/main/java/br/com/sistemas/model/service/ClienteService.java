package br.com.sistemas.model.service;

import br.com.sistemas.model.dao.ClienteDAO;
import br.com.sistemas.model.dao.DAOException;
import br.com.sistemas.model.entity.Cliente;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 27/12/16.
 */

@Service
public class ClienteService {

    @Inject
    private ClienteDAO clienteDAO;

    public void salvar (Cliente cliente) throws ServiceException {
        try {
            if(cliente.getNome() == null || cliente.getNome() == ""){
                throw new ServiceException("Nome não pode ser nulo");
            }
            clienteDAO.salvar(cliente);
        } catch (DAOException causa){
            throw new ServiceException("Não foi possivel salvar", causa);
        }
    }

    public Cliente buscarPorId(Long id){
        return clienteDAO.buscarPorId(id);
    }

    public void excluir (Cliente cliente){
        clienteDAO.excluir(cliente);
    }

    public List<Cliente> buscarTodos (){
        return clienteDAO.buscarTodos();
    }

}
