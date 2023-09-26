package com.gate_software.ams_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Entity
@Table(name = "schedules")
@Data
@NoArgsConstructor
public class Schedule {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "entry_day_id")
    private Day entryDay;

    @Column(name = "entry_time")
    private String entryTime;


    @ManyToOne
    @JoinColumn(name = "exit_day_id")
    private Day exitDay;

    @Column(name = "exit_time")
    private String exitTime;

    @ManyToOne
    @JoinColumn(name = "controlled_user_id")
    @JsonIgnore
    private ControlledUser controlledUser;
}
