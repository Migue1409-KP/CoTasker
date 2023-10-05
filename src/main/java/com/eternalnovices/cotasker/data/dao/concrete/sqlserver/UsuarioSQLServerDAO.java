package com.eternalnovices.cotasker.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.dao.UsuarioDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.UsuarioEntity;

public class UsuarioSQLServerDAO extends SQLDAO implements UsuarioDAO {

	protected UsuarioSQLServerDAO(final Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void crear(final UsuarioEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void modificar(final UsuarioEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<UsuarioEntity> buscarPorId(final UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<UsuarioEntity> consultar(final UsuarioEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
