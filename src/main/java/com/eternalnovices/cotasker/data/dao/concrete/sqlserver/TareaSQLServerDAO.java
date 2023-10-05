package com.eternalnovices.cotasker.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.eternalnovices.cotasker.data.dao.TareaDAO;
import com.eternalnovices.cotasker.data.dao.base.SQLDAO;
import com.eternalnovices.cotasker.data.entity.TareaEntity;

public class TareaSQLServerDAO extends SQLDAO implements TareaDAO{

	protected TareaSQLServerDAO( Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void crear(final TareaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void modificar(final TareaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final  void eliminar(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<TareaEntity> consultarPorId(final UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<TareaEntity> consultar(final TareaEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
