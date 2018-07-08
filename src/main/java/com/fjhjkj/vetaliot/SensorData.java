package com.fjhjkj.vetaliot;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @JsonIgnore
    @ManyToOne
    public Sensor sensor;

    @JsonView(ChartDate.class)
    public int value;

    @JsonView(ChartDate.class)
    public Timestamp createAt;


    interface ChartDate {}
}
