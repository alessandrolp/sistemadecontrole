import br.com.sistemas.model.dao.DAOException;
import br.com.sistemas.model.dao.UsuarioDAO;
import br.com.sistemas.model.entity.Usuario;
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

    Usuario usuario = new Usuario();

    //@Test
    public void testeSalvar(){
        usuario.setNome("Ana Rita");
        usuario.setEmail("aninha@hotmail.com");
        usuario.setSenha("qegasgaeg4849");
        try {
            usuarioDAO.salvar(usuario);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    //@Test
    public void testeExcluir(){
        Usuario usuarioExcluir = usuarioDAO.buscarPorId(10L);
        usuarioDAO.excluir(usuarioExcluir);
    }


}
