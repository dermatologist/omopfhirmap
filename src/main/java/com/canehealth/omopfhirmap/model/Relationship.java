package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.Relationship")
@Table(name = "relationship")
public class Relationship {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"relationship_id\"", nullable = false)
  private String relationshipId;
  @Column(name = "\"relationship_name\"", nullable = false)
  private String relationshipName;
  @Column(name = "\"is_hierarchical\"", nullable = false)
  private String isHierarchical;
  @Column(name = "\"defines_ancestry\"", nullable = false)
  private String definesAncestry;
  @Column(name = "\"reverse_relationship_id\"", nullable = false)
  private String reverseRelationshipId;
  @Column(name = "\"relationship_concept_id\"", nullable = false)
  private Integer relationshipConceptId;
}