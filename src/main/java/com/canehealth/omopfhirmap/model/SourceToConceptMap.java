package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.SourceToConceptMap")
@Table(name = "source_to_concept_map")
public class SourceToConceptMap {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"source_code\"", nullable = false)
  private String sourceCode;
  @Column(name = "\"source_concept_id\"", nullable = false)
  private Integer sourceConceptId;
  @Column(name = "\"source_vocabulary_id\"", nullable = false)
  private String sourceVocabularyId;
  @Column(name = "\"source_code_description\"", nullable = true)
  private String sourceCodeDescription;
  @Column(name = "\"target_concept_id\"", nullable = false)
  private Integer targetConceptId;
  @Column(name = "\"target_vocabulary_id\"", nullable = false)
  private String targetVocabularyId;
  @Column(name = "\"valid_start_date\"", nullable = false)
  private String validStartDate;
  @Column(name = "\"valid_end_date\"", nullable = false)
  private String validEndDate;
  @Column(name = "\"invalid_reason\"", nullable = true)
  private String invalidReason;
}