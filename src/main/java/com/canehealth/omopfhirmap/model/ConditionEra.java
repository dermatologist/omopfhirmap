package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.ConditionEra")
@Table(name = "condition_era")
public class ConditionEra {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"condition_era_id\"", nullable = false)
  private Integer conditionEraId;
  @Column(name = "\"person_id\"", nullable = false)
  private Integer personId;
  @Column(name = "\"condition_concept_id\"", nullable = false)
  private Integer conditionConceptId;
  @Column(name = "\"condition_era_start_date\"", nullable = false)
  private String conditionEraStartDate;
  @Column(name = "\"condition_era_end_date\"", nullable = false)
  private String conditionEraEndDate;
  @Column(name = "\"condition_occurrence_count\"", nullable = true)
  private Integer conditionOccurrenceCount;
}