package com.viaandina.msvc.scheduler.app.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.viaandina.msvc.scheduler.app.dtos.StopDTO;
import com.viaandina.msvc.scheduler.app.entities.Route;
import com.viaandina.msvc.scheduler.app.entities.Stop;

@Mapper(componentModel = "spring")
public interface StopMapper {
    StopMapper INSTANCE = Mappers.getMapper(StopMapper.class);

    @Mapping(source = "route.id", target = "routeId")
    StopDTO toDto(Stop stop);

    @Mapping(source = "routeId", target = "route.id")
    Stop toEntity(StopDTO stopDTO);

    /** Este método se usa para evitar errores al mapear routeId a Route **/
    default Route map(Long routeId) {
        if (routeId == null) {
            return null;
        }
        Route route = new Route();
        route.setId(routeId);
        return route;
    }
}
