package com.eternalnovices.cotasker.service.domain.usuario.rules;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.ValidationRule;

public class CorreoElectronicoComfirmadoUsuarioValidationRule implements ValidationRule<Boolean>{
	private static final ValidationRule<Boolean> instancia = new CorreoElectronicoComfirmadoUsuarioValidationRule();
	
	private   CorreoElectronicoComfirmadoUsuarioValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final Boolean dato) {
		instancia.validar(dato);
	}
	@Override
	public void validar(final Boolean dato) {
		validarObligatoriedad(dato);
	}

	private final  void validarObligatoriedad(final Boolean dato) {
		if(UtilObjeto.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000396);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
}
