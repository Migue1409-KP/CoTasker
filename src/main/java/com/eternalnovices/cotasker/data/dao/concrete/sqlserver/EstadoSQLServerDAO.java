package com.eternalnovices.cotasker.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.DataCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.data.dao.EstadoDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.EstadoEntity;

public class EstadoSQLServerDAO extends SQLDAO implements EstadoDAO{

	protected EstadoSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void modificar(final EstadoEntity estado) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("UPDATE Estado SET (idEstado,descripcion)WHERE id=(id)");
	}

	@Override
	public final Optional<EstadoEntity> consultarPorId(final UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT idEstado,descripcion ");
		sentencia.append("FROM Estado");
		sentencia.append("WHERE idEstado=?");
		
		Optional<EstadoEntity> resultado= Optional.empty();
		
		try(final var sentenciaPreparada=getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, id);
			try(final var resultados=sentenciaPreparada.executeQuery()){
				if(resultados.next()) {
					var estadoEntity = EstadoEntity.crear(UUID.fromString(resultados.getObject("id").toString()),
							resultados.getString("descripcion"));
					resultado= Optional.of(estadoEntity);
				}
			}catch(SQLException e) {
				var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000301);
				var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000302);
				throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
			}
		}catch(DataCoTaskerException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000301);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000303);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000301);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000304);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}

	@Override
	public final List<EstadoEntity> consultar(final EstadoEntity estado) {
		// TODO Auto-generated method stub
		return null;
	}

}
