package com.viaandina.msvc.scheduler.app.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class StopDTO {
    private Long id;
    private Long routeId;
    private String name;
    private Integer stopOrder;
    private Double latitude;
    private Double longitude;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}