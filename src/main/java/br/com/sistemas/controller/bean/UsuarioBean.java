package br.com.sistemas.controller.bean;

import br.com.sistemas.model.entity.Usuario;
import br.com.sistemas.model.service.ServiceExceptionn;
import br.com.sistemas.model.service.UsuarioService;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 25/08/16.
 */

@Controller
@ViewScoped
public class UsuarioBean {

    //este objeto vincula os dados da tela
    private Usuario usuario = new Usuario();

    @Inject
    private UsuarioService usuarioService;

    private List<Usuario> listaUsuario;

    @PostConstruct
    public void init(){
        listaUsuario = usuarioService.buscarTodos();
    }

    public void atualizaListaUsuarios(){
        listaUsuario = usuarioService.buscarTodos();
    }

    public void salvar(){
        try {
            usuarioService.salvar(usuario);

            //limpa os dados
            usuario = new Usuario();

            atualizaListaUsuarios();

            //codigo da mensagem na tela "com sucesso"
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com Sucesso!", null));

        } catch (ServiceExceptionn e) {
            //codigo da mensagem na tela "com falha"
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar: " + e.getMessage(), null));
            e.printStackTrace();
        }
    }

    public void excluir(){
        usuarioService.excluir(usuario);
        atualizaListaUsuarios();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
}
