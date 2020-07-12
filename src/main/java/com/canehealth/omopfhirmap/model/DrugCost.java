package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.DrugCost")
@Table(name = "drug_cost")
public class DrugCost {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"drug_cost_id\"", nullable = false)
  private Integer drugCostId;
  @Column(name = "\"drug_exposure_id\"", nullable = false)
  private Integer drugExposureId;
  @Column(name = "\"currency_concept_id\"", nullable = true)
  private Integer currencyConceptId;
  @Column(name = "\"paid_copay\"", nullable = true)
  private Float paidCopay;
  @Column(name = "\"paid_coinsurance\"", nullable = true)
  private Float paidCoinsurance;
  @Column(name = "\"paid_toward_deductible\"", nullable = true)
  private Float paidTowardDeductible;
  @Column(name = "\"paid_by_payer\"", nullable = true)
  private Float paidByPayer;
  @Column(name = "\"paid_by_coordination_benefits\"", nullable = true)
  private Float paidByCoordinationBenefits;
  @Column(name = "\"total_out_of_pocket\"", nullable = true)
  private Float totalOutOfPocket;
  @Column(name = "\"total_paid\"", nullable = true)
  private Float totalPaid;
  @Column(name = "\"ingredient_cost\"", nullable = true)
  private Float ingredientCost;
  @Column(name = "\"dispensing_fee\"", nullable = true)
  private Float dispensingFee;
  @Column(name = "\"average_wholesale_price\"", nullable = true)
  private Float averageWholesalePrice;
  @Column(name = "\"payer_plan_period_id\"", nullable = true)
  private Integer payerPlanPeriodId;
}