package br.com.sistemas.controller;

import br.com.sistemas.controller.util.MensagemUtil;
import br.com.sistemas.model.entity.Perfil;
import br.com.sistemas.model.service.PerfilService;
import br.com.sistemas.model.service.ServiceException;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by alessandro on 29/12/16.
 */

@Controller
@ViewScoped
public class PerfilController {

    @Inject
    private PerfilService perfilService;

    private Perfil perfil = new Perfil();

    private List<Perfil> perfilList;

    public PerfilController(){

    }

    @PostConstruct
    public void init(){
        setPerfilList(perfilService.buscarTodos());
    }

    public void salvar(){
        try {
            Perfil perfilSalvo = perfilService.salvar(perfil);
            if(perfil.getId() == null){
                perfilList.add(perfilSalvo);
                MensagemUtil.mensagemInfo(MensagemUtil.SUCESSO_SALVAR);
            } else if(perfil.getId() != null){
                setPerfilList(perfilService.buscarTodos());
                MensagemUtil.mensagemInfo(MensagemUtil.SUCESSO_EDITAR);
            }
            perfil = new Perfil();
        } catch (ServiceException e) {
            MensagemUtil.mensagemErro(MensagemUtil.ERRO_SALVAR);
            e.printStackTrace();
        }
    }

    public void excluir(Perfil perfil){
        try {
            perfilService.excluir(perfil);
            setPerfilList(perfilService.buscarTodos());
            MensagemUtil.mensagemInfo(MensagemUtil.SUCESSO_EXCLUIR);
        } catch (ServiceException e) {
            MensagemUtil.mensagemErro(MensagemUtil.ERRO_EXCLUIR);
            e.printStackTrace();
        }
    }

    public void editar(Perfil perfil){
        this.perfil = perfil;
    }

    public PerfilService getPerfilService() {
        return perfilService;
    }

    public void setPerfilService(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Perfil> getPerfilList() {
        return perfilList;
    }

    public void setPerfilList(List<Perfil> perfilList) {
        this.perfilList = perfilList;
    }
}
