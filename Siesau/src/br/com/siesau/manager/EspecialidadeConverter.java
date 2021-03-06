package br.com.siesau.manager;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.siesau.entity.Especialidade;
import br.com.siesau.persistence.EspecialidadeDao;

@SuppressWarnings("rawtypes")
@FacesConverter(forClass = Especialidade.class)
public class EspecialidadeConverter implements Converter  {
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String key) {
		EspecialidadeDao dao = new EspecialidadeDao(new Especialidade());
		return dao.findByCode(Integer.parseInt(key));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object espcialidadeOb) {
		if(espcialidadeOb != null && espcialidadeOb instanceof Especialidade){
			Especialidade especialidade = (Especialidade) espcialidadeOb;
			
			return String.valueOf(especialidade.getCdEspec());
		}
		return "";
	}


}
