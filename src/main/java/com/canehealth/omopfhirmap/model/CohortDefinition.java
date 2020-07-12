package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.CohortDefinition")
@Table(name = "cohort_definition")
public class CohortDefinition {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"cohort_definition_id\"", nullable = false)
  private Integer cohortDefinitionId;
  @Column(name = "\"cohort_definition_name\"", nullable = false)
  private String cohortDefinitionName;
  @Column(name = "\"cohort_definition_description\"", nullable = true)
  private String cohortDefinitionDescription;
  @Column(name = "\"definition_type_concept_id\"", nullable = false)
  private Integer definitionTypeConceptId;
  @Column(name = "\"cohort_definition_syntax\"", nullable = true)
  private String cohortDefinitionSyntax;
  @Column(name = "\"subject_concept_id\"", nullable = false)
  private Integer subjectConceptId;
  @Column(name = "\"cohort_initiation_date\"", nullable = true)
  private String cohortInitiationDate;
}