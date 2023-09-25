package com.eternalnovices.cotasker.data.entity;

import java.util.UUID;

public class Prioridad {
	private UUID idPrioridad;
	private String descripcion;
	
	private Prioridad(final UUID idPrioridad, final String descripcion) {
		setIdPrioridad(idPrioridad);
		setDescripcion(descripcion);
	}
	
	public static final Prioridad crear(final UUID idPrioridad, final String descripcion) {
		return new Prioridad(idPrioridad, descripcion);
	}
	
	private final void setIdPrioridad(final UUID idPrioridad) {
		this.idPrioridad = idPrioridad;
	}
	
	private final void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public final UUID getIdPrioridad() {
		return idPrioridad;
	}

	public final String getDescripcion() {
		return descripcion;
	}
}
