package com.eternalnovices.cotasker.service.bussineslogic.concrete.proyecto;


import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.dao.ProyectoDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.UseCase;
import com.eternalnovices.cotasker.service.domain.proyecto.ProyectoDomain;

public class EliminarProyectoUseCase implements UseCase<ProyectoDomain> {
	private DAOFactory factoria; 
	
	
	public EliminarProyectoUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	@Override
	public void execute(ProyectoDomain domain) {
		validarExistenciaRegistro(domain.getIdProyecto());
		eliminar(domain.getIdProyecto());
	}
	
	private void eliminar(final UUID idProyecto) {
		getProyectoDAO().eliminar(idProyecto);
		
	}
	
	private void validarExistenciaRegistro(final UUID idProyecto) {
		final var resultados = getProyectoDAO().consultarPorId(idProyecto);
		
		if(resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000337);
			throw ServiceCoTaskerException.crear(mensajeUsuario);
		}
	}
		
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000334);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000335);
			throw ServiceCoTaskerException.crear(mensajeUsuario,mensajeTecnico);
			}
		this.factoria=factoria;
	}
	
	private final ProyectoDAO getProyectoDAO() {
		return getFactoria().obtenerProyectoDAO();
	}
}
