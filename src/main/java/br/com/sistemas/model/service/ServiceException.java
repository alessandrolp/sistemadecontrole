package br.com.sistemas.model.service;

import br.com.sistemas.model.dao.DAOException;

/**
 * Created by alessandro on 28/08/16.
 */
public class ServiceException extends Exception {

    public ServiceException(String mensagem) {
        super(mensagem);
    }

    public ServiceException (String mensagem, DAOException causa){
        super(mensagem, causa);
    }
}
