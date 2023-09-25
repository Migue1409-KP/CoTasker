package com.eternalnovices.cotasker.data.entity;

import java.util.UUID;

public class Estado {
	private UUID idEstado;
	private String descripcion;
	
	private Estado(final UUID idEstado, final String descripcion) {
		setIdEstado(idEstado);
		setDescripcion(descripcion);
	}
	
	public static final Estado crear(final UUID idEstado, final String descripcion) {
		return new Estado(idEstado, descripcion);
	}

	private final void setIdEstado(final UUID idEstado) {
		this.idEstado = idEstado;
	}

	private final void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public final UUID getIdEstado() {
		return idEstado;
	}

	public final String getDescripcion() {
		return descripcion;
	}
}
