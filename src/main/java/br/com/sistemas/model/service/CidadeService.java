package br.com.sistemas.model.service;

import br.com.sistemas.model.dao.CidadeDAO;
import br.com.sistemas.model.dao.DAOException;
import br.com.sistemas.model.entity.Cidade;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 28/08/16.
 */

@Service
public class CidadeService {

    @Inject
    private CidadeDAO cidadeDAO;

    public void salvar(Cidade cidade) throws ServiceException {
        try {
            if(cidade.getNome() == null || cidade.getNome() == ""){
                throw new ServiceException("Cidade nao pode estar nulo");
            }
            cidadeDAO.salvar(cidade);
        } catch (DAOException causa) {
            throw new ServiceException("nao foi possivel salvar", causa);
        }
    }

    public Cidade buscarPorId(Long id){
        return cidadeDAO.buscarPorId(id);
    }

    public void excluir(Cidade cidade){
        cidadeDAO.excluir(cidade);
    }

    public List<Cidade> buscarTodos(){
        return cidadeDAO.buscarTodos();
    }


}
