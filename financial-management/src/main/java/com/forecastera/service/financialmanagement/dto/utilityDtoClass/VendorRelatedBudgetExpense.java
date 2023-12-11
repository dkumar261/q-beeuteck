package com.forecastera.service.financialmanagement.dto.utilityDtoClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * @Author Uttam Kachhad
 * @Create 04-07-2023
 * @Description
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VendorRelatedBudgetExpense {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("vendorRelatedCostBudgetId")
    private Integer vendorRelatedCostBudgetId;

    @JsonProperty("financialYear")
    private Integer financialYear;

    @JsonProperty("data")
    private List<FinancialMonthlyExpenseData> financialMonthlyExpenseDataList;
}
