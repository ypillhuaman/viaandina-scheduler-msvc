package com.viaandina.msvc.scheduler.app.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.viaandina.msvc.scheduler.app.dtos.ScheduleDTO;
import com.viaandina.msvc.scheduler.app.entities.Schedule;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    ScheduleDTO toDto(Schedule schedule);
    Schedule toEntity(ScheduleDTO scheduleDTO);
}
