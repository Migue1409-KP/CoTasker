package com.eternalnovices.cotasker.service.dto;

import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.crosscutting.util.UtilUUID;

public class EstadoDTO {
	private UUID id;
	private String descripcion;
	
	
	public EstadoDTO() {
		setId(UtilUUID.UUIDDEFECTO);
		setDescripcion(UtilTexto.VACIO);
	}
	
	
	
	public EstadoDTO(final UUID id, final String descripcion) {
		setId(id);
		setDescripcion(descripcion);
	}
	
	public final EstadoDTO setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id, UtilUUID.obtenerValorDefecto(id, UtilUUID.UUIDDEFECTO));
		return  this;
	}
	public final EstadoDTO  setDescripcion(final String descripcion) {
		this.descripcion = UtilTexto.obtenerValorDefecto(descripcion,UtilTexto.VACIO);
		return this;
	}
	public final UUID getId() {
		return id;
	}
	public final String getDescripcion() {
		return descripcion;
	}
	
	
	

}
