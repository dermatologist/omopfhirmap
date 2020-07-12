package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.FactRelationship")
@Table(name = "fact_relationship")
public class FactRelationship {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"domain_concept_id_1\"", nullable = false)
  private Integer domainConceptId1;
  @Column(name = "\"fact_id_1\"", nullable = false)
  private Integer factId1;
  @Column(name = "\"domain_concept_id_2\"", nullable = false)
  private Integer domainConceptId2;
  @Column(name = "\"fact_id_2\"", nullable = false)
  private Integer factId2;
  @Column(name = "\"relationship_concept_id\"", nullable = false)
  private Integer relationshipConceptId;
}