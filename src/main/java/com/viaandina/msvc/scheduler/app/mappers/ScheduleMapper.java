package com.viaandina.msvc.scheduler.app.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.viaandina.msvc.scheduler.app.dtos.ScheduleDTO;
import com.viaandina.msvc.scheduler.app.entities.Route;
import com.viaandina.msvc.scheduler.app.entities.Schedule;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    @Mapping(source = "route.id", target = "routeId")
    ScheduleDTO toDto(Schedule schedule);
    
    @Mapping(source = "routeId", target = "route.id")
    Schedule toEntity(ScheduleDTO scheduleDTO);

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
