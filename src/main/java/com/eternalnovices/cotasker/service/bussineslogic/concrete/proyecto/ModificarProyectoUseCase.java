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
import com.eternalnovices.cotasker.service.mapper.entity.concrete.ProyectoEntityMapper;

public class ModificarProyectoUseCase implements UseCase<ProyectoDomain>{
	private DAOFactory factoria;
	
	public ModificarProyectoUseCase (DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(ProyectoDomain domain) {
		validarExistenciaMismoNombre(domain.getNombre());
		validarExistenciaMismoId(domain.getIdProyecto());
		validarExistenciaDescripcion(domain.getDescripcion());
		actualizar(domain);
		
	}

	private void actualizar(final ProyectoDomain domain) {
		getProyectoDAO().modificar(ProyectoEntityMapper.convertToEntity(domain));
	}

	private void validarExistenciaDescripcion(String descripcion) {
		
		
	}

	private void validarExistenciaMismoId(UUID idProyecto) {
		// TODO Auto-generated method stub
		
	}

	private void validarExistenciaMismoNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000000901);
			final var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000000902);
			throw ServiceCoTaskerException.crear(mensajeUsuario,mensajeTecnico);
		}
		this.factoria=factoria;
	}
	
	private final ProyectoDAO getProyectoDAO() {
		return getFactoria().obtenerProyectoDAO();
	}
	
	
}
