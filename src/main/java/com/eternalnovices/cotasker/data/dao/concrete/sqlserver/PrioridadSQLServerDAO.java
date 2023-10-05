package com.eternalnovices.cotasker.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.dao.PrioridadDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.PrioridadEntity;

public class PrioridadSQLServerDAO extends SQLDAO implements PrioridadDAO {

	protected PrioridadSQLServerDAO(final Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void modificar(final PrioridadEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<PrioridadEntity> consultarPorId(final UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<PrioridadEntity> consultar(final PrioridadEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
