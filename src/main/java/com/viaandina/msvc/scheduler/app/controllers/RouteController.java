package com.viaandina.msvc.scheduler.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaandina.msvc.scheduler.app.dtos.RouteDTO;
import com.viaandina.msvc.scheduler.app.services.RouteService;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public List<RouteDTO> findAll() {
        return routeService.findAll();
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("test qwerty");
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteDTO> findById(@PathVariable Long id) {
        RouteDTO routeDTO = routeService.findById(id);
        return routeDTO != null ? ResponseEntity.ok(routeDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public RouteDTO save(@RequestBody RouteDTO routeDTO) {
        return routeService.save(routeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        routeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
