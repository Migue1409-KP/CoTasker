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
		sentencia.append("UPDATE Estado");
		sentencia.append("SET descripcion=?, ");
		sentencia.append("WHERE idEstado=? ");
		try (final var sentenciaPreparada=getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setString(1, estado.getDescripcion());
			sentenciaPreparada.setObject(2, estado.getIdEstado());
			
			sentenciaPreparada.executeUpdate();
		} catch (final SQLException e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000323);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000324);
			throw DataCoTaskerException.crear(e,mensajeUsuario,mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000323);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000325);
			throw DataCoTaskerException.crear(e,mensajeUsuario,mensajeTecnico);
		}
	}

	@Override
	public final Optional<EstadoEntity> consultarPorId(final UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT est.idEstado,est.descripcion ");
		sentencia.append("FROM Estado est");
		sentencia.append("WHERE est.idEstado=? ");
		
		Optional<EstadoEntity> resultado= Optional.empty();
		
		try(final var sentenciaPreparada=getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, id);
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
		}catch(DataCoTaskerException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000326);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000330);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000326);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000331);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}

	private Optional<EstadoEntity> ejecutarConsultaPorId(PreparedStatement sentenciaPreparada) {
		Optional<EstadoEntity>resultado=Optional.empty();
		try(final var resultados=sentenciaPreparada.executeQuery()){
			if(resultados.next()) {
				var estadoEntity=EstadoEntity.crear(
						UUID.fromString(resultados.getObject("est.idEstado").toString()),
						resultados.getString("est.descripcion"));
				resultado=Optional.of(estadoEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000326);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000327);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}catch (Exception e) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000326);
			var mensajeTecnico=CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000328);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}
	
	@Override
	public final List<EstadoEntity> consultar(final EstadoEntity estado) {
		final var parametros = new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(estado, parametros);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			colocarParametrosConsulta(sentenciaPreparada, parametros);
			return ejecutarConsulta(sentenciaPreparada);
		} catch (DataCoTaskerException e) {
			throw e;
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000332);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000333);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}  catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000332);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000334);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}

	private List<EstadoEntity> ejecutarConsulta(PreparedStatement sentenciaPreparada) {
		final var listaResultados = new ArrayList<EstadoEntity>();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			
			while (resultados.next()) {
				var estadoEntity=EstadoEntity.crear(
						UUID.fromString(resultados.getObject("est.idEstado").toString()),
						resultados.getString("est.descripcion"));
						
				listaResultados.add(estadoEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000335);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000336);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000335);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000337);
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
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000335);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000338);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000317);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000339);
			throw DataCoTaskerException.crear(e, mensajeUsuario, mensajeTecnico);
		}
	}
			
	private String formarSentenciaConsulta(EstadoEntity estado, ArrayList<Object> parametros) {
		final var sentencia = new StringBuilder();
		String operadorCondicional = "WHERE";
		
		sentencia.append("SELECT est.idEstado,est.descripcion ");
		sentencia.append("FROM Estado est");
		
		if(!UtilObjeto.esNulo(estado)) {
			if(!UtilObjeto.esNulo(estado.getIdEstado())) {
				sentencia.append(operadorCondicional).append( "est.idEstado = ? ");
				operadorCondicional="AND";
				parametros.add(estado.getIdEstado());
			}
			
			if(!UtilTexto.estaVacio(estado.getDescripcion())) {
			sentencia.append(operadorCondicional).append(" est.descripcion=? ");
			parametros.add(estado.getDescripcion());
			
			}
		}
				
		return sentencia.toString();
	}
}
