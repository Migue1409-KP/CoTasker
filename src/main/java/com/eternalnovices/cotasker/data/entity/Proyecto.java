package com.eternalnovices.cotasker.data.entity;

import java.sql.Date;
import java.util.UUID;

public class Proyecto {
	private UUID idProyecto;
	private String nombre;
	private String descripcion;
	private Date fechaCreacion;
	private Date fechaEstimadaInicio;
	private Date fechaEstimadaFin;
	
	private Proyecto(final UUID idProyecto, final String nombre, final String descripcion, final Date fechaCreacion, final Date fechaEstimadaInicio,
			final Date fechaEstimadaFin) {
		setIdProyecto(idProyecto);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFechaCreacion(fechaCreacion);
		setFechaEstimadaInicio(fechaEstimadaInicio);
		setFechaEstimadaFin(fechaEstimadaFin);
	}

	public static final Proyecto crear(final UUID idProyecto, final String nombre, final String descripcion, final Date fechaCreacion, final Date fechaEstimadaInicio,
			final Date fechaEstimadaFin) {
		return new Proyecto(idProyecto,nombre,descripcion,fechaCreacion,fechaEstimadaInicio,fechaEstimadaFin);
	}
	
	private final void setIdProyecto(final UUID idProyecto) {
		this.idProyecto = idProyecto;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	private final void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	private final void setFechaCreacion(final Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	private final void setFechaEstimadaInicio(final Date fechaEstimadaInicio) {
		this.fechaEstimadaInicio = fechaEstimadaInicio;
	}

	private final void setFechaEstimadaFin(final Date fechaEstimadaFin) {
		this.fechaEstimadaFin = fechaEstimadaFin;
	}

	public final UUID getIdProyecto() {
		return idProyecto;
	}

	public final String getNombre() {
		return nombre;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final Date getFechaCreacion() {
		return fechaCreacion;
	}

	public final Date getFechaEstimadaInicio() {
		return fechaEstimadaInicio;
	}

	public final Date getFechaEstimadaFin() {
		return fechaEstimadaFin;
	}
}
