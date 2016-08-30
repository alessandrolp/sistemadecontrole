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

    public void salvar(Usuario usuario) throws ServiceException{
        try {
            //validacao da regra de negocio
            if(usuario.getNome() == null || usuario.getNome() == ""){
                throw new ServiceException("Usuario não pode estar sem nome");
            } else if(usuario.getEmail() == null || usuario.getEmail() == ""){
                throw new ServiceException("Usuario não pode estar sem email");
            } else if(usuario.getSenha() == null || usuario.getSenha() == ""){
                throw new ServiceException("Usuario não pode estar sem senha");
            } else {
                usuarioDAO.salvar(usuario);
            }
        } catch (DAOException causa) {
            throw new ServiceException("Não foi possivel salvar", causa);
        }
    }

    public void excluir(Usuario usuario){
        usuarioDAO.excluir(usuario);
    }

    public Usuario buscarPorId(Long id){
        return usuarioDAO.buscarPorId(id);
    }

    public List<Usuario> buscarTodos(){
        return usuarioDAO.buscarTodos();
    }

}
