package br.com.sistemas.model.service;

import br.com.sistemas.model.dao.EstadoDAO;
import br.com.sistemas.model.entity.Estado;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 27/08/16.
 */
@Service
public class EstadoService {

    @Inject
    EstadoDAO estadoDAO;

    public Estado buscarPorId(Long id){
        return estadoDAO.buscarPorId(id);
    }

    public List<Estado> buscarTodos(){
        return estadoDAO.buscarTodos();
    }

}
