package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.Cohort")
@Table(name = "cohort")
public class Cohort {

  @Id
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