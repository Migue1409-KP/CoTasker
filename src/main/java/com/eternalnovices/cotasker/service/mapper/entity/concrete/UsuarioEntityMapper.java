package com.eternalnovices.cotasker.service.mapper.entity.concrete;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.entity.UsuarioEntity;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;
import com.eternalnovices.cotasker.service.mapper.entity.EntityMapper;

public class UsuarioEntityMapper implements EntityMapper<UsuarioEntity, UsuarioDomain>{
	private static final EntityMapper<UsuarioEntity, UsuarioDomain> instancia = new UsuarioEntityMapper();
	
	private UsuarioEntityMapper() {
		super();
	}
	
	@Override
	public final UsuarioDomain toDomain(final UsuarioEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000399);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}	 
		return UsuarioDomain.crear(entity.getIdUsuario(), entity.getNombre(), entity.getApellido(),entity.getCorreoElectronico(),entity.isCorreoElectronicoConfirmado(),entity.getContrasena());
	}
	

	@Override
	public UsuarioEntity toEntity(UsuarioDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000003991);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return UsuarioEntity.crear(domain.getId(), domain.getNombre(), domain.getApellido(),domain.getCorreoElectronico(),domain.isCorreoElectronicoConfirmado(),domain.getContrasena());
	}
	
	public static final UsuarioDomain convertToDomain(final UsuarioEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final UsuarioEntity convertToEntity(final UsuarioDomain domain) {
		return instancia.toEntity(domain);
	}


}