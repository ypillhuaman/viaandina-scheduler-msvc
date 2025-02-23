package com.viaandina.msvc.scheduler.app.dtos;

import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

@Data
public class ScheduleDTO {
    private Long id;
    private Long routeId;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private String daysOfWeek;
    private Boolean active;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}