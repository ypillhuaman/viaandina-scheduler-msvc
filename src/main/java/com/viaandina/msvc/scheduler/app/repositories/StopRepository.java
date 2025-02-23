package com.viaandina.msvc.scheduler.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viaandina.msvc.scheduler.app.entities.Stop;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {

}
