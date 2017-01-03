package br.com.sistemas.controller.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by alessandro on 29/12/16.
 */
public class MensagemUtil {

    public static final String SUCESSO_SALVAR = "Salvo com sucesso";

    public static final String ERRO_SALVAR = "Erro ao Salvar";

    public static final String SUCESSO_EXCLUIR = "Excluído com sucesso";

    public static final String ERRO_EXCLUIR = "Erro ao excluir";

    public static final String SUCESSO_EDITAR = "Alterado com sucesso";

    public static final String ERRO_ALTERAR = "Erro ao alterar";

    public static void mensagemInfo(String mensagem){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null));
    }

    public static void mensagemErro(String mensagem){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null));
    }

    public static void mensagemAviso(String mensagem){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, null));
    }
}
