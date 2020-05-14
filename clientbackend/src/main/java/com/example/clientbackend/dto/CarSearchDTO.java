package com.example.clientbackend.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarSearchDTO {
    private String startCity;
    private String endCity;
    private Timestamp startDate;
    private Timestamp endDate;
}
