package com.viaandina.msvc.scheduler.app.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaandina.msvc.scheduler.app.dtos.StopDTO;
import com.viaandina.msvc.scheduler.app.entities.Stop;
import com.viaandina.msvc.scheduler.app.mappers.StopMapper;
import com.viaandina.msvc.scheduler.app.repositories.StopRepository;

@Service
public class StopService {

    @Autowired
    private StopRepository stopRepository;

    @Autowired
    private StopMapper stopMapper;

    public List<StopDTO> findAll() {
        return stopRepository.findAll().stream()
                .map(stopMapper::toDto)
                .collect(Collectors.toList());
    }

    public StopDTO findById(Long id) {
        return stopRepository.findById(id)
                .map(stopMapper::toDto)
                .orElse(null);
    }

    public StopDTO save(StopDTO stopDTO) {
        Stop stop = stopMapper.toEntity(stopDTO);
        stop.setCreatedAt(LocalDateTime.now());
        stop = stopRepository.save(stop);
        return stopMapper.toDto(stop);
    }

    public void deleteById(Long id) {
        stopRepository.deleteById(id);
    }
}