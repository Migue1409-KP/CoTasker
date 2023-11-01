package com.eternalnovices.cotasker.service.facade;

import java.util.UUID;

public interface FacadeId<T> {
	
	UUID execute(T dto);
}
