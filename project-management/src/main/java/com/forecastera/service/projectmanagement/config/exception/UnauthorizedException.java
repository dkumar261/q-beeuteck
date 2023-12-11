package com.forecastera.service.projectmanagement.config.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Uttam Kachhad
 * @Create 22-05-2023
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnauthorizedException extends RuntimeException {

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("message")
    private String message;

}
