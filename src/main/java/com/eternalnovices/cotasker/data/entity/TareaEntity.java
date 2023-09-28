package com.eternalnovices.cotasker.data.entity;

import java.util.UUID;
import com.eternalnovices.cotasker.data.entity.support.FechasEntity;

public class TareaEntity {
	private UUID idTarea;
	private String nombre;
	private String descripcion;
	private FechasEntity fecha;
	private PrioridadEntity prioridad;
	private EstadoEntity estado;
	
	private TareaEntity(final UUID idTarea, final String nombre, final String descripcion, final FechasEntity fecha, final PrioridadEntity prioridad,
			final EstadoEntity estado) {
		setIdTarea(idTarea);
		setNombre(nombre);
		setDescripcion(descripcion);
		setFecha(fecha);
		setPrioridad(prioridad);
		setEstado(estado);
	}
	
	public static final TareaEntity crear(final UUID idTarea, final String nombre, final String descripcion, final FechasEntity fecha, final PrioridadEntity prioridad,
			final EstadoEntity estado) {
		return new TareaEntity(idTarea, nombre, descripcion, fecha, prioridad, estado);
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

	private final void setFecha(final FechasEntity fecha) {
		this.fecha = fecha;
	}

	private final void setPrioridad(final PrioridadEntity prioridad) {
		this.prioridad = prioridad;
	}

	private final void setEstado(final EstadoEntity estado) {
		this.estado = estado;
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

	public final FechasEntity getFecha() {
		return fecha;
	}

	public final PrioridadEntity getPrioridad() {
		return prioridad;
	}

	public final EstadoEntity getEstado() {
		return estado;
	}
}
