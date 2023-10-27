package com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.tarea;

import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;
import com.eternalnovices.cotasker.service.bussineslogic.validator.Validator;
import com.eternalnovices.cotasker.service.domain.tarea.TareaDomain;
import com.eternalnovices.cotasker.service.domain.tarea.rules.DescripcionTareaValitationRule;
import com.eternalnovices.cotasker.service.domain.tarea.rules.IdTareaValidationRule;
import com.eternalnovices.cotasker.service.domain.tarea.rules.NombreTareaValitadionRule;

public final class ConsultarTareaValidator implements Validator<TareaDomain>{
	private static final Validator<TareaDomain> instancia = new ConsultarTareaValidator();
	
	private ConsultarTareaValidator() {
		super();
	}
	
	public static final void ejecutar(final TareaDomain domain) {
		instancia.execute(domain);
	}
	
	@Override
	public void execute(TareaDomain domain) {
		if(!UtilObjeto.esNulo(domain)) {
			if(!UtilUUID.esNulo(domain.getIdTarea())) {				
				IdTareaValidationRule.ejecutarValidacion(domain.getIdTarea());
			}
			
			if(!UtilTexto.estaVacio(domain.getNombre())) {				
				NombreTareaValitadionRule.ejecutarValidacion(domain.getNombre());
			}
			
			if(!UtilTexto.estaVacio(domain.getNombre())) {				
				DescripcionTareaValitationRule.ejecutarValidacion(domain.getDescripcion());
			}
		}
	}

}
