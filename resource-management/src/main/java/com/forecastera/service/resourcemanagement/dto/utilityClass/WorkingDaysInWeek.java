package com.forecastera.service.resourcemanagement.dto.utilityClass;
/*
 * @Author Kanishk Vats
 * @Create 26-09-2023
 * @Description
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkingDaysInWeek {

    @JsonProperty("week")
    private Date week;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("workingDays")
    private Integer workingDays;
}
