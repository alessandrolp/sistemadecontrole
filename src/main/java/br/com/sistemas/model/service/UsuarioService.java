package br.com.sistemas.model.service;

import br.com.sistemas.model.dao.DAOException;
import br.com.sistemas.model.dao.UsuarioDAO;
import br.com.sistemas.model.entity.Usuario;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 21/07/16.
 */

@Service
public class UsuarioService {

    //Injeção de dependencia utilizando especificação JSR 330
    @Inject
    private UsuarioDAO usuarioDAO;

    public void salvar(Usuario usuario) throws ServiceExceptionn {
        try {
            //Validação da regra de Negocios
            if (usuario.getNome().equals(null) || usuario.getNome() == ""){
                throw new ServiceExceptionn("Nome não pode estar em branco");
            }
            usuarioDAO.salvar(usuario);
        } catch (DAOException causa) {
            throw new ServiceExceptionn("Não foi possivel salvar", causa);
        }
    }

    public List<Usuario> buscarTodos(){
        return usuarioDAO.buscartodos();
    }

    public void excluir(Usuario usuario){
        usuarioDAO.excluir(usuario);
    }

}
