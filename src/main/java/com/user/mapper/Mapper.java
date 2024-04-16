package com.user.mapper;

public interface Mapper<dto, entity> {
    dto entityToDTO (entity entity);
}
