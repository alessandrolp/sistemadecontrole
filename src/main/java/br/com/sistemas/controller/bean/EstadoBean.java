package br.com.sistemas.controller.bean;

import br.com.sistemas.model.entity.Estado;
import br.com.sistemas.model.service.EstadoService;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 28/08/16.
 */

@Controller
@ViewScoped
public class EstadoBean {

    @Inject
    private EstadoService estadoService;

    //objeto que vincula os dados da tela
    private Estado estado = new Estado();

    private List<Estado> listaEstados;

    @PostConstruct
    public void init(){
        listaEstados = estadoService.buscarTodos();
    }

    public void salvar(){
        try {
            estadoService.salvar(estado);

            // limpa os dados do formulario da tela
            estado = new Estado();

            // atualiza a lista de cadastro
            listaEstados = estadoService.buscarTodos();

            //mensagem
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar: " + e.getMessage(), null));
            e.printStackTrace();
        }
    }

    public void excluir(){
        estadoService.excluir(estado);
    }

    public EstadoService getEstadoService() {
        return estadoService;
    }

    public void setEstadoService(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }
}
