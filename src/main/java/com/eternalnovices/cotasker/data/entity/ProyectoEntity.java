package com.eternalnovices.cotasker.data.entity;

import java.util.List;
import java.util.UUID;
import com.eternalnovices.cotasker.data.entity.support.FechasEntity;

public class ProyectoEntity {
	private UUID idProyecto;
	private String nombre;
	private String descripcion;
	private FechasEntity fecha;
	private List<ListaTareasEntity> listaTareas;
	
	private ProyectoEntity(final UUID idProyecto, final String nombre, final String descripcion, final FechasEntity fechas,
			final List<ListaTareasEntity> listaTareas) {
		setIdProyecto(idProyecto);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFechas(fechas);
		setListaTareas(listaTareas);
	}
	
	public static final ProyectoEntity crear(final UUID idProyecto, final String nombre, final String descripcion, final FechasEntity fechas,
			final List<ListaTareasEntity> listaTareas) {
		return new ProyectoEntity(idProyecto, nombre, descripcion, fechas, listaTareas);
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

	private final void setFechas(final FechasEntity fechas) {
		this.fecha = fechas;
	}

	private final void setListaTareas(final List<ListaTareasEntity> listaTareas) {
		this.listaTareas = listaTareas;
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

	public final FechasEntity getFechas() {
		return fecha;
	}

	public final List<ListaTareasEntity> getListaTareas() {
		return listaTareas;
	}
}
