package br.com.sistemas.controller.bean;

import br.com.sistemas.model.entity.Estado;
import br.com.sistemas.model.service.EstadoService;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 27/08/16.
 */

@Controller
@ViewScoped
public class EstadoBean {

    @Inject
    EstadoService estadoService;

    private List<Estado> listaEstados;

    @PostConstruct
    public void init(){
        listaEstados = estadoService.buscarTodos();
    }

    public List<Estado> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }
}
