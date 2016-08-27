import br.com.sistemas.model.dao.DAOException;
import br.com.sistemas.model.dao.UsuarioDAO;
import br.com.sistemas.model.entity.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

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

   @Test
    public void testSalvar() throws DAOException {
        Usuario usuario = new Usuario();
        //usuario.setId(1L);
        usuario.setNome("JOAO PEDRO");
        usuario.setEmail("joao@gmail.com");
        usuario.setSenha("91919191");
        usuarioDAO.salvar(usuario);
    }

    //@Test
    public void testExcluir(){

        Usuario usuarioexc = usuarioDAO.buscarPorId(1L);
        usuarioDAO.excluir(usuarioexc);
    }

}
