package com.forecastera.service.financialmanagement.entity.directemployeedetails;

/*
 * @Author Uttam Kachhad
 * @Create 26-06-2023
 * @Description
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "finance_mgmt_field_value_budget_direct_emp")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FinanceDirectEmployeeBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finance_mgmt_field_value_id")
    private Integer id;

    @Column(name = "direct_employee_det_budget_id")
    private Integer directEmployeeBudgetId;

    @Column(name = "field_id")
    private Integer fieldId;

    @Column(name = "field_value")
    private String fieldValue;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

}
