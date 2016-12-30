import br.com.sistemas.model.dao.DAOException;
import br.com.sistemas.model.dao.UsuarioDAO;
import br.com.sistemas.model.entity.Usuario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 16/07/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestUsuarioDAO {

    @Inject
    UsuarioDAO usuarioDAO;

    Usuario usuario = new Usuario();

    @Test
    public void testeSalvar() throws DAOException {
        usuario.setNome("Ana Rita");
        usuario.setEmail("aninha@hotmail.com");
        usuario.setSenha("qegasgaeg4849");
        usuarioDAO.salvar(usuario);
    }

    @Test
    public void testeExcluir() throws DAOException {
        Usuario usuarioExcluir = usuarioDAO.buscarPorId(9L);
        usuarioDAO.excluir(usuarioExcluir);
    }

    @Test
    public void testBuscarTodos() throws DAOException {
        usuario.setNome("teste");
        usuario.setEmail("teste");
        usuario.setSenha("teste");

        usuarioDAO.salvar(usuario);
        List<Usuario> todosUsuarios = usuarioDAO.buscarTodos();

        Assert.assertTrue(todosUsuarios.size() > 0 );
    }

}
