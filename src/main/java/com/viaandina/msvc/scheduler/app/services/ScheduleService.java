package com.viaandina.msvc.scheduler.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaandina.msvc.scheduler.app.dtos.ScheduleDTO;
import com.viaandina.msvc.scheduler.app.entities.Schedule;
import com.viaandina.msvc.scheduler.app.mappers.ScheduleMapper;
import com.viaandina.msvc.scheduler.app.repositories.ScheduleRepository;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ScheduleMapper scheduleMapper;

    public List<ScheduleDTO> findAll() {
        return scheduleRepository.findAll().stream()
                .map(scheduleMapper::toDto)
                .collect(Collectors.toList());
    }

    public ScheduleDTO findById(Long id) {
        return scheduleRepository.findById(id)
                .map(scheduleMapper::toDto)
                .orElse(null);
    }

    public ScheduleDTO save(ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleMapper.toEntity(scheduleDTO);
        schedule = scheduleRepository.save(schedule);
        return scheduleMapper.toDto(schedule);
    }

    public void deleteById(Long id) {
        scheduleRepository.deleteById(id);
    }
}
