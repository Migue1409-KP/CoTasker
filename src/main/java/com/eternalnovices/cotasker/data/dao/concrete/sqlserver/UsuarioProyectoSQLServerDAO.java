package com.eternalnovices.cotasker.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.dao.UsuarioProyectoDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.UsuarioEntity;
import com.eternalnovices.cotasker.data.entity.UsuarioProyectoEntity;

public class UsuarioProyectoSQLServerDAO extends SQLDAO implements UsuarioProyectoDAO{

	protected UsuarioProyectoSQLServerDAO(final Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(UsuarioProyectoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(UsuarioProyectoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<UsuarioEntity> consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<UsuarioEntity> consultar(UsuarioProyectoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
