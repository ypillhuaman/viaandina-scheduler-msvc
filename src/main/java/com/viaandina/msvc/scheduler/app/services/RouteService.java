package com.viaandina.msvc.scheduler.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaandina.msvc.scheduler.app.dtos.RouteDTO;
import com.viaandina.msvc.scheduler.app.entities.Route;
import com.viaandina.msvc.scheduler.app.mappers.RouteMapper;
import com.viaandina.msvc.scheduler.app.repositories.RouteRepository;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteMapper routeMapper;

    public List<RouteDTO> findAll() {
        return routeRepository.findAll().stream()
                .map(routeMapper::toDto)
                .collect(Collectors.toList());
    }

    public RouteDTO findById(Long id) {
        return routeRepository.findById(id)
                .map(routeMapper::toDto)
                .orElse(null);
    }

    public RouteDTO save(RouteDTO routeDTO) {
        Route route = routeMapper.toEntity(routeDTO);
        route = routeRepository.save(route);
        return routeMapper.toDto(route);
    }

    public void deleteById(Long id) {
        routeRepository.deleteById(id);
    }
}
