package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.listatareas;

import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;
import com.eternalnovices.cotasker.service.domain.listatareas.rules.DescripcionListaTareasValitationRule;
import com.eternalnovices.cotasker.service.domain.listatareas.rules.IdListaTareasValidationRule;
import com.eternalnovices.cotasker.service.domain.listatareas.rules.NombreListaTareasValitadionRule;
import com.eternalnovices.cotasker.service.domain.tarea.TareaDomain;
import com.eternalnovices.cotasker.service.domain.tarea.rules.DescripcionTareaValitationRule;
import com.eternalnovices.cotasker.service.domain.tarea.rules.IdTareaValidationRule;
import com.eternalnovices.cotasker.service.domain.tarea.rules.NombreTareaValitadionRule;

public final class ConsultarListaTareasValidator implements Validator<ListaTareasDomain>{
	private static final Validator<ListaTareasDomain> instancia = new ConsultarListaTareasValidator();
	
	private ConsultarListaTareasValidator() {
		super();
	}
	
	public static final void ejecutar(final ListaTareasDomain domain) {
		instancia.execute(domain);
	}
	
	@Override
	public void execute(ListaTareasDomain domain) {
		if(!UtilObjeto.esNulo(domain)) {
			if(!UtilUUID.esNulo(domain.getIdListaTareas())) {				
				IdListaTareasValidationRule.ejecutarValidacion(domain.getIdListaTareas());
			}
			
			if(!UtilTexto.estaVacio(domain.getNombre())) {				
				NombreListaTareasValitadionRule.ejecutarValidacion(domain.getNombre());
			}
			
			if(!UtilTexto.estaVacio(domain.getNombre())) {				
				DescripcionListaTareasValitationRule.ejecutarValidacion(domain.getDescripcion());
			}
		}
	}

}
