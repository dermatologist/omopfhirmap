package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.ConceptSynonym")
@Table(name = "concept_synonym")
public class ConceptSynonym {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"concept_id\"", nullable = false)
  private Integer conceptId;
  @Column(name = "\"concept_synonym_name\"", nullable = false)
  private String conceptSynonymName;
  @Column(name = "\"language_concept_id\"", nullable = false)
  private Integer languageConceptId;
}