package br.com.sistemas.controller.bean;

import br.com.sistemas.model.entity.Usuario;
import br.com.sistemas.model.service.UsuarioService;
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
public class UsuarioBean {

    @Inject
    private UsuarioService usuarioService;

    // este objeto vincula os dados da tela
    private Usuario usuario = new Usuario();

    public void salvar(){
        try {
            usuarioService.salvar(usuario);

            //limpa os dados do formulario da tela
            usuario = new Usuario();

            //Mensagem
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com Sucesso!", null));
        } catch (Exception e){
            //codigo da mensagem na tela
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "erro ao salvar: " + e.getMessage(), null));
            e.printStackTrace();
        }
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
