package com.eternalnovices.cotasker.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.eternalnovices.cotasker.service.facade.concrete.proyecto.RegistrarProyectoFacade;
import com.eternalnovices.cotasker.service.facade.concrete.usuario.ConsultarUsuarioFacade;
import com.eternalnovices.cotasker.service.facade.concrete.usuarioproyecto.RegistrarUsuarioProyectoFacade;

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
			ConsultarUsuarioFacade facadeUsuario = new ConsultarUsuarioFacade();
			RegistrarUsuarioProyectoFacade facadeUsuarioProyecto = new RegistrarUsuarioProyectoFacade();
			
			var dtoUsuario = UsuarioDTO.crear().setIdUsuario(req.getIdProyecto());
			var dtoProyecto = ProyectoDTO.crear()
						.setIdProyecto(req.getIdProyecto())
						.setNombre(req.getNombre())
						.setDescripcion(req.getDescripcion())
						.setFecha(FechasDTO.crear()
								.setFechaCreacion(UtilFecha.obtenerFechaActual())
								.setFechaEstimadaInicio(req.getFecha().getFechaEstimadaInicio())
								.setFechaEstimadaFin(req.getFecha().getFechaEstimadaFin()));
			var usuario = facadeUsuario.execute(dtoUsuario);
			
			UUID idProyecto = req.getIdProyecto();
			
			if(!usuario.isEmpty()) {
				idProyecto = facadeProyecto.execute(dtoProyecto);
				var dtoUsuarioProyecto = UsuarioProyectoDTO.crear()
						.setProyecto(ProyectoDTO.crear().setIdProyecto(idProyecto))
						.setUsuario(UsuarioDTO.crear().setIdUsuario(req.getIdUsuario()));
				facadeUsuarioProyecto.execute(dtoUsuarioProyecto);
			}
			
			var res = new ArrayList<SolicitarProyecto>();
			res.add(ProyectoResponseMapper.convertToResponse(dtoProyecto.setIdProyecto(idProyecto), req.getIdUsuario()));
			respuesta.setDatos(res);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000707));
		} catch (CoTaskerException e) {
			respuesta.getMensajes().add(e.getMensajeTecnico());
			logger.error(e.getLugar(), e);
		} catch (Exception e) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000708));
			logger.error(e);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
}
