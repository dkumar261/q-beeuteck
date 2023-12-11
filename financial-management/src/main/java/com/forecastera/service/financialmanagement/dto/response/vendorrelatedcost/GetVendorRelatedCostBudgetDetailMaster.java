package com.forecastera.service.financialmanagement.dto.response.vendorrelatedcost;

/*
 * @Author Uttam Kachhad
 * @Create 05-07-2023
 * @Description
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.forecastera.service.financialmanagement.dto.utilityDtoClass.VendorRelatedBudgetExpense;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetVendorRelatedCostBudgetDetailMaster {

    @JsonProperty("vendor_related_cost_budget_id")
    private Integer vendorRelatedCostBudgetId;

    @JsonProperty("financial_year")
    private Integer financial_year;

    @JsonProperty("row_order")
    private Integer row_order;

    @JsonProperty("is_active")
    private Boolean is_active;

    @JsonProperty("data")
    private List<Map<String, Object>> fields;

    @JsonProperty("expenseData")
    private List<VendorRelatedBudgetExpense> vendorRelatedBudgetExpense;

}
