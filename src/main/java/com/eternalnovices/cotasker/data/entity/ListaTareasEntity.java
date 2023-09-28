package com.eternalnovices.cotasker.data.entity;

import java.util.List;
import java.util.UUID;
import com.eternalnovices.cotasker.data.entity.support.FechasEntity;

public class ListaTareasEntity {
	private UUID idListaTareas;
	private String nombre;
	private String descripcion;
	private FechasEntity fecha;
	private PrioridadEntity prioridad;
	private List<TareaEntity> tarea;
	
	private ListaTareasEntity(final UUID idListaTareas, final String nombre, final String descripcion, final FechasEntity fechas,
			final PrioridadEntity prioridad, final List<TareaEntity> tarea) {
		setIdListaTareas(idListaTareas);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFechas(fechas);
		setPrioridad(prioridad);
		setTarea(tarea);
	}
	
	public static final ListaTareasEntity crear(final UUID idListaTareas, final String nombre, final String descripcion, final FechasEntity fechas,
			final PrioridadEntity prioridad, final List<TareaEntity> tarea) {
		return new ListaTareasEntity(idListaTareas, nombre, descripcion, fechas, prioridad, tarea);
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

	private final void setFechas(final FechasEntity fechas) {
		this.fecha = fechas;
	}

	private final void setPrioridad(final PrioridadEntity prioridad) {
		this.prioridad = prioridad;
	}

	private final void setTarea(final List<TareaEntity> tarea) {
		this.tarea = tarea;
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

	public final FechasEntity getFechas() {
		return fecha;
	}

	public final PrioridadEntity getPrioridad() {
		return prioridad;
	}

	public final List<TareaEntity> getTarea() {
		return tarea;
	}
}
