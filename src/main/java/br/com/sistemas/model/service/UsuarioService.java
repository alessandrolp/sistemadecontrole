package br.com.sistemas.model.service;

import br.com.sistemas.model.dao.DAOException;
import br.com.sistemas.model.dao.UsuarioDAO;
import br.com.sistemas.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alessandro on 21/07/16.
 */

@Service
public class UsuarioService {

    @Autowired
    UsuarioDAO usuarioDAO;

    public void salvar(Usuario usuario) throws ServiceExceptionn {

        if (usuario.getNome().equals(null)){
            throw new ServiceExceptionn("Nome não pode estar em branco");
        }

        try {
            usuarioDAO.salvar(usuario);
        } catch (DAOException causa) {
            throw new ServiceExceptionn("Não foi possivel salvar", causa);
        }

    }

}
