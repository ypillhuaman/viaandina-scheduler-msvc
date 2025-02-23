package com.viaandina.msvc.scheduler.app.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.viaandina.msvc.scheduler.app.dtos.StopDTO;
import com.viaandina.msvc.scheduler.app.entities.Stop;

@Mapper(componentModel = "spring")
public interface StopMapper {
    StopMapper INSTANCE = Mappers.getMapper(StopMapper.class);

    StopDTO toDto(Stop stop);
    Stop toEntity(StopDTO stopDTO);
}
