import br.com.sistemas.model.dao.EstadoDAO;
import br.com.sistemas.model.entity.Estado;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by alessandro on 27/08/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TesteEstadoDAO {

    @Inject
    EstadoDAO estadoDAO;

    @Test
    public void salvar(){
        Estado estado = new Estado();
        estado.setUf("MG");
        estadoDAO.salvar(estado);
    }


}
