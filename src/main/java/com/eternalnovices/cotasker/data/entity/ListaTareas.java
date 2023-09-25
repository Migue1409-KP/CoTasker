package com.eternalnovices.cotasker.data.entity;

import java.sql.Date;
import java.util.UUID;

public class ListaTareas {
	private UUID idListaTareas;
	private String nombre;
	private String descripcion;
	private Date fechaCreacion;
	private Date fechaEstimadaInicio;
	private Date fechaEstimadaFin;
	private UUID idProyecto;
	private UUID idPrioridad;
	
	private ListaTareas(final UUID idListaTareas, final String nombre, final String descripcion, final Date fechaCreacion,
			final Date fechaEstimadaInicio, final Date fechaEstimadaFin, final UUID idProyecto, final UUID idPrioridad) {
		setIdListaTareas(idListaTareas);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFechaCreacion(fechaCreacion);
		setFechaEstimadaInicio(fechaEstimadaInicio);
		setFechaEstimadaFin(fechaEstimadaFin);
		setIdProyecto(idProyecto);
		setIdPrioridad(idPrioridad);
	}
	
	public static final ListaTareas crear(final UUID idListaTareas, final String nombre, final String descripcion, final Date fechaCreacion,
			final Date fechaEstimadaInicio, final Date fechaEstimadaFin, final UUID idProyecto, final UUID idPrioridad) {
		return new ListaTareas(idProyecto,nombre,descripcion,fechaCreacion,fechaEstimadaInicio,fechaEstimadaFin,idProyecto,idPrioridad);
	}

	private final void setIdListaTareas(final UUID idListaTareas) {
		this.idListaTareas = idListaTareas;
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

	private final void setIdProyecto(final UUID idProyecto) {
		this.idProyecto = idProyecto;
	}

	private final void setIdPrioridad(final UUID idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	public final UUID getIdListaTareas() {
		return idListaTareas;
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

	public final UUID getIdProyecto() {
		return idProyecto;
	}

	public final UUID getIdPrioridad() {
		return idPrioridad;
	}
}
