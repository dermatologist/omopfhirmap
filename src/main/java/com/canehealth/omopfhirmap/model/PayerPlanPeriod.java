package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.PayerPlanPeriod")
@Table(name = "payer_plan_period")
public class PayerPlanPeriod {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"payer_plan_period_id\"", nullable = false)
  private Integer payerPlanPeriodId;
  @Column(name = "\"person_id\"", nullable = false)
  private Integer personId;
  @Column(name = "\"payer_plan_period_start_date\"", nullable = false)
  private String payerPlanPeriodStartDate;
  @Column(name = "\"payer_plan_period_end_date\"", nullable = false)
  private String payerPlanPeriodEndDate;
  @Column(name = "\"payer_source_value\"", nullable = true)
  private String payerSourceValue;
  @Column(name = "\"plan_source_value\"", nullable = true)
  private String planSourceValue;
  @Column(name = "\"family_source_value\"", nullable = true)
  private String familySourceValue;
}