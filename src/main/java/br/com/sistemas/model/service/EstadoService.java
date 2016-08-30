package br.com.sistemas.model.service;

import br.com.sistemas.model.dao.DAOException;
import br.com.sistemas.model.dao.EstadoDAO;
import br.com.sistemas.model.entity.Estado;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 28/08/16.
 */

@Service
public class EstadoService {

    @Inject
    private EstadoDAO estadoDAO;

    public void salvar(Estado estado) throws ServiceException {
        try {
            if(estado.getUf() == null || estado.getUf() == ""){
                throw new ServiceException("Estado nao pode estar nulo");
            }
            estadoDAO.salvar(estado);
        } catch (DAOException causa) {
            throw new ServiceException("nao foi possivel salvar", causa);
        }
    }

    public Estado buscarPorId(Long id){
        return estadoDAO.buscarPorId(id);
    }

    public void excluir(Estado estado){
        estadoDAO.excluir(estado);
    }

    public List<Estado> buscarTodos(){
        return estadoDAO.buscarTodos();
    }
}
