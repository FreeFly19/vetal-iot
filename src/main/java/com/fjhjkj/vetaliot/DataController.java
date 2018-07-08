package com.fjhjkj.vetaliot;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class DataController {
    final SensorRepository sensorRepository;
    final SensorDataRepository sensorDataRepository;

    public DataController(SensorRepository sensorRepository, SensorDataRepository sensorDataRepository) {
        this.sensorRepository = sensorRepository;
        this.sensorDataRepository = sensorDataRepository;

        Sensor sensor = new Sensor();
        sensor.name = "Бачкурино";
        sensorRepository.save(sensor);

        SensorData sensorData = new SensorData();
        sensorData.sensor = sensor;
        sensorData.value = 25;
        sensorData.createAt = new Timestamp(new Date().getTime());

        sensorDataRepository.save(sensorData);

        SensorData sensorData2 = new SensorData();
        sensorData2.sensor = sensor;
        sensorData2.value = 24;
        sensorData2.createAt = new Timestamp(new Date().getTime() + 1000 * 60 * 60);

        sensorDataRepository.save(sensorData2);

        SensorData sensorData3 = new SensorData();
        sensorData3.sensor = sensor;
        sensorData3.value = 22;
        sensorData3.createAt = new Timestamp(new Date().getTime() + 1000 * 60 * 60 * 2);

        sensorDataRepository.save(sensorData3);
    }

    @JsonView(SensorData.ChartDate.class)
    @GetMapping("/api/sensor-data")
    public List<SensorData> sensorData(@RequestParam long sensorId) {
        return sensorDataRepository.findAllBySensorIdOrderByCreateAt(sensorId);
    }

    @GetMapping("/api/sensors")
    public List<Sensor> getInts() {
        return sensorRepository.findAll();
    }

    @GetMapping("/api/sensors/new")
    public void addNewSensnor(@RequestParam("name") String name) {
        Sensor sensor = new Sensor();
        sensor.name = name;
        sensorRepository.save(sensor);
    }

    @GetMapping("/api/sensors-data-new")
    public void createNewData(@RequestParam("sensorId") long sensorId, @RequestParam("value") int value) {
        SensorData sensorData = new SensorData();
        sensorData.sensor = sensorRepository.getOne(sensorId);
        sensorData.value = value;
        sensorData.createAt = new Timestamp(new Date().getTime());

        sensorDataRepository.save(sensorData);
    }
}
