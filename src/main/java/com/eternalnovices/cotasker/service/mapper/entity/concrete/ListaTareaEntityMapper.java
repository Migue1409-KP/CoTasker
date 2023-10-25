package com.eternalnovices.cotasker.service.mapper.entity.concrete;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.ServiceCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.data.entity.ListaTareasEntity;
import com.eternalnovices.cotasker.data.entity.PrioridadEntity;
import com.eternalnovices.cotasker.service.domain.listatareas.ListaTareasDomain;
import com.eternalnovices.cotasker.service.domain.prioridad.PrioridadDomain;
import com.eternalnovices.cotasker.service.mapper.entity.EntityMapper;

public class ListaTareaEntityMapper implements EntityMapper<ListaTareasEntity, ListaTareasDomain> {
	private static final EntityMapper<ListaTareasEntity, ListaTareasDomain> instancia = new ListaTareasEntityMapper();
	
	private ListaTareaEntityMapper() {
		super();
	}
	
	@Override
	public final ListaTareasDomain toDomain(final ListaTareasEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000372);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return ListaTareasDomain.crear(entity.getIdListaTareas(), entity.getNombre(), entity.getDescripcion(), entity.getFecha(), entity.getPrioridad(), entity.getProyecto());
	}

	@Override
	public ListaTareasEntity toEntity(final ListaTareasDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000373);
			throw ServiceCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return ListaTareasEntity.crear(domain.getIdListaTareas(), domain.getNombre(), domain.getDescripcion(), domain.getFecha(), domain.getPrioridad(), domain.getProyecto());
	}
	
	public static final ListaTareasDomain convertToDomain(final ListaTareasEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final ListaTareasEntity convertToEntity(final ListaTareasDomain domain) {
		return instancia.toEntity(domain);
	}
}
