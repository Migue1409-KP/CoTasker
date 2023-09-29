package com.eternalnovices.cotasker.data.dao.daofactory;

import com.eternalnovices.cotasker.data.dao.EstadoDAO;
import com.eternalnovices.cotasker.data.dao.ListaTareaDAO;
import com.eternalnovices.cotasker.data.dao.PrioridadDAO;
import com.eternalnovices.cotasker.data.dao.ProyectoDAO;
import com.eternalnovices.cotasker.data.dao.TareaDAO;
import com.eternalnovices.cotasker.data.dao.UsuarioDAO;

public abstract class DAOFactory {
	protected abstract void abrirConexion();
	public abstract void cerrarConexion();
	public abstract void iniciarTransaccion();
	public abstract void confirmarTransaccion();
	public abstract void cancelarTransaccion();
	
	public abstract EstadoDAO obtenerEstadoDAO();
	public abstract ListaTareaDAO obtenerListaTareaDAO();
	public abstract PrioridadDAO obtenerPrioridadDAO();
	public abstract ProyectoDAO obtenerProyectoDAO ();
	public abstract TareaDAO obtenerTareaDAO ();
	public abstract UsuarioDAO obtenerUsuarioDAO  ();

}
