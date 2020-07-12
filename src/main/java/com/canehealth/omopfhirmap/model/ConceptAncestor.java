package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.ConceptAncestor")
@Table(name = "concept_ancestor")
public class ConceptAncestor {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"ancestor_concept_id\"", nullable = false)
  private Integer ancestorConceptId;
  @Column(name = "\"descendant_concept_id\"", nullable = false)
  private Integer descendantConceptId;
  @Column(name = "\"min_levels_of_separation\"", nullable = false)
  private Integer minLevelsOfSeparation;
  @Column(name = "\"max_levels_of_separation\"", nullable = false)
  private Integer maxLevelsOfSeparation;
}