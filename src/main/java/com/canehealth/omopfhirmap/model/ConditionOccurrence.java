package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.ConditionOccurrence")
@Table(name = "condition_occurrence")
public class ConditionOccurrence {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"condition_occurrence_id\"", nullable = false)
  private Integer conditionOccurrenceId;
  @Column(name = "\"person_id\"", nullable = false)
  private Integer personId;
  @Column(name = "\"condition_concept_id\"", nullable = false)
  private Integer conditionConceptId;
  @Column(name = "\"condition_start_date\"", nullable = false)
  private String conditionStartDate;
  @Column(name = "\"condition_end_date\"", nullable = true)
  private String conditionEndDate;
  @Column(name = "\"condition_type_concept_id\"", nullable = false)
  private Integer conditionTypeConceptId;
  @Column(name = "\"stop_reason\"", nullable = true)
  private String stopReason;
  @Column(name = "\"provider_id\"", nullable = true)
  private Integer providerId;
  @Column(name = "\"visit_occurrence_id\"", nullable = true)
  private Integer visitOccurrenceId;
  @Column(name = "\"condition_source_value\"", nullable = true)
  private String conditionSourceValue;
  @Column(name = "\"condition_source_concept_id\"", nullable = true)
  private Integer conditionSourceConceptId;
}