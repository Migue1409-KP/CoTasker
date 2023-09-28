package com.eternalnovices.cotasker.data.entity;

import java.util.UUID;

public class UsuarioEntity {
	private UUID id;
	private String nombre;
	private String apellido;
	private String correoElectronico;
	private boolean correoElectronicoConfirmado;
	private String contrasena;
	
	private UsuarioEntity(final UUID id, final String nombre, final String apellido, final String correoElectronico,
			final boolean correoElectronicoConfirmado, final String contrasena) {
		setId(id);
		setNombre(nombre);
		setApellido(apellido);
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		setContrasena(contrasena);
	}
	
	public static final UsuarioEntity crear(final UUID id, final String nombre, final String apellido, final String correoElectronico,
			final boolean correoElectronicoConfirmado, final String contrasena) {
		return new UsuarioEntity(id, nombre, apellido, correoElectronico, correoElectronicoConfirmado, contrasena);
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	private final void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	private final void setCorreoElectronicoConfirmado(final boolean correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
	}

	private final void setContrasena(final String contrasena) {
		this.contrasena = contrasena;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}

	public final String getApellido() {
		return apellido;
	}

	public final String getCorreoElectronico() {
		return correoElectronico;
	}

	public final boolean isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}

	public final String getContrasena() {
		return contrasena;
	}
}