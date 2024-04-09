package com.user.service.api;

import java.util.List;
import java.util.UUID;

public interface Service<ENTITY, IDTO>{

    ENTITY create (IDTO dto);
    List<ENTITY> read ();
    ENTITY update(UUID id, IDTO idto);
    ENTITY updateWithEntity(UUID id, ENTITY ENTITY);
    void delete(UUID uuid);
    ENTITY readById(UUID id);
}
