package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.Concept")
@Table(name = "concept")
public class Concept {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"concept_id\"", nullable = false)
  private Integer conceptId;
  @Column(name = "\"concept_name\"", nullable = false)
  private String conceptName;
  @Column(name = "\"domain_id\"", nullable = false)
  private String domainId;
  @Column(name = "\"vocabulary_id\"", nullable = false)
  private String vocabularyId;
  @Column(name = "\"concept_class_id\"", nullable = false)
  private String conceptClassId;
  @Column(name = "\"standard_concept\"", nullable = true)
  private String standardConcept;
  @Column(name = "\"concept_code\"", nullable = false)
  private String conceptCode;
  @Column(name = "\"valid_start_date\"", nullable = false)
  private String validStartDate;
  @Column(name = "\"valid_end_date\"", nullable = false)
  private String validEndDate;
  @Column(name = "\"invalid_reason\"", nullable = true)
  private String invalidReason;
}