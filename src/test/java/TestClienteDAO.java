import br.com.sistemas.model.dao.ClienteDAO;
import br.com.sistemas.model.dao.DAOException;
import br.com.sistemas.model.entity.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 27/12/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestClienteDAO {

    @Inject
    ClienteDAO clienteDAO;

    Cliente cliente = new Cliente();

    //@Test
    public void testeSalvar(){
        cliente.setNome("nome teste");
        try {
            clienteDAO.salvar(cliente);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listaTodos(){
        List<Cliente> clientes = clienteDAO.buscarTodos();
        for(Cliente cli : clientes){
            System.out.println(cli.toString());
        }
    }



}
