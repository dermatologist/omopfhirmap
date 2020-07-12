package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.ConceptClass")
@Table(name = "concept_class")
public class ConceptClass {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"concept_class_id\"", nullable = false)
  private String conceptClassId;
  @Column(name = "\"concept_class_name\"", nullable = false)
  private String conceptClassName;
  @Column(name = "\"concept_class_concept_id\"", nullable = false)
  private Integer conceptClassConceptId;
}