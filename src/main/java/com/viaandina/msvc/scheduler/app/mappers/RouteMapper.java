package com.viaandina.msvc.scheduler.app.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.viaandina.msvc.scheduler.app.dtos.RouteDTO;
import com.viaandina.msvc.scheduler.app.entities.Route;

@Mapper(componentModel = "spring")
public interface RouteMapper {
    RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);

    RouteDTO toDto(Route route);
    Route toEntity(RouteDTO routeDTO);
}
