package com.eternalnovices.cotasker.service.bussineslogic;

import java.util.UUID;

public interface UseCaseId <D> {
	UUID execute(D domain);
}
