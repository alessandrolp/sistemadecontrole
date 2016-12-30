package br.com.sistemas.model.service;

import br.com.sistemas.model.dao.DAOException;
import br.com.sistemas.model.dao.PerfilDAO;
import br.com.sistemas.model.entity.Perfil;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 29/12/16.
 */

@Service
public class PerfilService {

    @Inject
    private PerfilDAO perfilDAO;

    public Perfil salvar(Perfil perfil) throws ServiceException {
        try {
            return perfilDAO.salvar(perfil);
        } catch (DAOException e) {
            throw new ServiceException("nao foi possivel salvar", e);
        }
    }

    public void excluir(Perfil perfil) throws ServiceException {
        try {
            perfilDAO.excluir(perfil);
        } catch (DAOException e) {
            throw new ServiceException("não foi possivel excluir", e);
        }
    }

    public Perfil buscarPorId(Long id){
        return perfilDAO.buscarPorId(id);
    }

    public List<Perfil> buscarTodos(){
        return perfilDAO.buscarTodos();
    }

}
