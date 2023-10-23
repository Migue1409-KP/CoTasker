package com.eternalnovices.cotasker.service.dto;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;

public class PrioridadDTO {
	
	private UUID id;
	private String descripcion;
	
	public PrioridadDTO() {
		setId(UtilUUID.UUIDDEFECTO);
		setDescripcion(UtilTexto.VACIO);
	}
	
	public PrioridadDTO(final UUID id, final String descripcion) {
		setId(id);
		setDescripcion(descripcion);
	}
	
	public static final PrioridadDTO crear() {
		return new PrioridadDTO();
	}
	
	public final UUID getId() {
		return id;
	}
	
	public final String getDescripcion() {
		return descripcion;
	}
	
	public final PrioridadDTO setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id, UtilUUID.obtenerValorDefecto(id, UtilUUID.UUIDDEFECTO));
		return this;
	}
	
	public final PrioridadDTO setDescripcion(final String descripcion) {
		this.descripcion = UtilTexto.obtenerValorDefecto(descripcion,UtilTexto.VACIO);
		return this;
	}
}
