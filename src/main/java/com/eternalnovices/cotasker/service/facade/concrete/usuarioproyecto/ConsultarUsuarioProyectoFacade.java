package com.eternalnovices.cotasker.service.facade.concrete.usuarioproyecto;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;
import com.eternalnovices.cotasker.data.dao.daofactory.enumerator.TipoDAOFactory;
import com.eternalnovices.cotasker.service.bussineslogic.concrete.usuarioproyecto.ConsultarUsuarioProyectoUseCase;
import com.eternalnovices.cotasker.service.bussineslogic.validator.concrete.usuarioproyecto.ConsultarUsuarioProyectoValidator;
import com.eternalnovices.cotasker.service.domain.usuarioproyecto.UsuarioProyectoDomain;
import com.eternalnovices.cotasker.service.dto.UsuarioProyectoDTO;
import com.eternalnovices.cotasker.service.facade.FacadeFind;
import com.eternalnovices.cotasker.service.mapper.dto.concrete.UsuarioProyectoDTOMapper;

public class ConsultarUsuarioProyectoFacade implements FacadeFind<UsuarioProyectoDTO>{
	@Override
	public List<UsuarioProyectoDTO> execute(final UsuarioProyectoDTO dto) {
		final UsuarioProyectoDomain domain = UsuarioProyectoDTOMapper.convertToDomain(dto);
		ConsultarUsuarioProyectoValidator.ejecutar(domain);
		List<UsuarioProyectoDTO> resultados = new ArrayList<>();
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daofactory.iniciarTransaccion();
			var useCase = new ConsultarUsuarioProyectoUseCase(daofactory);
			resultados = UsuarioProyectoDTOMapper.convertToListDTO(useCase.execute(domain));
			daofactory.confirmarTransaccion();
		} catch (CoTaskerException exception) {
			daofactory.cancelarTransaccion();
			throw exception;
		} catch (Exception exception) {
			daofactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000403);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000404);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		} finally {
			daofactory.cerrarConexion();
		}
		return resultados;
	}
}
