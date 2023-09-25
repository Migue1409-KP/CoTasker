package com.eternalnovices.cotasker.data.entity;

import java.sql.Date;
import java.util.UUID;

public class Tarea {
	private UUID idTarea;
	private String nombre;
	private String descripcion;
	private Date fechaCreacion;
	private Date fechaEstimadaInicio;
	private Date fechaEstimadaFin;
	private UUID idLista;
	private UUID idPrioridad;
	private UUID idEstado;
	
	private Tarea(final UUID idTarea, final String nombre, final String descripcion, final Date fechaCreacion, final Date fechaEstimadaInicio,
			final Date fechaEstimadaFin, final UUID idLista, final UUID idPrioridad, final UUID idEstado) {
		setIdTarea(idTarea);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFechaCreacion(fechaCreacion);
		setFechaEstimadaInicio(fechaEstimadaInicio);
		setFechaEstimadaFin(fechaEstimadaFin);
		setIdLista(idLista);
		setIdPrioridad(idPrioridad);
		setIdEstado(idEstado);
	}
	
	public static final Tarea crear(final UUID idTarea, final String nombre, final String descripcion, final Date fechaCreacion, final Date fechaEstimadaInicio,
			final Date fechaEstimadaFin, final UUID idLista, final UUID idPrioridad, final UUID idEstado) {
		return new Tarea(idTarea,nombre,descripcion,fechaCreacion,fechaEstimadaInicio,fechaEstimadaFin,idLista,idPrioridad,idEstado);
	}

	private final void setIdTarea(final UUID idTarea) {
		this.idTarea = idTarea;
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

	private final void setIdLista(final UUID idLista) {
		this.idLista = idLista;
	}

	private final void setIdPrioridad(final UUID idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	private final void setIdEstado(final UUID idEstado) {
		this.idEstado = idEstado;
	}

	public final UUID getIdTarea() {
		return idTarea;
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

	public final UUID getIdLista() {
		return idLista;
	}

	public final UUID getIdPrioridad() {
		return idPrioridad;
	}

	public final UUID getIdEstado() {
		return idEstado;
	}
}
