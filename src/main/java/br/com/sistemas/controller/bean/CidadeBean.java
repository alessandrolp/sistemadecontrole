package br.com.sistemas.controller.bean;

import br.com.sistemas.model.entity.Cidade;
import br.com.sistemas.model.service.CidadeService;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * Created by alessandro on 28/08/16.
 */

@Controller
@ViewScoped
public class CidadeBean {

    @Inject
    private CidadeService cidadeService;

    //objeto que vincula os dados da tela
    private Cidade cidade = new Cidade();

    public void salvar(){
        try {
            cidadeService.salvar(cidade);

            // limpa os dados do formulario da tela
            cidade = new Cidade();

            //mensagem
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar: " + e.getMessage(), null));
            e.printStackTrace();
        }
    }

    public void excluir(){
        cidadeService.excluir(cidade);
    }

    public CidadeService getCidadeService() {
        return cidadeService;
    }

    public void setCidadeService(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
