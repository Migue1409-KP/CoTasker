package com.eternalnovices.cotasker.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.dao.ListaTareaDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.ListaTareasEntity;

public class ListaTareaSQLServerDAO extends SQLDAO implements ListaTareaDAO{

	protected ListaTareaSQLServerDAO(final Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void crear(final ListaTareasEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void modificar(final ListaTareasEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<ListaTareasEntity> consultarPorId(final UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<ListaTareasEntity> consultar(final ListaTareasEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
