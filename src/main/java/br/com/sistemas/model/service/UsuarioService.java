package br.com.sistemas.model.service;

import br.com.sistemas.model.dao.DAOException;
import br.com.sistemas.model.dao.UsuarioDAO;
import br.com.sistemas.model.entity.Usuario;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 28/08/16.
 */
@Service
public class UsuarioService {

    @Inject
    private UsuarioDAO usuarioDAO;

    public Usuario salvar(Usuario usuario) throws ServiceException, DAOException {
        Usuario usuarioExistente = usuarioDAO.buscarEmail(usuario.getEmail());
        if(usuarioExistente != null){
            throw  new ServiceException("Usuario já existente!");
        } else {
            return usuarioDAO.salvar(usuario);
        }
    }

    public void excluir(Usuario usuario) throws ServiceException {
        try {
            usuarioDAO.excluir(usuario);
        } catch (DAOException e) {
            throw new ServiceException("Não foi possivel excluir", e);
        }
    }

    public Usuario buscarPorId(Long id){
        return usuarioDAO.buscarPorId(id);
    }

    public List<Usuario> buscarTodos(){
        return usuarioDAO.buscarTodos();
    }

}
