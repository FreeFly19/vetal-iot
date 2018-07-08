package com.fjhjkj.vetaliot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    List<SensorData> findAllBySensorIdOrderByCreateAt(long sensorId);
}
