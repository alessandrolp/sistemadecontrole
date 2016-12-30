package br.com.sistemas.controller;

import br.com.sistemas.model.entity.Cliente;
import br.com.sistemas.model.service.ClienteService;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 27/12/16.
 */

@Controller
@ViewScoped
public class ClienteController {

    @Inject
    private ClienteService clienteService;

    //objeto que vincula os dados da tela
    private Cliente cliente = new Cliente();

    private List<Cliente> clienteList;

    public void salvar (){
        try {
            clienteService.salvar(cliente);
            clienteList.add(cliente);

            // limpa os dados do formulario da tela
            cliente = new Cliente();

            //mensagem
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SALVO COM SUCESSO", null));
        } catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO AO SALVAR", null));
            e.printStackTrace();
        }
    }

    public ClienteController(){

    }

    @PostConstruct
    public void init(){
        clienteList = clienteService.buscarTodos();
    }

    public void excluir() {
        clienteService.excluir(cliente);
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
