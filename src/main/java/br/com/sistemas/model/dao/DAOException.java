package br.com.sistemas.model.dao;

/**
 * Created by alessandro on 21/07/16.
 */
public class DAOException extends Exception {

    public DAOException(String mensagem, Exception causa) {
       super(mensagem, causa);
    }

}
