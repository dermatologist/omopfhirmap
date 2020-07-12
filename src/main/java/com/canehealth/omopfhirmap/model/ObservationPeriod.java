package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.ObservationPeriod")
@Table(name = "observation_period")
public class ObservationPeriod {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"observation_period_id\"", nullable = false)
  private Integer observationPeriodId;
  @Column(name = "\"person_id\"", nullable = false)
  private Integer personId;
  @Column(name = "\"observation_period_start_date\"", nullable = false)
  private String observationPeriodStartDate;
  @Column(name = "\"observation_period_end_date\"", nullable = false)
  private String observationPeriodEndDate;
  @Column(name = "\"period_type_concept_id\"", nullable = false)
  private Integer periodTypeConceptId;
}