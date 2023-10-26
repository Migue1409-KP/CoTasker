package com.eternalnovices.cotasker.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.service.domain.usuario.UsuarioDomain;
import com.eternalnovices.cotasker.service.dto.UsuarioDTO;
import com.eternalnovices.cotasker.service.mapper.dto.DTOMapper;

public class UsuarioDtoMapper implements DTOMapper<UsuarioDTO, UsuarioDomain> {
	private static final DTOMapper<UsuarioDTO, UsuarioDomain> instancia= new UsuarioDtoMapper();
	
	private UsuarioDtoMapper() {
		super();
	}
	
	@Override
	public UsuarioDomain toDomain(UsuarioDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000003994);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		return UsuarioDomain.crear(dto.getIdUsuario(),dto.getNombre(),dto.getApellido(),dto.getCorreoElectronico(),dto.isCorreoElectronicoConfirmado(),dto.getContrasena());
	}
	

	@Override
	public UsuarioDTO toDTO(UsuarioDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000003995);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		return UsuarioDTO.crear()
				.setIdUsuario(domain.getId())
				.setNombre(domain.getNombre())
				.setApellido(domain.getApellido())
				.setCorreoElectronico(domain.getCorreoElectronico())
				.setCorreoElectronicoConfirmado(domain.isCorreoElectronicoConfirmado())
				.setContrasena(domain.getContrasena());
	}
	
	public static final UsuarioDomain convertToDomain(final UsuarioDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final UsuarioDTO convertToDTO(final UsuarioDomain domain) {
		return instancia.toDTO(domain);
	}
	public static final List<UsuarioDTO>  convertToListDTO(final List<UsuarioDomain> dto){
		List<UsuarioDTO> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToDTO(dto.get(i)));
		}
		
		return resultados;
	}
}
