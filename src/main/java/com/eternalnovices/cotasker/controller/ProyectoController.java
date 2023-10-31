package com.eternalnovices.cotasker.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eternalnovices.cotasker.service.dto.ProyectoDTO;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController {
	private static final Logger logger = LogManager.getLogger(UsuarioController.class);
	
	@GetMapping("/dummy")
	public ProyectoDTO obtenerDummy() {
		return ProyectoDTO.crear();
	}
}
