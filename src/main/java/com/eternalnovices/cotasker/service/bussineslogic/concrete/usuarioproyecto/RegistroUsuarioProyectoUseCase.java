package com.eternalnovices.cotasker.service.bussineslogic.concrete.usuarioproyecto;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.dao.UsuarioProyectoDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.UseCase;
import com.eternalnovices.cotasker.service.domain.usuarioproyecto.UsuarioProyectoDomain;

public class RegistroUsuarioProyectoUseCase implements UseCase<UsuarioProyectoDomain> {
	private DAOFactory factoria;
	
	
	public RegistroUsuarioProyectoUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(UsuarioProyectoDomain domain) {
		// TODO Auto-generated method stub
		
	}
	private final DAOFactory getFactoria() {
		return factoria;
	}
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000917);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000918);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria=factoria;
	}
	
	private final UsuarioProyectoDAO getUsuarioProyectoDAO() {
		return getFactoria().obtenerUsuarioProyectoDAO();
	}

}
