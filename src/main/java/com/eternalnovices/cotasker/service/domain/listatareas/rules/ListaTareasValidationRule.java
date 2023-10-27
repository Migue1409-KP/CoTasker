package com.eternalnovices.cotasker.service.domain.listatareas.rules;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.ValidationRule;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;

public final class ListaTareasValidationRule implements ValidationRule<ListaTareasDomain> {
	private static final ValidationRule<ListaTareasDomain> instancia = new ListaTareasValidationRule();
	
	private ListaTareasValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final ListaTareasDomain data) {
		instancia.validar(data);
	}
	
	@Override
	public void validar(ListaTareasDomain data) {
		if(UtilObjeto.esNulo(data)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000264);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
}