package com.eternalnovices.cotasker.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.dao.ProyectoDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.ProyectoEntity;

public class ProyectoSQLServerDAO extends SQLDAO implements ProyectoDAO{

	protected ProyectoSQLServerDAO(final Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void crear(final ProyectoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void modificar(final ProyectoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<ProyectoEntity> consultarPorId(final UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<ProyectoEntity> consultar(final ProyectoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
