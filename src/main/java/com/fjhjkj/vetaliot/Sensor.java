package com.fjhjkj.vetaliot;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    @OneToMany(mappedBy = "sensor")
    public List<SensorData> data;
}
