package br.com.sistemas.model.service;

import br.com.sistemas.model.dao.DAOException;

/**
 * Created by alessandro on 21/07/16.
 */
public class ServiceExceptionn extends Exception {

    public ServiceExceptionn(String mensagem){
        super(mensagem);
    }

    public ServiceExceptionn(String mensagem, DAOException causa) {
        super(mensagem, causa);
    }

}
