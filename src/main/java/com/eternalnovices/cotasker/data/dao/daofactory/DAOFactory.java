package com.eternalnovices.cotasker.data.dao.daofactory;

import com.eternalnovices.cotasker.data.dao.EstadoDAO;
import com.eternalnovices.cotasker.data.dao.ListaTareaDAO;
import com.eternalnovices.cotasker.data.dao.PrioridadDAO;
import com.eternalnovices.cotasker.data.dao.ProyectoDAO;
import com.eternalnovices.cotasker.data.dao.TareaDAO;
import com.eternalnovices.cotasker.data.dao.UsuarioDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.concrete.SQLServerDAOFactory;
import com.eternalnovices.cotasker.data.dao.daofactory.enumerator.TipoDAOFactory;

public abstract class DAOFactory {
	
	public static final DAOFactory obtenerDAOFactory(final TipoDAOFactory factoria) {
		switch (factoria) {
		case SQLSERVER: {
			return new SQLServerDAOFactory();
		}
		case POSTGRESSQL: {
			//TODO improve customized exceptions
			throw new RuntimeException("POSTGRESSQL no soportada");
		}
		case MYSQL: {
			//TODO improve customized exceptions
			throw new RuntimeException("MYSQL no soportada");
		}
		case ORACLE: {
			//TODO improve customized exceptions
			throw new RuntimeException("ORACLE no soportada");
		}
		default:
			throw new RuntimeException(factoria + " no soportada");
		}
	}
	
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
