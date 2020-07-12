package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.CohortAttribute")
@Table(name = "cohort_attribute")
public class CohortAttribute {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"cohort_definition_id\"", nullable = false)
  private Integer cohortDefinitionId;
  @Column(name = "\"cohort_start_date\"", nullable = false)
  private String cohortStartDate;
  @Column(name = "\"cohort_end_date\"", nullable = false)
  private String cohortEndDate;
  @Column(name = "\"subject_id\"", nullable = false)
  private Integer subjectId;
  @Column(name = "\"attribute_definition_id\"", nullable = false)
  private Integer attributeDefinitionId;
  @Column(name = "\"value_as_number\"", nullable = true)
  private Float valueAsNumber;
  @Column(name = "\"value_as_concept_id\"", nullable = true)
  private Integer valueAsConceptId;
}