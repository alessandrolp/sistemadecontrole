package br.com.sistemas.controller;

import br.com.sistemas.controller.util.MensagemUtil;
import br.com.sistemas.model.entity.Usuario;
import br.com.sistemas.model.service.ServiceException;
import br.com.sistemas.model.service.UsuarioService;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 28/08/16.
 */

@Controller
@ViewScoped
public class UsuarioController {

    @Inject
    private UsuarioService usuarioService;

    // este objeto vincula os dados da tela
    private Usuario usuario = new Usuario();

    //objeto que vincula a lista de usuarios que são apresentados na tela
    private List<Usuario> usuarioList;

    public UsuarioController(){
    }

    //metodo iniciado após o objeto ser instanciado, para que possa ter acesso a injeção da dependencia usuarioService
    // e com isso buscar a lista de usuarios e apresentar na tela
    @PostConstruct
    public void init(){
        setUsuarioList(usuarioService.buscarTodos());
    }

    public void salvar(){
        try {
            //invoca o metodo salvar do usuarioService, para que possa ser encaminhado para DAO e porteriormente ser persistido no BD
            Usuario usuarioSalvo = usuarioService.salvar(usuario);

            // atualiza a lista de usuarios que é apresentada na tela
            if(usuario.getId() == null){
                usuarioList.add(usuarioSalvo);
            }

            //limpa os dados do formulario da tela
            usuario = new Usuario();

            //Mensagem de sucesso
            MensagemUtil.mensagemInfo(MensagemUtil.SUCESSO_SALVAR);
        } catch (Exception e){
            //mensagem de erro
            MensagemUtil.mensagemErro(MensagemUtil.ERRO_SALVAR);
            e.printStackTrace();
        }
    }

    public void excluir (Usuario usuario){
        try {
            usuarioService.excluir(usuario);
            setUsuarioList(usuarioService.buscarTodos());
            MensagemUtil.mensagemInfo(MensagemUtil.SUCESSO_EXCLUIR);
        } catch (ServiceException e) {
            MensagemUtil.mensagemErro(MensagemUtil.ERRO_EXCLUIR);
            e.printStackTrace();
        }
    }

    public void editar (Usuario usuario){
        this.usuario = usuario;
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

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
}
