package com.viaandina.msvc.scheduler.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaandina.msvc.scheduler.app.dtos.ScheduleDTO;
import com.viaandina.msvc.scheduler.app.services.ScheduleService;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private Environment env;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public List<ScheduleDTO> findAll() {
        String port = env.getProperty("local.server.port");
        System.out.println("El servicio está disponible en el puerto: " + port);
        return scheduleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDTO> findById(@PathVariable Long id) {
        ScheduleDTO scheduleDTO = scheduleService.findById(id);
        return scheduleDTO != null ? ResponseEntity.ok(scheduleDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ScheduleDTO save(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.save(scheduleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        scheduleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}