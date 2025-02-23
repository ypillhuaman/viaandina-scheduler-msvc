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

import com.viaandina.msvc.scheduler.app.dtos.StopDTO;
import com.viaandina.msvc.scheduler.app.services.StopService;

@RestController
@RequestMapping("/stops")
public class StopController {

    @Autowired
    private StopService stopService;

    @GetMapping
    public List<StopDTO> findAll() {
        return stopService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StopDTO> findById(@PathVariable Long id) {
        StopDTO stopDTO = stopService.findById(id);
        return stopDTO != null ? ResponseEntity.ok(stopDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public StopDTO save(@RequestBody StopDTO stopDTO) {
        return stopService.save(stopDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        stopService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}