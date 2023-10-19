package com.eternalnovices.cotasker.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.entity.UsuarioEntity;
import com.eternalnovices.cotasker.data.entity.UsuarioProyectoEntity;

public interface UsuarioProyectoDAO {
	void crear(UsuarioProyectoEntity entity);
	void modificar(UsuarioProyectoEntity entity);
	void eliminar(UUID id);
	
	
	Optional<UsuarioEntity>consultarPorId(UUID id);
	List<UsuarioEntity>consultar(UsuarioProyectoEntity entity);
	
	
}
