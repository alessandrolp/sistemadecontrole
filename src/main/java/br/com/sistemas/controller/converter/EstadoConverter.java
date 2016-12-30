package br.com.sistemas.controller.converter;

import br.com.sistemas.model.entity.Estado;
import br.com.sistemas.model.service.EstadoService;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

/**
 * Created by alessandro on 29/08/16.
 */

@Component
public class EstadoConverter implements Converter{

    @Inject
    EstadoService estadoService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String id) {
        try {
            Estado estado = estadoService.buscarPorId(Long.parseLong(id));
            return estado;
        } catch (NumberFormatException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object estado) {
        try {
            Estado est = (Estado) estado;
            return est.getId().toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
