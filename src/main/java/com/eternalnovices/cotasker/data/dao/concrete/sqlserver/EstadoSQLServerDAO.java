package com.eternalnovices.cotasker.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.dao.EstadoDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.EstadoEntity;

public class EstadoSQLServerDAO extends SQLDAO implements EstadoDAO{

	protected EstadoSQLServerDAO(final Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void modificar(final EstadoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final  Optional<EstadoEntity> consultarPorId(final UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<EstadoEntity> consultar(final EstadoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
