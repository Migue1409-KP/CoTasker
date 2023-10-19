package com.eternalnovices.cotasker.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.DataCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;
import com.eternalnovices.cotasker.crosscutting.util.UtilTexto;
import com.eternalnovices.cotasker.data.dao.PrioridadDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.PrioridadEntity;

public class PrioridadSQLServerDAO extends SQLDAO implements PrioridadDAO {

	protected PrioridadSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void modificar(final PrioridadEntity prioridad) {
		final var sentencia = new StringBuilder();
		sentencia.append("UPDATE Prioridad");
		sentencia.append("SET descripcion=?, ");
		sentencia.append("WHERE idPrioridad=? ");
		try (final var sentenciaPreparada=getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, prioridad.getIdPrioridad());
			sentenciaPreparada.setString(2, prioridad.getDescripcion());
			
			sentenciaPreparada.executeUpdate();
		} catch (final SQLException e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000308);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000309);
			throw DataCoTaskerException.crear(e,mensajeUsuario,mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000308);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000310);
			throw DataCoTaskerException.crear(e,mensajeUsuario,mensajeTecnico);
		}
	}

	@Override
	public final Optional<PrioridadEntity> consultarPorId(final UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT prio.idPrioridad,prio.descripcion ");
		sentencia.append("FROM Prioridad prio");
		sentencia.append("WHERE idPrioridad=?");
		
		Optional<PrioridadEntity> resultado= Optional.empty();
		
		try(final var sentenciaPreparada=getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, id);
			resultado=ejecutarConsultaPorId(sentenciaPreparada);
			
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
	

	private final  Optional<PrioridadEntity> ejecutarConsultaPorId(PreparedStatement sentenciaPreparada) {
		Optional<PrioridadEntity>resultado=Optional.empty();
		try(final var resultados=sentenciaPreparada.executeQuery()){
			if(resultados.next()) {
				var prioridadEntity=PrioridadEntity.crear(
						UUID.fromString(resultados.getObject("prio.idPrioridad").toString()),
						resultados.getString("prio.descripcion"));
				resultado=Optional.of(prioridadEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000311);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000312);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000311);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000313);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}

	@Override
	public final List<PrioridadEntity> consultar(final PrioridadEntity prioridad) {
		final var parametros = new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(prioridad, parametros);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			colocarParametrosConsulta(sentenciaPreparada, parametros);
			return ejecutarConsulta(sentenciaPreparada);
		} catch (DataCoTaskerException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000314);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000315);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}  catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000314);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000316);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	private String formarSentenciaConsulta(PrioridadEntity prioridad, ArrayList<Object> parametros) {
		final var sentencia = new StringBuilder();
		String operadorCondicional = "WHERE";
		
		sentencia.append("SELECT prio.idPrioridad,prio.descripcion ");
		sentencia.append("FROM Prioridad prio");
		sentencia.append("WHERE idPrioridad=?");
		
		if(!UtilObjeto.esNulo(prioridad)) {
			if(!UtilObjeto.esNulo(prioridad.getIdPrioridad())) {
				sentencia.append(operadorCondicional).append("prio.idPrioridad = ?");
				operadorCondicional="AND";
				parametros.add(prioridad.getIdPrioridad());
			}
			
			if(!UtilTexto.estaVacio(prioridad.getDescripcion())) {
			sentencia.append(operadorCondicional).append("prio.descripcion=?");
			parametros.add(prioridad.getDescripcion());
			
			}
		}
				
		return sentencia.toString();
	}

	private List<PrioridadEntity> ejecutarConsulta(PreparedStatement sentenciaPreparada) {
final var listaResultados = new ArrayList<PrioridadEntity>();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			
			while (resultados.next()) {
				var  prioridadEntity=PrioridadEntity.crear(
						UUID.fromString(resultados.getObject("prio.idPrioridad").toString()),
						resultados.getString("prio.descripcion"));
						
				listaResultados.add(prioridadEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000317);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000321);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000317);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000322);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);		
		}
		
		return listaResultados;
	}

	private void colocarParametrosConsulta(PreparedStatement sentenciaPreparada, ArrayList<Object> parametros) {
		try {
			for (int indice = 0; indice < parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000317);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000318);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000317);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000319);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
		
}
	


