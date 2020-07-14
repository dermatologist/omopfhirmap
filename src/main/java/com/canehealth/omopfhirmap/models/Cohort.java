package com.canehealth.omopfhirmap.models;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;

@Data
@Entity
public class Cohort {

  @Id
  @GeneratedValue
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"cohort_definition_id\"", nullable = false)
  private Integer cohortDefinitionId;
  @Column(name = "\"subject_id\"", nullable = false)
  private Integer subjectId;
  @Column(name = "\"cohort_start_date\"", nullable = false)
  private String cohortStartDate;
  @Column(name = "\"cohort_end_date\"", nullable = false)
  private String cohortEndDate;
}