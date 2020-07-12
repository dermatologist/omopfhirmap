package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.ConceptRelationship")
@Table(name = "concept_relationship")
public class ConceptRelationship {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"concept_id_1\"", nullable = false)
  private Integer conceptId1;
  @Column(name = "\"concept_id_2\"", nullable = false)
  private Integer conceptId2;
  @Column(name = "\"relationship_id\"", nullable = false)
  private String relationshipId;
  @Column(name = "\"valid_start_date\"", nullable = false)
  private String validStartDate;
  @Column(name = "\"valid_end_date\"", nullable = false)
  private String validEndDate;
  @Column(name = "\"invalid_reason\"", nullable = true)
  private String invalidReason;
}