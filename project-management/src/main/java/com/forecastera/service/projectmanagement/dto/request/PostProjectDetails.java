package com.forecastera.service.projectmanagement.dto.request;
/*
 * @Author Kanishk Vats
 * @Create 08-06-2023
 * @Description
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostProjectDetails {

    @JsonProperty("fieldId")
    private Integer fieldId;

    @JsonProperty("fieldName")
    private String fieldName;

    @JsonProperty("fieldValue")
    private Object fieldValue;

    @JsonProperty("picklistId")
    private String picklistId;

    @JsonProperty("fieldType")
    private String fieldType;
}
