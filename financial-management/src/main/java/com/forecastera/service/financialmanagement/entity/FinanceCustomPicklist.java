package com.forecastera.service.financialmanagement.entity;
/*
 * @Author Kanishk Vats
 * @Create 21-06-2023
 * @Description
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "finance_custom_pick_list")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinanceCustomPicklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "picklist_id")
    private Integer picklistId;

    @Column(name = "picklist_value")
    private String picklistValue;

    @Column(name = "color")
    private String color;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    @Column(name = "modified_date")
    private Date modifiedDate;
}
