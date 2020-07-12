package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.Death")
@Table(name = "death")
public class Death {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"person_id\"", nullable = false)
  private Integer personId;
  @Column(name = "\"death_date\"", nullable = false)
  private String deathDate;
  @Column(name = "\"death_type_concept_id\"", nullable = false)
  private Integer deathTypeConceptId;
  @Column(name = "\"cause_concept_id\"", nullable = true)
  private Integer causeConceptId;
  @Column(name = "\"cause_source_value\"", nullable = true)
  private String causeSourceValue;
  @Column(name = "\"cause_source_concept_id\"", nullable = true)
  private Integer causeSourceConceptId;
}