package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.Vocabulary")
@Table(name = "vocabulary")
public class Vocabulary {

  @Id
  @Column(name = "\"vocabulary_id\"", nullable = false)
  private String vocabularyId;
  @Column(name = "\"vocabulary_name\"", nullable = false)
  private String vocabularyName;
  @Column(name = "\"vocabulary_reference\"", nullable = false)
  private String vocabularyReference;
  @Column(name = "\"vocabulary_version\"", nullable = false)
  private String vocabularyVersion;
  @Column(name = "\"vocabulary_concept_id\"", nullable = false)
  private Integer vocabularyConceptId;
}