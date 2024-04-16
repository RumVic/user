package com.user.service;

import java.util.List;
import java.util.UUID;

public interface Service<entity, idto, odto>{

    entity create (idto dto);
    List<entity> read ();
    entity update(UUID id, idto idto);
    void delete(UUID uuid);
    odto readById(UUID id);
}
