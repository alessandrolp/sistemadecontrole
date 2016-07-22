import br.com.sistemas.model.dao.DAOException;
import br.com.sistemas.model.dao.UsuarioDAO;
import br.com.sistemas.model.entity.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alessandro on 16/07/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestUsuarioDAO {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Test
    public void testSalvar() throws DAOException {
        //usuario.setId(3L);
        Usuario usuario = new Usuario();
        usuario.setNome("ANA RITA");
        usuario.setEmail("aninha@gmail.com");
        usuario.setSenha("123456");
        usuarioDAO.salvar(usuario);
    }

}
