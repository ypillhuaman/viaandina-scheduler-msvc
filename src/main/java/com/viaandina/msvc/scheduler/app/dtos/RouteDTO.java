package com.viaandina.msvc.scheduler.app.dtos;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class RouteDTO {
private Long id;
    private String name;
    private String origin;
    private String destination;
    private Double distanceKm;
    private Integer estimatedDurationMin;
    private Boolean active;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private List<StopDTO> stops;
    private List<ScheduleDTO> schedules;
}
