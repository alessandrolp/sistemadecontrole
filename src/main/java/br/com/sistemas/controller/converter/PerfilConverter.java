package br.com.sistemas.controller.converter;

import br.com.sistemas.model.entity.Perfil;
import br.com.sistemas.model.service.PerfilService;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

/**
 * Created by alessandro on 29/12/16.
 */

@Component
public class PerfilConverter implements Converter{

    @Inject
    private PerfilService perfilService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String idTela) {
        try {
            return perfilService.buscarPorId(Long.parseLong(idTela));
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object objPerfil) {
        try {
            Perfil perfil = (Perfil) objPerfil;
            return perfil.getId().toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
