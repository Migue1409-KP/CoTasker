package com.eternalnovices.cotasker.service.bussineslogic.concrete.usuario;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.dao.UsuarioDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.UseCase;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;

public class ModificarUsuarioUseCase implements UseCase<UsuarioDomain>{
	private DAOFactory factoria;
	
	
	public ModificarUsuarioUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public void execute(UsuarioDomain domain) {
		// TODO Auto-generated method stub
		
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final void setFactoria(DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000266);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000267);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
	
	private final UsuarioDAO getUsuarioDAO() {
		return getFactoria().obtenerUsuarioDAO();
	}
}
	


