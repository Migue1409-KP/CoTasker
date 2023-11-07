package com.eternalnovices.cotasker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eternalnovices.cotasker.controller.support.mapper.ProyectoResponseMapper;
import com.eternalnovices.cotasker.controller.support.request.SolicitarProyecto;
import com.eternalnovices.cotasker.controller.support.response.Respuesta;
import com.eternalnovices.cotasker.crosscutting.exception.CoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.CatalogoMensajes;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilFecha;
import com.eternalnovices.cotasker.service.dto.FechasDTO;
import com.eternalnovices.cotasker.service.dto.ProyectoDTO;
import com.eternalnovices.cotasker.service.dto.UsuarioDTO;
import com.eternalnovices.cotasker.service.dto.UsuarioProyectoDTO;
import com.eternalnovices.cotasker.service.facade.concrete.proyecto.EliminarProyectoFacade;
import com.eternalnovices.cotasker.service.facade.concrete.proyecto.RegistrarProyectoFacade;
import com.eternalnovices.cotasker.service.facade.concrete.usuarioproyecto.ConsultarUsuarioProyectoFacade;
import com.eternalnovices.cotasker.service.facade.concrete.usuarioproyecto.EliminarUsuarioProyectoFacade;
import com.eternalnovices.cotasker.service.facade.concrete.usuarioproyecto.RegistrarUsuarioProyectoFacade;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController {
	private static final Logger logger = LogManager.getLogger(ProyectoController.class);
	
	@GetMapping("/dummy")
	public SolicitarProyecto obtenerDummy() {
		return new SolicitarProyecto();
	}
	
	@PostMapping 
	public ResponseEntity<Respuesta<SolicitarProyecto>> registrar(@RequestBody SolicitarProyecto req){
		final Respuesta<SolicitarProyecto> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			RegistrarProyectoFacade facadeProyecto = new RegistrarProyectoFacade();
			RegistrarUsuarioProyectoFacade facadeUsuarioProyecto = new RegistrarUsuarioProyectoFacade();
			
			var dtoProyecto = ProyectoDTO.crear()
						.setIdProyecto(req.getIdProyecto())
						.setNombre(req.getNombre())
						.setDescripcion(req.getDescripcion())
						.setFecha(FechasDTO.crear()
								.setFechaCreacion(UtilFecha.obtenerFechaActual())
								.setFechaEstimadaInicio(req.getFecha().getFechaEstimadaInicio())
								.setFechaEstimadaFin(req.getFecha().getFechaEstimadaFin()));
			
			var idProyecto = facadeProyecto.execute(dtoProyecto, req.getIdUsuario());
			
			var dtoUsuarioProyecto = UsuarioProyectoDTO.crear()
					.setProyecto(ProyectoDTO.crear().setIdProyecto(idProyecto))
					.setUsuario(UsuarioDTO.crear().setIdUsuario(req.getIdUsuario()));
			
			facadeUsuarioProyecto.execute(dtoUsuarioProyecto);
			
			var res = new ArrayList<SolicitarProyecto>();
			res.add(ProyectoResponseMapper.convertToResponse(dtoProyecto.setIdProyecto(idProyecto), req.getIdUsuario()));
			respuesta.setDatos(res);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000347));
		} catch (CoTaskerException e) {
			respuesta.getMensajes().add(e.getMensajeTecnico());
			logger.error(e.getMensajeTecnico(), e.getExcepcionRaiz());
		} catch (Exception e) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000348));
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000348), e);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	
	@GetMapping("/proyectosUsuario/{id}")
	public ResponseEntity<Respuesta<SolicitarProyecto>> consultarProyectosUsuario(@PathVariable("id") UUID id){
		final Respuesta<SolicitarProyecto> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			var dto = UsuarioProyectoDTO.crear().setUsuario(UsuarioDTO.crear().setIdUsuario(id));
			ConsultarUsuarioProyectoFacade facade = new ConsultarUsuarioProyectoFacade();
			var responseTmp = facade.execute(dto);
			List<SolicitarProyecto> response = new ArrayList<>();
			
			for (int i = 0; i < responseTmp.size(); i++) {
				response.add(ProyectoResponseMapper.convertToResponse(responseTmp.get(i).getProyecto()));
			}
			
			respuesta.setDatos(response);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000357));
		} catch (CoTaskerException e) {
			respuesta.getMensajes().add(e.getMensajeTecnico());
			logger.error(e.getMensajeTecnico(), e.getExcepcionRaiz());
		} catch (Exception e) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000358));
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000358), e);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Respuesta<SolicitarProyecto>> eliminar(@PathVariable("id") UUID id){
		final Respuesta<SolicitarProyecto> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			EliminarUsuarioProyectoFacade facadeRelacion = new EliminarUsuarioProyectoFacade();
			var dtoRelacion = UsuarioProyectoDTO.crear().setProyecto(ProyectoDTO.crear().setIdProyecto(id));
			facadeRelacion.execute(dtoRelacion);
			
			EliminarProyectoFacade facadeProyecto = new EliminarProyectoFacade();
			var dtoProyecto = ProyectoDTO.crear().setIdProyecto(id);
			facadeProyecto.execute(dtoProyecto);
			
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000352));
		} catch (CoTaskerException e) {
			respuesta.getMensajes().add(e.getMensajeTecnico());
			logger.error(e.getMensajeTecnico(), e.getExcepcionRaiz());
		} catch (Exception e) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000353));
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000353), e);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
}
