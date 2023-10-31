package com.eternalnovices.cotasker.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.eternalnovices.cotasker.data.dao.EstadoDAO;
import com.eternalnovices.cotasker.data.dao.ListaTareaDAO;
import com.eternalnovices.cotasker.data.dao.PrioridadDAO;
import com.eternalnovices.cotasker.data.dao.ProyectoDAO;
import com.eternalnovices.cotasker.data.dao.TareaDAO;
import com.eternalnovices.cotasker.data.dao.UsuarioDAO;
import com.eternalnovices.cotasker.data.dao.UsuarioProyectoDAO;
import com.eternalnovices.cotasker.data.dao.daofactory.DAOFactory;


public class SQLServerDAOFactory extends DAOFactory {
	
	private Connection conexion;
	private static final Logger logger = Logger.getLogger(SQLServerDAOFactory.class.getName());
	
	public SQLServerDAOFactory() {
		abrirConexion();
	}
	
	@Override
    protected final void abrirConexion() {
        try {
            String url = "jdbc:sqlserver://<server>:<port>;databaseName=<database>";
            String user = "<username>";
            String password = "<password>";
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al abrir la conexión", e);
            //TODO Customized exception
        }
    }

    @Override
    public final void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al cerrar la conexión", e);
            //TODO Customized exception
        }
    }

    @Override
    public final void iniciarTransaccion() {
        try {
            if (conexion != null && !conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al iniciar la transacción", e);
            //TODO Customized exception
        }
    }

    @Override
    public final void confirmarTransaccion() {
        try {
            if (conexion != null && !conexion.getAutoCommit()) {
                conexion.commit();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al confirmar la transacción", e);
            //TODO Customized exception
        }
    }

    @Override
    public final void cancelarTransaccion() {
        try {
            if (conexion != null && !conexion.getAutoCommit()) {
                conexion.rollback();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al cancelar la transacción", e);
            //TODO Customized exception
        }
    }

	@Override
	public final EstadoDAO obtenerEstadoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final ListaTareaDAO obtenerListaTareaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final PrioridadDAO obtenerPrioridadDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final ProyectoDAO obtenerProyectoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final TareaDAO obtenerTareaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final UsuarioDAO obtenerUsuarioDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioProyectoDAO obtenerUsuarioProyectoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
