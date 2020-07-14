package com.canehealth.omopfhirmap.models;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(CohortIdentity.class)
public class Cohort {

  @Id
  @Column(name = "cohort_definition_id", nullable = false)
  private Integer cohortDefinitionId;

  @Id
  @Column(name = "subject_id", nullable = false)
  private Integer subjectId;
  @Column(name = "cohort_start_date", nullable = false)
  private String cohortStartDate;
  @Column(name = "cohort_end_date", nullable = false)
  private String cohortEndDate;
}